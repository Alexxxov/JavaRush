package com.javarush.test.level08.lesson11.bonus01;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

/* Номер месяца
Программа вводит с клавиатуры имя месяца и выводит его номер на экран в виде: «May is 5 month».
Используйте коллекции.
*/

public class Solution
{
    public static void main(String[] args) throws IOException
    {
       BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String s = reader.readLine();
        ArrayList<String> list = new ArrayList<>();
        list.add("JANUARY");
        list.add("FEBRUARY");
        list.add("MARCH");
        list.add("APRIL");
        list.add("MAY");
        list.add("JUNE");
        list.add("JULY");
        list.add("AUGUST");
        list.add("SEPTEMBER");
        list.add("OCTOBER");
        list.add("NOVEMBER");
        list.add("DECEMBER");
        for (int i = 0; i < list.size() ; i++)
        {
            if (list.get(i).equalsIgnoreCase(s))
            System.out.println(s + " is " + (i+1) + " month");
        }

    }

}
