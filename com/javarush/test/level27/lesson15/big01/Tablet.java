package com.javarush.test.level27.lesson15.big01;

import com.javarush.test.level27.lesson15.big01.ad.AdvertisementManager;
import com.javarush.test.level27.lesson15.big01.kitchen.Order;

import java.io.IOException;
import java.util.Observable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * Created by Admin on 05.01.2017.
 */
public class Tablet extends Observable {

    private final int number;
    private static Logger logger = Logger.getLogger(Tablet.class.getName());

    public Tablet(int number) {
        this.number = number;
    }

    public void createOrder()
    {
        final Order order;
        try
        {
                order = new Order(this);
                if (!order.isEmpty())
                {
                    ConsoleHelper.writeMessage(order.toString());

                    ExecutorService executor = Executors.newCachedThreadPool();
                    executor.execute(new Thread()
                    {
                        @Override
                        public void run()
                        {
                            new AdvertisementManager(order.getTotalCookingTime()).processVideos();
                        }
                    });
                    setChanged();
                    notifyObservers(order);
                }
        }
        catch (IOException e)
        {
            logger.log(Level.SEVERE, "Console is unavailable.");
        }

    }

    @Override
    public String toString() {
        return "Tablet{number=" + number + "}";
    }
}
