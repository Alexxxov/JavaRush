package com.javarush.test.level28.lesson15.big01.view;

import com.javarush.test.level28.lesson15.big01.Controller;

import java.util.List;

/**
 * Created by Admin on 28.01.2017.
 */
public interface View {
    <T> List<T> update(List<T> vacancies);
    void setController(Controller controller);
}
