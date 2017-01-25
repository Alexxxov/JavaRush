package com.javarush.test.level28.lesson15.big01.model;

import com.javarush.test.level28.lesson15.big01.vo.Vacancy;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;

import java.io.IOException;
import java.util.Collections;
import java.util.List;

/**
 * Created by Admin on 26.01.2017.
 */
public class HHStrategy implements Strategy {

    private static final String URL_FORMAT = "http://hh.ru/search/vacancy?text=java+%s&page=%d";

    @Override
    public List<Vacancy> getVacancies(String searchString)
    {

        try
        {
            Document doc = Jsoup.connect("https://hh.ru").get();
        }
        catch (IOException e)
        {

        }
        return Collections.emptyList();
    }
}
