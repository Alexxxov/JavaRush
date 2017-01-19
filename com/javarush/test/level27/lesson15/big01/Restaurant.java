package com.javarush.test.level27.lesson15.big01;


import com.javarush.test.level27.lesson15.big01.kitchen.Cook;
import com.javarush.test.level27.lesson15.big01.kitchen.Waitor;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Admin on 05.01.2017.
 */
public class Restaurant {

    private static final int ORDER_CREATING_INTERVAL = 100;

    public static void main(String[] args) {

        List<Tablet> allTablets = new ArrayList<>();
        Cook cook1 = new Cook("Ivanov");
        Cook cook2 = new Cook("Petrov");
        Waitor waitor = new Waitor();
        cook1.addObserver(waitor);
        cook2.addObserver(waitor);
        for (int i = 1; i <= 10; i++)
        {
            allTablets.add(new Tablet(i));

            if(i % 2 == 0)
                allTablets.get(i-1).addObserver(cook1);
            else
                allTablets.get(i-1).addObserver(cook2);
        }
        RandomOrderGeneratorTask generator = new RandomOrderGeneratorTask(allTablets, ORDER_CREATING_INTERVAL);
        Thread thread = new Thread(generator);
        thread.start();
        try
        {
            thread.join();
        }
        catch(InterruptedException e)
        {}

        thread.interrupt();

        DirectorTablet directorTablet = new DirectorTablet();
        directorTablet.printAdvertisementProfit();
        directorTablet.printCookWorkloading();
        directorTablet.printActiveVideoSet();
        directorTablet.printArchivedVideoSet();
    }

}
