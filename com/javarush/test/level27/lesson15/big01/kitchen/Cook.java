package com.javarush.test.level27.lesson15.big01.kitchen;

import com.javarush.test.level27.lesson15.big01.ConsoleHelper;
import com.javarush.test.level27.lesson15.big01.Tablet;
import com.javarush.test.level27.lesson15.big01.statistic.StatisticManager;
import com.javarush.test.level27.lesson15.big01.statistic.event.CookedOrderEventDataRow;

import java.util.Observable;
import java.util.Observer;

/**
 * Created by Admin on 06.01.2017.
 */
public class Cook extends Observable implements Observer {

    private String name;

    public Cook(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return name;
    }


    @Override
    public void update(Observable o, Object arg) {
        StatisticManager.getInstance().register(new CookedOrderEventDataRow(((Tablet) o).toString(), this.name, ((Order) arg).getTotalCookingTime() * 60, ((Order) arg).getDishes()));
        ConsoleHelper.writeMessage(String.format("Start cooking - %s, cooking time %dmin", arg.toString(), ((Order) arg).getTotalCookingTime()));
        setChanged();
        notifyObservers(arg);
    }
}
