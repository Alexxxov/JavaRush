package com.javarush.test.level04.lesson07.task04;

/* Положительные и отрицательные числа
Ввести с клавиатуры три целых числа. Вывести на экран количество положительных и количество отрицательных чисел в исходном наборе,
в следующем виде:
"количество отрицательных чисел: а", "количество положительных чисел: б", где а, б - искомые значения.
Пример для чисел 2 5 6:
количество отрицательных чисел: 0
количество положительных чисел: 3
Пример для чисел -2 -5 6:
количество отрицательных чисел: 2
количество положительных чисел: 1
*/

import java.io.*;

public class Solution
{
    public static void main(String[] args) throws Exception
    {
        BufferedReader reader = new BufferedReader( new InputStreamReader (System.in) );

        String str1 = reader.readLine();
        String str2 = reader.readLine();
        String str3 = reader.readLine();

        int num1 = Integer.parseInt(str1);
        int num2 = Integer.parseInt(str2);
        int num3 = Integer.parseInt(str3);
        int countplus=0;
        int countminus=0;

       if(num1>0)
           countplus++;
        if(num2>0)
           countplus++;
        if(num3>0)
           countplus++;
        if(num1<0)
           countminus++;
        if(num2<0)
           countminus++;
        if(num3<0)
           countminus++;
        System.out.println("количество отрицательных чисел: "+ countminus);
        System.out.println("количество положительных чисел: "+ countplus);

        //напишите тут ваш код

    }
}
