package com.javarush.test.level18.lesson10.home05;

/* Округление чисел
Считать с консоли 2 имени файла
Первый файл содержит вещественные(дробные) числа, разделенные пробелом. Например, 3.1415
Округлить числа до целых и записать через пробел во второй файл
Закрыть потоки. Не использовать try-with-resources
Принцип округления:
3.49 - 3
3.50 - 4
3.51 - 4
-3.49 - -3
-3.50 - -3
-3.51 - -4
*/


import java.io.*;

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        FileInputStream in = new FileInputStream(reader.readLine());
        FileOutputStream out = new FileOutputStream(reader.readLine());
        reader.close();

        while(in.available() > 0){
            byte[] data = new byte[in.available()];
            in.read(data);
            out.write(getInput(data));
        }

        in.close();
        out.close();

    }

    public static byte[] getInput(byte[] arr)
    {
        StringBuilder sb = new StringBuilder();
        String[] s = new String(arr).split(" ");

        for (String str: s)
        {
            sb.append(Math.round(Double.valueOf(str)));
            sb.append(" ");
        }

        return sb.toString().getBytes();
    }
}
