package com.javarush.test.level04.lesson04.task10;

/* Три числа
Ввести с клавиатуры три целых числа. Определить, имеется ли среди них хотя бы одна пара равных между собой чисел.
Если такая пара существует, вывести на экран числа через пробел. Если все три числа равны между собой, то вывести все три.
Пример для чисел 1 2 2:
2 2
Пример для чисел 2 2 2:
2 2 2
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

//        if ((num1 == num2) && (num1==num3))
//            System.out.print(num1 + " " + num2 + " " + num3 + " ");
         if((num1==num2)||(num1==num3))
            System.out.print(num1 + " ");
//            System.out.println("xer");
         if((num2==num1)||(num2==num3))
            System.out.print(num2 + " ");
            //System.out.println("xer");
         if((num3==num1)||(num3==num2))
             //1System.out.println("xer");
            System.out.print(num3 + " ");

        //напишите тут ваш код

    }
}