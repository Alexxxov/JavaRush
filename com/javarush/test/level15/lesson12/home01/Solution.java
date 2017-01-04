package com.javarush.test.level15.lesson12.home01;


import java.io.BufferedReader;
import java.io.CharArrayReader;
import java.io.IOException;
import java.io.InputStreamReader;

/* Разные методы для разных типов
1. Считать с консоли данные, пока не введено слово "exit".
2. Для каждого значения, кроме "exit", вызвать метод print. Если значение:
2.1. содержит точку '.', то вызвать метод print для Double;
2.2. больше нуля, но меньше 128, то вызвать метод print для short;
2.3. больше либо равно 128, то вызвать метод print для Integer;
2.4. иначе, вызвать метод print для String.
*/

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader( new InputStreamReader(System.in));

        String text;
        while ( !(text=reader.readLine()).equals("exit") )
        {
            if ( text.contains(".") && !text.matches("/^[a-z]$/")) print(Double.parseDouble(text));
            else if (text.matches("\\d+") && (Integer.parseInt(text) > 0) && (Integer.parseInt(text) < 128) ) print(Short.parseShort(text));
            else if (text.matches("\\d+") && (Integer.parseInt(text) >= 128) ) print(Integer.parseInt(text));
            else print(text);
        }
        reader.close();

//        String str;
//        while(!(str = reader.readLine()).equals("exit"))
//        {
//            try
//            {
//                if (str.contains(".") && !str.matches("/^[a-z]$/"))
//                {
//                    print(Double.parseDouble(str));
//                }
//                else if (Short.parseShort(str)>0 && Short.parseShort(str)<128)
//                {
//                    print(Short.parseShort(str));
//                }
//                else if (Integer.parseInt(str) >= 128)
//                {
//                    print(Integer.parseInt(str));
//                }
//                else
//                    print(str);
//            }
//            catch(NumberFormatException e)
//            {
//                print(str);
//            }
//
//        }

        //напиште тут ваш код
    }

    public static void print(Double value) {
        System.out.println("Это тип Double, значение " + value);
    }

    public static void print(String value) {
        System.out.println("Это тип String, значение " + value);
    }

    public static void print(short value) {
        System.out.println("Это тип short, значение " + value);
    }

    public static void print(Integer value) {
        System.out.println("Это тип Integer, значение " + value);
    }
}
