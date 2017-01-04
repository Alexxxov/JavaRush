package com.javarush.test.level05.lesson12.home05;

/* Вводить с клавиатуры числа и считать их сумму
Вводить с клавиатуры числа и считать их сумму, пока пользователь не введёт слово «сумма». Вывести на экран полученную сумму.
*/

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Solution
{
    public static void main(String[] args) throws Exception
    {
//        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
//
//        int currNum = 0;
//
//
//
//        while (true)
//        {
//            String s = reader.readLine();
//            if (!s.equals("сумма"))
//            {
//                int num = Integer.parseInt(s);
//                currNum += num;
//                System.out.println(currNum);
//            }
//            else
//            {
//                System.out.println(currNum);
//                break;
//            }
//
//
//
//        }
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int sum = 0;
        while (true)
        {

            String q = reader.readLine();
            if (q.equals("сумма"))
            {
                System.out.println(sum);
                break;
            }
            int q1 = Integer.parseInt(q);
            sum+= q1;

//Напишите тут ваш код

        }
    }


}
