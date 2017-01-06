package com.javarush.test.level27.lesson15.big01;

import com.javarush.test.level27.lesson15.big01.kitchen.Dish;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Admin on 05.01.2017.
 */
public class ConsoleHelper {

    private static BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

    public static void writeMessage(String message)
    {
        System.out.println(message);
    }

    public static String readString() throws IOException
    {
        return reader.readLine();
    }

    public static List<Dish> getAllDishesForOrder() throws IOException
    {
        List<Dish> dishes = new ArrayList<>();
        writeMessage("Would you please choose desired dishes!");
        writeMessage(Dish.allDishesToString());
        String s = readString();
        while (!s.equalsIgnoreCase("exit") && !s.equals(""))
        {
            try
            {
                dishes.add(Dish.valueOf(s));
            }
            catch (IllegalArgumentException e)
            {
                ConsoleHelper.writeMessage(s + "is not found on Menu. Try again!");
            }
            s = readString();
        }
        return dishes;

    }


}
