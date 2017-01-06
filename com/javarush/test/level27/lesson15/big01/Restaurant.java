package com.javarush.test.level27.lesson15.big01;


import com.javarush.test.level27.lesson15.big01.kitchen.Cook;

import java.io.IOException;

/**
 * Created by Admin on 05.01.2017.
 */
public class Restaurant {

    public static void main(String[] args) throws IOException {
        Cook c = new Cook("Amigo");
        Tablet t = new Tablet(5);
        t.addObserver(c);
        t.createOrder();

    }

}
