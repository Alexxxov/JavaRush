package com.javarush.test.level21.lesson16.big01;

import java.util.Random;

/**
 * Created by Admin on 08.11.2016.
 */
public class Horse
{
    private String name;
    private double speed;
    private double distance;

    public Horse(String name, double speed, double distance)
    {
        this.name = name;
        this.speed = speed;
        this.distance = distance;
    }

    public String getName()
    {
        return name;
    }

    public void setName(String name)
    {
        this.name = name;
    }

    public double getSpeed()
    {
        return speed;
    }

    public void setSpeed(double speed)
    {
        this.speed = speed;
    }

    public double getDistance()
    {
        return distance;
    }

    public void setDistance(double distance)
    {
        this.distance = distance;
    }

    public void move()
    {
        speed *= Math.random();
        distance += speed;
    }

    public void print()
    {

        for (int i = 0; i < Math.floor(distance) ; i++)
            System.out.print(".");
        System.out.print(this.getName());
        System.out.println();

    }
}
