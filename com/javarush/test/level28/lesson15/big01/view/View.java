package com.javarush.test.level28.lesson15.big01.view;

import com.javarush.test.level28.lesson15.big01.Controller;
import com.javarush.test.level28.lesson15.big01.vo.Vacancy;
import javafx.collections.ObservableList;

import java.util.List;

/**
 * Created by Admin on 28.01.2017.
 */
public interface View {
    <T> ObservableList<T> update(List<T> vacancies);
    void setController(Controller controller);
}
