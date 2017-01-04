package com.javarush.test.level19.lesson10.home03;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.*;

/* Хуан Хуанович
В метод main первым параметром приходит имя файла.
В этом файле каждая строка имеет следующий вид:
имя день месяц год
где [имя] - может состоять из нескольких слов, разделенных пробелами, и имеет тип String
[день] - int, [месяц] - int, [год] - int
данные разделены пробелами

Заполнить список PEOPLE импользуя данные из файла
Закрыть потоки. Не использовать try-with-resources

Пример входного файла:
Иванов Иван Иванович 31 12 1987
Вася 15 5 2013
*/

public class Solution {
    public static final List<Person> PEOPLE = new ArrayList<Person>();

    public static void main(String[] args) throws IOException {

        BufferedReader fileReader = new BufferedReader(new FileReader(args[0]));

        String line;

        while ((line = fileReader.readLine()) != null)
        {
            String[] str = line.split(" ");
            StringBuilder sb = new StringBuilder();
            for (int i = 0; i < str.length - 3 ; i++)
            {
                sb.append(str[i]);
                sb.append(" ");
            }
            int year = Integer.parseInt(str[str.length-1]);
            int month = Integer.parseInt(str[str.length-2])-1;
            int day = Integer.parseInt(str[str.length-3]);
            Date birthDay = new GregorianCalendar(year, month, day).getTime();
            Person person = new Person(sb.toString().trim(),birthDay);
            PEOPLE.add(person);

        }
        fileReader.close();

    }

}
