package com.javarush.test.level08.lesson11.home05;

import sun.beans.editors.IntegerEditor;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;


/* Мама Мыла Раму. Теперь с большой буквы
Написать программу, которая вводит с клавиатуры строку текста.
Программа заменяет в тексте первые буквы всех слов на заглавные.
Вывести результат на экран.

Пример ввода:
  мама     мыла раму.

Пример вывода:
  Мама     Мыла Раму.
*/

public class Solution
{
    public static void main(String[] args) throws IOException
    {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        char[] arr = reader.readLine().toCharArray();


        for (int i = 0; i < arr.length-1; i++) {

            if (Character.isLetter(arr[i+1]) && Character.isWhitespace(arr[i]))
                arr[i+1] = Character.toUpperCase(arr[i+1]);
        }
        for (int i = 0; i < arr.length ; i++)
        {
            System.out.print(arr[i]);
        }


        //напишите тут ваш код
    }


}
