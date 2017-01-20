package com.javarush.test.level27.lesson15.big01;

import com.javarush.test.level27.lesson15.big01.kitchen.Cook;
import com.javarush.test.level27.lesson15.big01.kitchen.Order;
import com.javarush.test.level27.lesson15.big01.statistic.StatisticEventManager;

import java.util.Observable;
import java.util.Observer;
import java.util.concurrent.LinkedBlockingQueue;

/**
 * Created by Admin on 20.01.2017.
 */
public class OrderManager implements Observer {

    private static LinkedBlockingQueue<Order> orderQueue;

    public OrderManager()
    {
        orderQueue = new LinkedBlockingQueue<>();

        final Thread deamonThread = new Thread(new Runnable() {
            @Override
            public void run()
            {
                try
                {
                    while (true)
                    {
                        if (!orderQueue.isEmpty())
                        {
                            for (Cook ck : StatisticEventManager.getInstance().getCooks())
                            {
                                if (ck.isBusy() == true)
                                    continue;
                                else
                                {
                                    Order order = orderQueue.poll();
                                    if (order != null)
                                        ck.startCookingOrder(order);
                                }
                            }
                        }

                        Thread.sleep(10);
                    }
                }
                catch (InterruptedException e)
                {}
            }
        });
        deamonThread.setDaemon(true);
        deamonThread.start();
    }

    @Override
    public void update(Observable o, Object arg)
    {
        orderQueue.add((Order) arg);
    }
}
