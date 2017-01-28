package com.javarush.test.level28.lesson15.big01.model;

import com.javarush.test.level28.lesson15.big01.vo.Vacancy;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Admin on 26.01.2017.
 */
public class HHStrategy implements Strategy {

    private static final String URL_FORMAT = "http://hh.ru/search/vacancy?text=java+%s&page=%d";
    //https://hh.ru/search/vacancy?text=java+Москва&enable_snippets=true&clusters=true&page=1
    //http://javarush.ru/testdata/big28data.html
    //http://hh.ua/search/vacancy?text=java+%s&page=%d

    @Override
    public List<Vacancy> getVacancies(String searchString)
    {
        List<Vacancy> vacancyList = new ArrayList<>();
        try
        {
            int pageCounter = 0;
           while (true)
           {
                Document doc = getDocument(searchString, pageCounter);
                if (doc == null)
                    break;
                Elements elements = doc.getElementsByAttributeValue("data-qa","vacancy-serp__vacancy");

                if (!elements.isEmpty())
                {
                    for (Element elem: elements)
                    {
                        Vacancy vacancy = new Vacancy();

                        //можно добавить требования и обязанности
                        //"vacancy-serp__vacancy_snippet_responsibility"
                        //"vacancy-serp__vacancy_snippet_requirement"

                        vacancy.setSiteName(doc.title());
                        vacancy.setTitle(elem.getElementsByAttributeValue("data-qa", "vacancy-serp__vacancy-title").text());
                        vacancy.setCity(elem.getElementsByAttributeValue("data-qa", "vacancy-serp__vacancy-address").text());
                        vacancy.setCompanyName(elem.getElementsByAttributeValue("data-qa", "vacancy-serp__vacancy-employer").text());
                        vacancy.setUrl(elem.getElementsByAttributeValue("data-qa", "vacancy-serp__vacancy-title").attr("href"));
                        vacancy.setSalary(elem.getElementsByAttributeValue("data-qa", "vacancy-serp__vacancy-compensation").text());
                        vacancyList.add(vacancy);
                    }
                }
                else
                    break;
                ++pageCounter;
            }

        }
        catch (IOException e)
        {

        }
        return vacancyList;
    }

    protected Document getDocument(String searchString, int page) throws IOException
    {
        String ref = String.format(URL_FORMAT,searchString, page);
        return Jsoup.connect(ref).userAgent("Chrome/55.0.2883.87").referrer("https://hh.livetex.ru/client.html").get();
    }
}
