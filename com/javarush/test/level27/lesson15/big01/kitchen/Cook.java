package com.javarush.test.level27.lesson15.big01.kitchen;

import com.javarush.test.level27.lesson15.big01.ConsoleHelper;
import com.javarush.test.level27.lesson15.big01.Tablet;
import com.javarush.test.level27.lesson15.big01.statistic.StatisticEventManager;
import com.javarush.test.level27.lesson15.big01.statistic.event.CookedOrderEventDataRow;

import java.util.Observable;
import java.util.Observer;
import java.util.concurrent.LinkedBlockingQueue;

/**
 * Created by Admin on 06.01.2017.
 */
public class Cook extends Observable implements Runnable {

    private String name;
    private boolean busy;
    private LinkedBlockingQueue<Order> queue;


    public Cook(String name)
    {
        this.name = name;
    }

    public boolean isBusy() {
        return busy;
    }

    @Override
    public String toString() {
        return name;
    }

    @Override
    public void run()
    {
        try
        {
            while (!Thread.currentThread().isInterrupted())
            {
                if (!queue.isEmpty())
                {
                    Order order = queue.take();
                    if (order != null)
                        startCookingOrder(order);
                }
            }
        }
        catch (InterruptedException e)
        {}
    }

    public void startCookingOrder(Order order)
    {
        busy = true;

        ConsoleHelper.writeMessage(String.format("Start cooking - %s, cooking time %dmin", order.toString(), order.getTotalCookingTime()));
        try
        {
            Thread.sleep(order.getTotalCookingTime() * 10);
        }
        catch (InterruptedException e)
        {}
        StatisticEventManager.getInstance().register(new CookedOrderEventDataRow(order.getTablet().toString(), this.name,
                order.getTotalCookingTime() * 60, order.getDishes()));

        setChanged();
        notifyObservers(order);

        busy = false;
    }

    public void setQueue(LinkedBlockingQueue<Order> queue)
    {
        this.queue = queue;
    }
}
