package com.javarush.test.level14.lesson08.home10;

/**
 * Created by Admin on 25.09.2016.
 */
public class Singleton
{

    private static Singleton instance=null;
    public static Singleton getInstance()
    {
        if(instance==null) {instance=new Singleton(); return instance;}
        else
            return instance;
    }
    private Singleton(){}
//    private static final Singleton sg = new Singleton();
//
//    private Singleton(){}
//
//    public static Singleton getInstance()
//    {
//        return sg;
//    }
}
