package com.javarush.test.level27.lesson15.big01;


import com.javarush.test.level27.lesson15.big01.kitchen.Cook;
import com.javarush.test.level27.lesson15.big01.kitchen.Order;
import com.javarush.test.level27.lesson15.big01.kitchen.Waitor;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.LinkedBlockingQueue;

/**
 * Created by Admin on 05.01.2017.
 */
public class Restaurant {

    private final static int ORDER_CREATING_INTERVAL = 100;

    private final static LinkedBlockingQueue<Order> QUEUE = new LinkedBlockingQueue<>();

    public static void main(String[] args) {

        List<Tablet> allTablets = new ArrayList<>();

        Cook cook1 = new Cook("Ivanov");
        cook1.setQueue(QUEUE);
        Cook cook2 = new Cook("Petrov");
        cook2.setQueue(QUEUE);

        Waitor waitor = new Waitor();
        cook1.addObserver(waitor);
        cook2.addObserver(waitor);

        for (int i = 0; i < 5; i++)
        {
            Tablet tablet = new Tablet(i+1);
            tablet.setQueue(QUEUE);
            allTablets.add(tablet);
        }

        Thread cook1Thr = new Thread(cook1);
        cook1Thr.start();
        Thread cook2Thr = new Thread(cook2);
        cook2Thr.start();

        RandomOrderGeneratorTask generator = new RandomOrderGeneratorTask(allTablets, ORDER_CREATING_INTERVAL);
        Thread randomOrderGenThr = new Thread(generator);
        randomOrderGenThr.start();
        try
        {
            Thread.sleep(1000);
        }
        catch(InterruptedException e)
        {}
        randomOrderGenThr.interrupt();


        DirectorTablet directorTablet = new DirectorTablet();
        directorTablet.printAdvertisementProfit();
        directorTablet.printCookWorkloading();
        directorTablet.printActiveVideoSet();
        directorTablet.printArchivedVideoSet();
    }
}
