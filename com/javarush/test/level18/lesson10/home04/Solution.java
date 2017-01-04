package com.javarush.test.level18.lesson10.home04;

/* Объединение файлов
Считать с консоли 2 имени файла
В начало первого файла записать содержимое второго файла так, чтобы получилось объединение файлов
Закрыть потоки. Не использовать try-with-resources
*/

import java.io.*;

public class Solution {

    public static void main(String[] args) throws IOException {


        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        RandomAccessFile accessFile = new RandomAccessFile(reader.readLine(), "rw");
        FileInputStream fileInputStream1 = new FileInputStream(reader.readLine());
        reader.close();

        byte[] buff = new byte[(int)accessFile.length()];
        accessFile.read(buff);
        accessFile.seek(0);

        while (fileInputStream1.available()>0)
        {
            accessFile.writeByte(fileInputStream1.read());
        }
        accessFile.write(buff);

        accessFile.close();
        fileInputStream1.close();
    }
}
