package com.javarush.test.level15.lesson12.bonus02;

/**
 * Created by Admin on 30.09.2016.
 */
public abstract class DrinkMaker
{
    abstract void getRightCup();
    abstract void putIngredient();
    abstract void pour();
    void makeDrink()    {
        getRightCup();
        putIngredient();
        pour();
    }
}
