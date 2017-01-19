package com.javarush.test.level27.lesson15.big01;

import com.javarush.test.level27.lesson15.big01.ad.AdvertisementManager;
import com.javarush.test.level27.lesson15.big01.ad.NoVideoAvailableException;
import com.javarush.test.level27.lesson15.big01.kitchen.Order;
import com.javarush.test.level27.lesson15.big01.kitchen.TestOrder;

import java.io.IOException;
import java.util.Observable;
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

    public void createTestOrder()
    {

        try
        {
            Order order = new TestOrder(this);
            createOrderSubroutine(order);
        }

        catch (IOException e)
        {
            logger.log(Level.SEVERE, "Console is unavailable.");
        }
    }

    public void createOrder()
    {
        try
        {
            Order order = new Order(this);
            createOrderSubroutine(order);

        }
        catch (IOException e)
        {
            logger.log(Level.SEVERE, "Console is unavailable.");
        }

    }

    private void createOrderSubroutine(Order order)
    {
        if (!order.isEmpty())
        {
            ConsoleHelper.writeMessage(order.toString());
            try
            {
                new AdvertisementManager(order.getTotalCookingTime() * 60).processVideos();
                setChanged();
                notifyObservers(order);
            }
            catch (NoVideoAvailableException e)
            {
                logger.log(Level.INFO, "No video is available for the order " + order);
            }
        }
    }

    @Override
    public String toString() {
        return "Tablet{number=" + number + "}";
    }
}
