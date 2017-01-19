package com.javarush.test.level27.lesson15.big01;

import com.javarush.test.level27.lesson15.big01.kitchen.Order;

import java.util.Observable;
import java.util.Observer;
import java.util.concurrent.LinkedBlockingQueue;

/**
 * Created by Admin on 20.01.2017.
 */
public class OrderManager implements Observer {

    private static LinkedBlockingQueue<Order> orderQueue;

    @Override
    public void update(Observable o, Object arg)
    {
        orderQueue.add((Order) arg);
    }
}
