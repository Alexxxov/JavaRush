package com.javarush.test.level19.lesson05.task02;

/* Считаем слово
Считать с консоли имя файла.
Файл содержит слова, разделенные знаками препинания.
Вывести в консоль количество слов "world", которые встречаются в файле.
Закрыть потоки. Не использовать try-with-resources
*/

import java.io.*;

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        BufferedReader fr = new BufferedReader(new FileReader(reader.readLine()));
        reader.close();
        int counter = 0;
        String line;
        while ((line = fr.readLine())!=null)
        {
            String[] arr =  line.replaceAll("\\p{Punct}"," ").split(" ");
            for(String str: arr)
                if("world".equalsIgnoreCase(str))
                    counter++;
        }
        fr.close();
        System.out.println(counter);

    }
}
