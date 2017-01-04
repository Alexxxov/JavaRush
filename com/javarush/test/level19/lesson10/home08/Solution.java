package com.javarush.test.level19.lesson10.home08;

/* Перевертыши
1 Считать с консоли имя файла.
2 Для каждой строки в файле:
2.1 переставить все символы в обратном порядке
2.2 вывести на экран
3 Закрыть потоки. Не использовать try-with-resources

Пример тела входного файла:
я - программист.
Амиго

Пример результата:
.тсиммаргорп - я
огимА
*/

import java.io.*;

public class Solution {
    public static void main(String[] args) throws IOException {
//
//        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
//        String fileName = reader.readLine();
//        BufferedReader fileReader = new BufferedReader(new FileReader(fileName));
//        BufferedWriter fileWriter = new BufferedWriter(new FileWriter(fileName+"tmp"));
//        reader.close();
//
//        String line;
//        while ((line = fileReader.readLine()) != null)
//        {
//            line = new StringBuilder(line).reverse().toString();
//            fileWriter.write(line);
//            fileWriter.newLine();
//        }
//        fileReader.close();
//        fileWriter.close();
//
//        File oldFile = new File(fileName);
//        oldFile.delete();
//
//        File newFile = new File(fileName+"tmp");
//        newFile.renameTo(oldFile);
//
//        BufferedReader finalReader = new BufferedReader(new FileReader(newFile));
//
//            while((line = finalReader.readLine())!=null)
//                System.out.println(line);
//
//        finalReader.close();

        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        BufferedReader fileIn = new BufferedReader(new FileReader(reader.readLine()));

        while (fileIn.ready()){
            String line = fileIn.readLine();
            System.out.println(new StringBuffer(line).reverse().toString());
        }

        reader.close();
        fileIn.close();
    }
}
