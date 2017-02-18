package com.javarush.test.level28.lesson15.big01.model;

import com.javarush.test.level28.lesson15.big01.view.View;
import javafx.collections.ObservableList;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Admin on 28.01.2017.
 */
public class Model {

    private View view;
    private List<Provider> providers;

    public Model(View view, List<Provider> providers) {
        if (view == null || providers == null)
            throw new IllegalArgumentException();
        this.view = view;
        this.providers = providers;
    }

    public <T> List<T> userQuery(String query)
    {
        List<T> vacancies = new ArrayList<>();
        List<T> vacancyPerProvider;
        for (Provider p: providers)
        {
            vacancyPerProvider = p.getJavaVacancies(query);
            vacancies.addAll(vacancyPerProvider);
        }

       return view.update(vacancies);
    }
}
