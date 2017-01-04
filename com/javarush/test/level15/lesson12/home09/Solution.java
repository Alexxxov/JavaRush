package com.javarush.test.level15.lesson12.home09;


/* Парсер реквестов
Считать с консоли URl ссылку.
Вывести на экран через пробел список всех параметров (Параметры идут после ? и разделяются &, например, lvl=15).
URL содержит минимум 1 параметр.
Если присутствует параметр obj, то передать его значение в нужный метод alert.
alert(double value) - для чисел (дробные числа разделяются точкой)
alert(String value) - для строк

Пример 1
Ввод:
http://javarush.ru/alpha/index.html?lvl=15&view&name=Amigo
Вывод:
lvl view name

Пример 2
Ввод:
http://javarush.ru/alpha/index.html?obj=3.14&name=Amigo
Вывод:
obj name
double 3.14
*/

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import java.util.regex.*;

public class Solution {

    public static void main(String[] args) throws IOException
    {

        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        String line = reader.readLine();
        line = line.replaceAll(".*(?=\\?)","");
        System.out.println(line);

        Pattern ptrn1 = Pattern.compile("(?<=\\?)([a-z]+)=(\\d+(?:\\.\\d+)?)"); // (?<=\?)([a-z]*)=(\d+\.\d+)?[\d]*?\&([a-z]*)[&=]?([a-z]*)
        Pattern ptrn2 = Pattern.compile("(?:[&]([a-z]+)(?:&|=))+");
        Matcher matcher = ptrn1.matcher(line);
        ptrn2.matcher(line);

        while(matcher.find())
        {
            System.out.println(matcher.group());
            for (int i = 1; i <= matcher.groupCount(); i++)
            if (matcher.group(i).matches("[a-z]+"))
                    alert(matcher.group(i));
            for (int i = 1; i <= matcher.groupCount(); i++)
            if (matcher.group(i).matches("\\d+\\.\\d+"))
                alert(Double.parseDouble(matcher.group(i)));
        break;
        }
    }


//                try
//                {
//
//                }
//                catch (IndexOutOfBoundsException e)
//                {
//                    e.printStackTrace();
//                }


//        if (matcher.find())
//        {
//            for (int i = matcher.start(); i < matcher.end() ; i++)
//            {
//                System.out.println(matcher.group(i));
//            }
//
//        }

//        while(matcher.matches())
//        {
//            if (matcher.group()..equals("obj"))
//                alert(matcher.group());
//            else
//            System.out.println(matcher.group());
//        }

    public static void alert(double value) {
        System.out.println("double " + value);
    }

    public static void alert(String value) {
        System.out.println("String " + value);
    }
}
