package com.javarush.test.level18.lesson10.home03;

/* Два в одном
Считать с консоли 3 имени файла
Записать в первый файл содержимого второго файла, а потом дописать в первый файл содержимое третьего файла
Закрыть потоки. Не использовать try-with-resources
*/

import java.io.*;

public class Solution {
    public static void main(String[] args) throws IOException {

        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        FileOutputStream fileOutputStream = new FileOutputStream(reader.readLine());
        FileInputStream fileInputStream = new FileInputStream(reader.readLine());
        FileInputStream fileInputStream1 = new FileInputStream(reader.readLine());
        reader.close();

        writeFileToAnother(fileInputStream, fileOutputStream);
        writeFileToAnother(fileInputStream1, fileOutputStream);

        fileOutputStream.close();
        fileInputStream.close();
        fileInputStream1.close();

    }

    public static void writeFileToAnother(FileInputStream from, FileOutputStream whereTo) throws IOException
    {
        while (from.available()>0)
        {
            int data = from.read();
            whereTo.write(data);
        }
    }

}
