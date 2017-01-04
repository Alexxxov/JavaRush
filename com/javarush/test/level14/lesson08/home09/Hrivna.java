package com.javarush.test.level14.lesson08.home09;

/**
 * Created by Admin on 25.09.2016.
 */
public class Hrivna extends Money
{
    public Hrivna(double amount)
    {
        super(amount);
    }

    @Override
    public String getCurrencyName()
    {
        return "HRN";
    }
}
