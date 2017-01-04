package com.javarush.test.level19.lesson10.home05;

/* Слова с цифрами
В метод main первым параметром приходит имя файла1, вторым - файла2.
Файл1 содержит строки со слов, разделенные пробелом.
Записать через пробел в Файл2 все слова, которые содержат цифры, например, а1 или abc3d
Закрыть потоки. Не использовать try-with-resources
*/


import java.io.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Solution {
    public static void main(String[] args) throws IOException {

        BufferedReader fileReader = new BufferedReader(new FileReader(args[0]));
        BufferedWriter fileWriter = new BufferedWriter(new FileWriter(args[1]));

//        String line;
//        while ((line = fileReader.readLine()) != null)
//        {
//            Matcher m = Pattern.compile("\\b((?:\\d[A-Za-z]+)|(?:[A-Za-z]+\\d+[A-Za-z]+)|(?:[A-Za-z]+\\d+))\\b").matcher(line);
//            while (m.find())
//                fileWriter.write(m.group() + " ");
//        }
        String line;
        String[] words;
        while ((line = fileReader.readLine()) != null){
            words = line.split(" ");
            for (String word : words){
                if (word.matches(".+[0-9].+")){
                    fileWriter.write(word + " ");
                }
            }
        }


        fileReader.close();
        fileWriter.close();
    }
}
