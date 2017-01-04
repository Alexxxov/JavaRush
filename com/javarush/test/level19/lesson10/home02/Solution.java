package com.javarush.test.level19.lesson10.home02;

/* Самый богатый
В метод main первым параметром приходит имя файла.
В этом файле каждая строка имеет следующий вид:
имя значение
где [имя] - String, [значение] - double. [имя] и [значение] разделены пробелом

Для каждого имени посчитать сумму всех его значений
Вывести в консоль имена, у которых максимальная сумма
Имена разделять пробелом либо выводить с новой строки
Закрыть потоки. Не использовать try-with-resources

Пример входного файла:
Петров 0.501
Иванов 1.35
Петров 0.85

Пример вывода:
Петров
*/

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Map;
import java.util.TreeMap;

public class Solution {
    public static void main(String[] args) throws IOException {

        BufferedReader fileReader = new BufferedReader(new FileReader(args[0]));

        TreeMap<String, Double> map = new TreeMap<>();

        String line;
        while ((line = fileReader.readLine()) != null)
        {
            String[] str = line.split(" ");
            Double value = Double.parseDouble(str[1]);
            map.put(str[0] ,map.get(str[0]) == null ? value : map.get(str[0]) + value);
        }
        fileReader.close();

//        Double max = map.lastEntry().getValue();
//
//        for(Map.Entry entry: map.entrySet())
//            if (max.equals(entry.getValue()))
//                System.out.println(entry.getKey());


        Double max = Double.MIN_VALUE;
        for (Map.Entry<String, Double> pair : map.entrySet())
        {
            max = Math.max(max, pair.getValue());
        }
        for (Map.Entry<String, Double> pair : map.entrySet())
        {
            if (pair.getValue().equals(max))
            {
                System.out.println(pair.getKey());
            }
        }

    }
}
