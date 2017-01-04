package com.javarush.test.level14.lesson08.bonus03;

/**
 * Created by Admin on 09.12.2016.
 */
public class Singleton
{
    private static final Singleton INSTANCE = new Singleton();

    private Singleton() {}

    public static Singleton getInstance(){
        return INSTANCE;
    }
}
