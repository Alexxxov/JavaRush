package com.javarush.test.level14.lesson08.bonus02;

/* НОД
Наибольший общий делитель (НОД).
Ввести с клавиатуры 2 целых положительных числа.
Вывести в консоль наибольший общий делитель.
*/

import java.io.BufferedReader;
import java.io.InputStreamReader;


//Алгоритм Евклида
public class Solution
{
    public static void main(String[] args) throws Exception
    {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        int n1;
        int n2;
        if ((n1 = Integer.parseInt(reader.readLine()))<0)
            throw new NumberFormatException("Number n1 cannot be negative.");
        if ((n2 = Integer.parseInt(reader.readLine()))<0)
            throw new NumberFormatException("Number n2 cannot be negative.");

        while(n1>0 && n2>0)
        {
            if (n1 > n2)
                n1 = n1 % n2;
            else
                n2 = n2 % n1;
        }
        System.out.println(n1 + n2);

    }
}
