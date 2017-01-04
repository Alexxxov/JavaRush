package com.javarush.test.level07.lesson06.task02;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;

/* Самая длинная строка
1. Создай список строк.
2. Считай с клавиатуры 5 строк и добавь в список.
3. Используя цикл, найди самую длинную строку в списке.
4. Выведи найденную строку на экран.
5. Если таких строк несколько, выведи каждую с новой строки.
*/
public class Solution
{
    public static void main(String[] args) throws Exception
    {
        ArrayList<String> strList = new ArrayList<>();

        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        for (int i = 0; i < 5; i++)
        {
            String str = reader.readLine();
            strList.add(str);
        }

        int Slength = strList.get(0).length();

        for (int i = 0; i < 4; i++)
            if (strList.get(i).length() < strList.get(i + 1).length())
                Slength = strList.get(i + 1).length();

        for (int i = 0; i < 5; i++)
            if (Slength == strList.get(i).length())
                System.out.println(strList.get(i));
    }

}
