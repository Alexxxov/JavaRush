package com.javarush.test.level18.lesson03.task04;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/* Самые редкие байты
Ввести с консоли имя файла
Найти байт или байты с минимальным количеством повторов
Вывести их на экран через пробел
Закрыть поток ввода-вывода
*/

public class Solution {
    public static void main(String[] args) throws Exception {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        FileInputStream fileInputStream = new FileInputStream(reader.readLine());
        reader.close();

        List<Integer> list = new ArrayList<>();
        Map<Integer,Integer> map = new HashMap<>();
        while (fileInputStream.available()>0)
        {

            int data = fileInputStream.read();
            list.add(data);
        }
        fileInputStream.close();
        int foundMin = 10000; // 10000 just to make it work properly
        for (Integer a: list)
        {
            int counter = 0;
            for (Integer b : list)
            {
                if (a == b)
                    counter++;
            }
            foundMin = Math.min(foundMin,counter);
            map.put(a, counter);
        }
        for (Map.Entry<Integer,Integer> ourByte: map.entrySet())
        {
            int val = ourByte.getValue();
            int key = ourByte.getKey();
            if(val==foundMin)
                System.out.print(key+" ");
        }
    }
}
