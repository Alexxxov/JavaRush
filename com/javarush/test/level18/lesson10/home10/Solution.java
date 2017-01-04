package com.javarush.test.level18.lesson10.home10;

/* Собираем файл
Собираем файл из кусочков
Считывать с консоли имена файлов
Каждый файл имеет имя: [someName].partN. Например, Lion.avi.part1, Lion.avi.part2, ..., Lion.avi.part37.
Имена файлов подаются в произвольном порядке. Ввод заканчивается словом "end"
В папке, где находятся все прочтенные файлы, создать файл без приставки [.partN]. Например, Lion.avi
В него переписать все байты из файлов-частей используя буфер.
Файлы переписывать в строгой последовательности, сначала первую часть, потом вторую, ..., в конце - последнюю.
Закрыть потоки. Не использовать try-with-resources
*/

import java.io.*;
import java.util.TreeSet;

public class Solution {
    public static void main(String[] args) throws IOException {

        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String s;

        //Work with file names but not with files itself
        TreeSet<String> set = new TreeSet<>();
        while(!(s = reader.readLine()).equals("end"))
        {
            File file = new File(s);
            if(!file.exists())
                throw new RuntimeException(new FileNotFoundException());
            else
                set.add(s);
        }
        reader.close();

        //Create new File
        String ganzFileName = set.first().replaceFirst("\\.part\\d+$","");
        File GanzFile = new File(ganzFileName);
        GanzFile.createNewFile();
        FileOutputStream GanzFileStream = new FileOutputStream(GanzFile);

        //Write from all files into new one
        byte[] buff;
        for (String str: set)
        {
            FileInputStream fileInputStream = new FileInputStream(str);
            buff = new byte[fileInputStream.available()];
            fileInputStream.read(buff);
            GanzFileStream.write(buff);
            fileInputStream.close();
        }
        GanzFileStream.close();

    }
}
