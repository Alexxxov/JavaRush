package com.javarush.test.level07.lesson12.bonus03;


import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;


/* Задача по алгоритмам
Задача: Написать программу, которая вводит с клавиатуры 20 чисел и выводит их в убывающем порядке.
*/

public class Solution
{
    public static void main(String[] args) throws Exception
    {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int[] array = new int[4];
        for (int i = 0; i < 4; i++)
        {
            array[i] = Integer.parseInt(reader.readLine());
        }

        sort(array);

        for (int i = array.length - 1; i >= 0; i--)
        {
            System.out.println(array[i]);

        }
    }

    public static void sort(int[] array)
    {
        Arrays.sort(array);
        //Напишите тут ваш код
    }
}
