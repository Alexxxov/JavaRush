package com.javarush.test.level28.lesson15.big01.view;

import com.javarush.test.level28.lesson15.big01.Controller;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

import java.util.List;

/**
 * Created by Admin on 28.01.2017.
 */
public class FXView implements View {

    private Controller controller;

    @Override
    public <T> List<T> update(List<T> vacancies)
    {
        return vacancies;
    }

    public <T> List<T> userInputQuery(String query)
    {
        return controller.userQuery(query.trim());
    }

    @Override
    public void setController(Controller controller) {
        this.controller = controller;
    }

}
