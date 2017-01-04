package com.javarush.test.level04.lesson04.task08;

/* Треугольник
Ввести с клавиатуры три числа а, b, c – стороны предполагаемого треугольника.
Определить возможность существования треугольника по сторонам. Результат вывести на экран в следующем виде:
"Треугольник существует." - если треугольник с такими сторонами существует.
"Треугольник не существует." - если треугольник с такими сторонами не существует.
Подсказка: Треугольник существует только тогда, когда сумма любых двух его сторон больше третьей.
Требуется сравнить каждую сторону с суммой двух других.
Если хотя бы в одном случае сторона окажется больше суммы двух других, то треугольника с такими сторонами не существует.
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
        if ((num1 < num2+num3) && (num2 < num1+num3) && (num3 < num1+num2))
            System.out.println("Треугольник существует.");
        else
            System.out.println("Треугольник не существует.");
        //напишите тут ваш код

    }
}