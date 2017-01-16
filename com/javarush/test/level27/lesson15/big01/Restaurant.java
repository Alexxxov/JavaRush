package com.javarush.test.level27.lesson15.big01;


import com.javarush.test.level27.lesson15.big01.kitchen.Cook;
import com.javarush.test.level27.lesson15.big01.kitchen.Waitor;

import java.io.IOException;

/**
 * Created by Admin on 05.01.2017.
 */
public class Restaurant {

    public static void main(String[] args) {
        Cook cook1 = new Cook("Ivanov");
        Cook cook2 = new Cook("Petrov");
        Tablet tablet1 = new Tablet(5);
        Tablet tablet2 = new Tablet(6);
        Waitor waitor = new Waitor();
        tablet1.addObserver(cook1);
        cook1.addObserver(waitor);
        tablet2.addObserver(cook2);
        cook2.addObserver(waitor);
        tablet1.createOrder();
        tablet1.createOrder();
        tablet2.createOrder();
        tablet2.createOrder();

        DirectorTablet directorTablet = new DirectorTablet();
        directorTablet.printAdvertisementProfit();
        directorTablet.printCookWorkloading();
        directorTablet.printActiveVideoSet();
        directorTablet.printArchivedVideoSet();
    }

}
