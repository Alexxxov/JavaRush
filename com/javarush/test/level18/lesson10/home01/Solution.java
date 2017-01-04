package com.javarush.test.level18.lesson10.home01;

/* Английские буквы
В метод main первым параметром приходит имя файла.
Посчитать количество букв английского алфавита, которое есть в этом файле.
Вывести на экран число (количество букв)
Закрыть потоки. Не использовать try-with-resources
*/


import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;

public class Solution {
    public static void main(String[] args) throws IOException {

        FileInputStream fileInputStream = new FileInputStream(args[0]);
        int letterCounter = 0;

        while(fileInputStream.available()>0)
        {
            int data = fileInputStream.read();
            if(Character.toString((char)data).matches("[a-zA-Z]"))
                letterCounter++;
        }

        System.out.println(letterCounter);
        fileInputStream.close();

    }
}
