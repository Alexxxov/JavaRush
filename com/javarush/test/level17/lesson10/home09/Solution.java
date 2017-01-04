package com.javarush.test.level17.lesson10.home09;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

/* Транзакционность
Сделать метод joinData транзакционным, т.е. если произошел сбой, то данные не должны быть изменены.
1. Считать с консоли 2 имени файла
2. Считать построчно данные из файлов. Из первого файла - в allLines, из второго - в forRemoveLines
В методе joinData:
3. Если список allLines содержит все строки из forRemoveLines, то удалить из списка allLines все строки, которые есть в forRemoveLines
4. Если список allLines НЕ содержит каких-либо строк, которые есть в forRemoveLines, то
4.1. очистить allLines от данных
4.2. выбросить исключение CorruptedDataException
Метод joinData должен вызываться в main. Все исключения обработайте в методе main.
*/

public class Solution {
    public static List<String> allLines = new ArrayList<String>();
    public static List<String> forRemoveLines = new ArrayList<String>();

    static
    {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        try
        {
            String str1 = reader.readLine();
            String str2 = reader.readLine();
            reader.close();
            ReadFile(str1,allLines);
            ReadFile(str2,forRemoveLines);
        }
        catch (IOException e)
        {
            e.printStackTrace();
        }

    }

    public static void main(String[] args) {


        try
        {
            new Solution().joinData();
        }
        catch(CorruptedDataException e)
        { e.printStackTrace();}
    }

    public void joinData () throws CorruptedDataException {
        if (allLines.containsAll(forRemoveLines))
            allLines.removeAll(forRemoveLines);
        else
        {
            allLines.clear();
            throw new CorruptedDataException();
        }

    }

    public static void ReadFile(String fileName, List<String> whereTo) throws IOException
    {
        BufferedReader in1 = new BufferedReader(new InputStreamReader(new FileInputStream(fileName)));
        String lineText1;
        while ((lineText1 = in1.readLine())!=null)
            whereTo.add(lineText1);
        in1.close();
    }
}
