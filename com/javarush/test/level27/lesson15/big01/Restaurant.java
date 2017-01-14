package com.javarush.test.level27.lesson15.big01;


import com.javarush.test.level27.lesson15.big01.kitchen.Cook;
import com.javarush.test.level27.lesson15.big01.kitchen.Waitor;

import java.io.IOException;

/**
 * Created by Admin on 05.01.2017.
 */
public class Restaurant {

    public static void main(String[] args) {
        Cook cook = new Cook("Amigo");
        Tablet tablet = new Tablet(5);
        Waitor waitor = new Waitor();
        tablet.addObserver(cook);
        cook.addObserver(waitor);
        tablet.createOrder();
    }

}
