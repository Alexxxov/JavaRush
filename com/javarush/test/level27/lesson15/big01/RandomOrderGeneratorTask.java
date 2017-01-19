package com.javarush.test.level27.lesson15.big01;

import java.util.List;

/**
 * Created by Admin on 18.01.2017.
 */
public class RandomOrderGeneratorTask implements Runnable {

    private List<Tablet> allTablets;
    private int interval;

    public RandomOrderGeneratorTask(List<Tablet> allTablets, int interval)
    {
        this.allTablets = allTablets;
        this.interval = interval;
    }

    @Override
    public void run()
    {
        if (allTablets.isEmpty())
            return;
        try
        {
            while (!Thread.currentThread().isInterrupted())
            {
                Tablet tablet =  allTablets.get((int)(Math.random()* allTablets.size()));
                tablet.createTestOrder();
                Thread.sleep(interval);
            }
        }
        catch (InterruptedException e)
        {

        }
    }
}
