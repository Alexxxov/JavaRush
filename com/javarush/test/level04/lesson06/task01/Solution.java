package com.javarush.test.level04.lesson06.task01;

/* Минимум двух чисел
Ввести с клавиатуры два числа, и вывести на экран минимальное из них.
*/

import java.io.*;

public class Solution
{
    public static void main(String[] args) throws Exception
    {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String str1 = reader.readLine();
        int a1 = Integer.parseInt(str1);
        String str2 = reader.readLine();
        int b1 = Integer.parseInt(str2);
        int c;
        if(a1 < b1){ c=a1;}
        else { c=b1; }
        System.out.println(c);
        //напишите тут ваш код

    }
}