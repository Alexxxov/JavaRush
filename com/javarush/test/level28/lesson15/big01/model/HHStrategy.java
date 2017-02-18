package com.javarush.test.level28.lesson15.big01.model;

import com.javarush.test.level28.lesson15.big01.vo.Vacancy;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.io.IOException;
import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Admin on 26.01.2017.
 */
public class HHStrategy implements Strategy {

    private static final String URL_FORMAT = "https://hh.ru/search/vacancy?text=%s&enable_snippets=true&clusters=true&page=%d";
    //https://hh.ru/search/vacancy?text=java+Москва&enable_snippets=true&clusters=true&page=1
    //http://javarush.ru/testdata/big28data.html
    //http://hh.ua/search/vacancy?text=java+%s&page=%d

    @Override
    public List<Vacancy> getVacancies(String searchString)
    {
        // TODO !!!!! when search Водитель get 2000 vacancies instead of 6409 !!! use another data container
        List<Vacancy> vacancyList = new ArrayList<>();
        try
        {
            int pageCounter = 0;
           while (true)
           {
               Document doc = getDocument(searchString, pageCounter++);
               if (doc == null)
                   break;
               Elements vacanciesPerPage = doc.select("[data-qa~=(^vacancy-serp__vacancy$)|(^vacancy-serp__vacancy vacancy-serp__vacancy_premium$)]");

               if (vacanciesPerPage.isEmpty())
                    break;
               for (Element element: vacanciesPerPage)
               {
                   Vacancy vacancy = new Vacancy();
                   Elements elem;

                   vacancy.setSiteName("http://hh.ru/");

                   //можно добавить требования и обязанности
                   //"vacancy-serp__vacancy_snippet_responsibility"
                   //"vacancy-serp__vacancy_snippet_requirement"

                   elem = element.getElementsByAttributeValue("data-qa", "vacancy-serp__vacancy-title");
                   vacancy.setTitle(elem.size() != 0 ? elem.first().text() : "");
                   vacancy.setUrl(elem.size() != 0 ? elem.attr("href") : "");

                   elem = element.getElementsByAttributeValue("data-qa", "vacancy-serp__vacancy-compensation");
                   vacancy.setSalary(elem.size() != 0 ? elem.first().text() : "");

                   elem = element.getElementsByAttributeValue("data-qa", "vacancy-serp__vacancy-address");
                   vacancy.setCity(elem.size() != 0 ? elem.first().text() : "");

                   elem = element.getElementsByAttributeValue("data-qa", "vacancy-serp__vacancy-employer");
                   vacancy.setCompanyName(elem.size() != 0 ? elem.first().text() : "");

                   vacancyList.add(vacancy);
               }
           }
        }
        catch (IOException e)
        {}
        return vacancyList;
    }

    protected Document getDocument(String searchString, int page) throws IOException
    {
        String ref = String.format(URL_FORMAT, URLEncoder.encode(searchString, "UTF-8"), page);
        return Jsoup.connect(ref)
                .userAgent("Mozilla/5.0 (Windows NT 6.1; WOW64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/55.0.2883.87 Safari/537.36")
                .referrer("https://hh.ru/")
                .get();
    }
}
