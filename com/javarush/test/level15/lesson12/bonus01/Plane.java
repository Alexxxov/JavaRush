package com.javarush.test.level15.lesson12.bonus01;

/**
 * Created by Admin on 30.09.2016.
 */
public class Plane implements Flyable
{
    int passengers;
    Plane(int passengers)
    {
        this.passengers = passengers;
    }

    @Override
    public void fly()
    {

    }
}
