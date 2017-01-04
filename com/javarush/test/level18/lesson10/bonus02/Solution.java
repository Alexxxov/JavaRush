package com.javarush.test.level18.lesson10.bonus02;

/* Прайсы
CrUD для таблицы внутри файла
Считать с консоли имя файла для операций CrUD
Программа запускается со следующим набором параметров:
-c productName price quantity
Значения параметров:
где id - 8 символов
productName - название товара, 30 chars (60 bytes)
price - цена, 8 символов
quantity - количество, 4 символа
-c  - добавляет товар с заданными параметрами в конец файла, генерирует id самостоятельно, инкрементируя максимальный id, найденный в файле

В файле данные хранятся в следующей последовательности (без разделяющих пробелов):
id productName price quantity
Данные дополнены пробелами до их длины

Пример:
19846   Шорты пляжные синие           159.00  12
198478  Шорты пляжные черные с рисунко173.00  17
19847983Куртка для сноубордистов, разм10173.991234
*/

import java.io.*;

public class Solution {
    public static void main(String[] args) throws Exception {

        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        RandomAccessFile accessFile  = new RandomAccessFile(reader.readLine(), "rw");
        reader.close();

        String lastLine = "";
        String line;
        while ((line = accessFile.readLine()) != null)
        {
            lastLine = line;
        }
        switch (args[0])
        {
            case "-c":
            {

                int id = Integer.valueOf(lastLine.substring(0,8).trim()) + 1;
                String strToAppend = "";
                for (int i = 1; i < args.length-2 ; i++)
                {
                    strToAppend +=args[i]+" ";
                }
                String result = String.format("%n%-8d%-30.30s%-8.2f%-4d",id, strToAppend, Float.valueOf(args[args.length-2]), Integer.valueOf(args[args.length-1]));

                accessFile.write(result.getBytes());

                accessFile.close();
            }
        }

    }
}
