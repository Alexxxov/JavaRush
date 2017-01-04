package com.javarush.test.level19.lesson08.task04;

/* Решаем пример
В методе main подмените объект System.out написанной вами ридер-оберткой по аналогии с лекцией
Ваша ридер-обертка должна выводить на консоль решенный пример
Вызовите готовый метод printSomething(), воспользуйтесь testString
Верните переменной System.out первоначальный поток

Возможные операции: + - *
Шаблон входных данных и вывода: a [знак] b = c
Отрицательных и дробных чисел, унарных операторов - нет.

Пример вывода:
3 + 6 = 9
*/

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Solution {
    public static TestString testString = new TestString();

    public static void main(String[] args) {

        PrintStream consoleStream = System.out;

        ByteArrayOutputStream arr = new ByteArrayOutputStream();

        PrintStream stream = new PrintStream(arr);

        System.setOut(stream);

        testString.printSomething();

        Matcher m = Pattern.compile("\\s*(\\d+)\\s*([-+*])\\s*(\\d+)\\s*=").matcher(arr.toString());

        System.setOut(consoleStream);

        while (m.find())
        {
            int a = Integer.parseInt(m.group(1));
            int b = Integer.parseInt(m.group(3));
            if (m.group(2).equals("+"))
                System.out.println(m.group()+ " " + (a + b));
            if (m.group(2).equals("-"))
                System.out.println(m.group()+ " " + (a - b));
            if (m.group(2).equals("*"))
                System.out.println(m.group()+ " " + (a * b));
        }
    }

    public static class TestString {
        public void printSomething() {
            System.out.println("3 + 6 = ");
        }
    }
}

