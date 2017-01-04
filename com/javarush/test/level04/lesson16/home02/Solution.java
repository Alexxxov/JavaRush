package com.javarush.test.level04.lesson16.home02;

import java.io.*;

/* Среднее такое среднее
Ввести с клавиатуры три числа, вывести на экран среднее из них. Т.е. не самое большое и не самое маленькое.
*/

public class Solution
{
    public static void main(String[] args)   throws Exception
    {
        BufferedReader reader = new BufferedReader( new InputStreamReader (System.in) );

        String num1 = reader.readLine();
        String num2 = reader.readLine();
        String num3 = reader.readLine();
        int one = Integer.parseInt(num1);
        int two = Integer.parseInt(num2);
        int three = Integer.parseInt(num3);
        int max = 0;
        int mid = 0;
        int min = 0;
        if (one >= two && one >= three)
        {
            max = one;
            if (two >= three)
            {
                mid = two;
                min = three;
            }
            else
            {
                mid = three;
                min = two;
            }
        }//напишите тут ваш код

        if (two >= one && two >= three)
        {
            max = two;
            if (one >= three)
            {
                mid = one;
                min = three;
            }
            else
            {
                mid = three;
                min = one;
            }
        }

        if (three >= two && three >= one)
        {
            max = three;
            if (two >= one)
            {
                mid = two;
                min = one;
            }
            else
            {
                mid = one;
                min = two;
            }
        }

        System.out.print(  mid );
    }
}
