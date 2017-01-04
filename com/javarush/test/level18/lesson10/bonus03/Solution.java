package com.javarush.test.level18.lesson10.bonus03;

/* Прайсы 2
CrUD для таблицы внутри файла
Считать с консоли имя файла для операций CrUD
Программа запускается с одним из следующих наборов параметров:
-u id productName price quantity
-d id
Значения параметров:
где id - 8 символов
productName - название товара, 30 chars (60 bytes)
price - цена, 8 символов
quantity - количество, 4 символа
-u  - обновляет данные товара с заданным id
-d  - производит физическое удаление товара с заданным id (все данные, которые относятся к переданному id)

В файле данные хранятся в следующей последовательности (без разделяющих пробелов):
id productName price quantity
Данные дополнены пробелами до их длины

Пример:
19846   Шорты пляжные синие           159.00  12
198478  Шорты пляжные черные с рисунко173.00  17
19847983Куртка для сноубордистов, разм10173.991234
*/

import java.io.*;

public class Solution
{
    public static void main(String[] args) throws Exception
    {

        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String fileName = reader.readLine();
        reader.close();

        BufferedReader fileReader = new BufferedReader(new FileReader(fileName));
        BufferedWriter fileWriter = new BufferedWriter(new FileWriter(fileName+"tmp"));

        String line;
        while ((line = fileReader.readLine()) != null)
        {
            String id = line.substring(0, 8).trim();
            if (id.equals(args[1]))
            {
                switch (args[0])
                {
                    case "-u":
                    {
                        String strToAppend = "";
                        for (int i = 2; i < args.length - 2; i++)
                        {
                            strToAppend += args[i] + " ";
                        }
                        line = String.format("%-8s%-30.30s%-8.2f%-4d", id, strToAppend, Float.valueOf(args[args.length - 2]), Integer.valueOf(args[args.length - 1]));
                        fileWriter.write(line);
                        fileWriter.newLine();
                        break;
                    }
                    case "-d":
                    {
                        line = "";
                        fileWriter.write(line);
                        fileWriter.newLine();
                        break;
                    }
                }
            }
            else
            {
                fileWriter.write(line);
                fileWriter.newLine();
            }
        }
        fileReader.close();
        fileWriter.close();

        //delete old file
        File oldFile = new File(fileName);
        oldFile.delete();

        //And rename tmp file's name to old file name
        File newFile = new File(fileName+"tmp");
        newFile.renameTo(oldFile);
    }
}

