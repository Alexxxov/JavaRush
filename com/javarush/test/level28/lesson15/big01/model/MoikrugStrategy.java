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
 * Created by Admin on 04.02.2017.
 */
public class MoikrugStrategy implements Strategy {

    private static final String URL_FORMAT = "https://moikrug.ru/vacancies?q=%s&page=%d";
    //http://javarush.ru/testdata/big28data2.html
    //https://moikrug.ru/vacancies?q=java+%s&page=%d
    //https://moikrug.ru/vacancies?city_id=&location=&page=%d&q=java+%s&utf8=✓

    @Override
    public List<Vacancy> getVacancies(String searchString)
    {
        List<Vacancy> vacancyList = new ArrayList<>();
        try
        {
            int pageCounter = 0;
            while (true)
            {
                Document doc = getDocument(searchString, ++pageCounter);
                if (doc == null)
                    break;
                Elements vacanciesPerPage = doc.select("[id^=job_]");

                if (vacanciesPerPage.isEmpty())
                    break;

                for (Element element : vacanciesPerPage)
                {
                    Vacancy vacancy = new Vacancy();

                    vacancy.setSiteName("https://moikrug.ru/");

                    Elements elem;

                    vacancy.setTitle(element.select(".title").first().text());
                    vacancy.setUrl(vacancy.getSiteName() + element.select(".title").first().select("a").first().attr("href").substring(1));
                    vacancy.setCompanyName(element.select(".company_name").first().text());

                    elem = element.select(".salary");
                    vacancy.setSalary(elem.size() != 0 ? elem.first().text() : "");

                    elem = element.select(".location");
                    vacancy.setCity(elem.size() != 0 ? elem.first().text() : "");

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
        String ref = String.format(URL_FORMAT, searchString, page);
        return Jsoup.connect(ref)
                .userAgent("Chrome/55.0.2883.87")
                .referrer("https://moikrug.ru/")
                .get();
    }
}




