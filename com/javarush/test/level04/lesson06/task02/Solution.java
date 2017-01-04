package com.javarush.test.level04.lesson06.task02;

/* Максимум четырех чисел
Ввести с клавиатуры четыре числа, и вывести максимальное из них.
*/

import java.io.*;


public class Solution
{

    public static void main(String[] args) throws Exception
    {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String str1 = reader.readLine();
        int num1 = Integer.parseInt(str1);
        String str2 = reader.readLine();
        int num2 = Integer.parseInt(str2);
        String str3 = reader.readLine();
        int num3 = Integer.parseInt(str3);
        String str4 = reader.readLine();
        int num4 = Integer.parseInt(str4);

        if ((num1>num2&&num1>num3&&num1>num4))
            System.out.println(num1);
        else if ((num2>num1&&num2>num3&&num2>num4))
            System.out.println(num2);
        else if ((num3>num2&&num3>num1&&num3>num4))
            System.out.println(num3);
        else if ((num4>num2&&num4>num3&&num4>num1))
            System.out.println(num4);
        //напишите тут ваш код

    }
}
