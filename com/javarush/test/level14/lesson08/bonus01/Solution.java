package com.javarush.test.level14.lesson08.bonus01;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

/* Нашествие эксепшенов
Заполни массив exceptions 10 различными эксепшенами.
Первое исключение уже реализовано в методе initExceptions.
*/

public class Solution
{
    public static List<Exception> exceptions = new ArrayList<Exception>();

    public static void main(String[] args)
    {
        initExceptions();

        for (Exception exception : exceptions)
        {
            System.out.println(exception);
        }
    }

    private static void initExceptions()
    {   //it's first exception

        for (int j = 0; j < 10; j++){
            try
            {
                float i = 1 / 0;

            } catch (Exception e)
            {
                exceptions.add(e);
            }
        }
//        try
//        {
//            float i = 1 / 0;
//
//        } catch (ArithmeticException e)
//        {
//            exceptions.add(e);
//        }
//
//
//        // 2.
//        try
//        {
//            List list = null;
//            list.add(1);
//        } catch (NullPointerException e) {
//            exceptions.add(e);
//        }
//
//        // 3.
//        try {
//            InputStream is = new FileInputStream("111.txt");
//        } catch(FileNotFoundException e) {
//            exceptions.add(e);
//        }
//
//        // 4.
//        try {
//            int[] numbs = new int[10];
//            numbs[100] = 10;
//        } catch (IndexOutOfBoundsException e) {
//            exceptions.add(e);
//        }
//
//        // 5.
//        try {
//            Integer.parseInt("none");
//
//        } catch (NumberFormatException e) {
//            exceptions.add(e);
//        }
//
//        // 6.
//        try {
//
//            Object x[] = new String[10];
//            x[0] = Integer.valueOf(100);
//
//        } catch (ArrayStoreException e) {
//            exceptions.add(e);
//        }
//
//        // 7.
//        try {
//            Object i = Integer.valueOf(42);
//            String s = (String)i;
//        } catch (ClassCastException e) {
//            exceptions.add(e);
//        }
//
//        // 8.
//        try {
//            int[] numbs = new int[-1];
//
//        }catch(NegativeArraySizeException e) {
//            exceptions.add(e);
//        }
//
//        // 9.
//        try {
//            throw new UnsupportedOperationException("Invalid operation for sorted list.");
//        }catch(UnsupportedOperationException e) {
//            exceptions.add(e);
//        }
//
//        // 10.
//        try {
//            throw new SecurityException("Hmmm maybe SecurityException");
//        } catch (SecurityException e) {
//            exceptions.add(e);
//        }


        //Add your code here

    }
}
