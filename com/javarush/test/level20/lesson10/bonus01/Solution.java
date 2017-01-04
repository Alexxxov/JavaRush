package com.javarush.test.level20.lesson10.bonus01;


import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.Vector;

/* Алгоритмы-числа
Число S состоит из M чисел, например, S=370 и M(количество цифр)=3
Реализовать логику метода getNumbers, который должен среди натуральных чисел меньше N (long)
находить все числа, удовлетворяющие следующему критерию:
число S равно сумме его цифр, возведенных в M степень
getNumbers должен возвращать все такие числа в порядке возрастания

Пример искомого числа:
370 = 3*3*3 + 7*7*7 + 0*0*0
8208 = 8*8*8*8 + 2*2*2*2 + 0*0*0*0 + 8*8*8*8

На выполнение дается 10 секунд и 50 МБ памяти.
*/
public class Solution {

    public static void main(String[] args) {
        int number = 10000000;
        long freeMemory = Runtime.getRuntime().freeMemory();
        long startTime = System.currentTimeMillis();
        int[] a = getNumbers(number);
        long memoryAfterCalculate = Runtime.getRuntime().freeMemory();
        long delta = memoryAfterCalculate - freeMemory;
        long stopTime = System.currentTimeMillis();
        System.out.println("Calculating time: " + (stopTime - startTime));
        System.out.println("Used JVM memory: " + delta);
        for (int i : a) {
            System.out.print(i + " ");
        }
        System.out.println();
    }

    public static int[] getNumbers(int N) {
        Vector<Integer> v = new Vector<>();
        for (int i = 1; i < N; i++) {
            if (checkFormula(i)) v.add(i);
        }
        int[] result = new int[v.size()];
        for (int i = 0; i < v.size(); i++) {
            result[i] = v.get(i);
        }
        return result;
    }

    public static boolean checkFormula(int number) {
        if (number == 0) return false;
        else if (number >= 1 && number < 10) return true;
        int     rest = number,
                sum = 0,
                digit = 0,
                digitCount = 1 + (int) Math.log10(number);
        for (int i = 0; i < digitCount; i++) {
            digit = rest % 10;
            rest = rest / 10;
            int prod = digit;
            for (int j = 1; j < digitCount; j++) {
                prod *= digit;
            }
            sum += prod;
        }
        if (sum == number)
            return true;
        else
            return false;
    }

//    public static void main(String[] args)
//    {
//        long timeStart = System.currentTimeMillis();
//        long memoryStart = Runtime.getRuntime().freeMemory();
//
//        int[] numbers = getNumbers(1500000000);
//
//        long timeEnd = System.currentTimeMillis();
//        long memoryEnd = Runtime.getRuntime().freeMemory();
//
//        long time = timeEnd - timeStart;
//        long memory = (memoryStart - memoryEnd) / 1024;
//        System.out.println(String.format("Time: %d ms", time));
//        System.out.println(String.format("Memory: %d KB", memory));
//    }
//
//    public static int[] getNumbers(long N) {
//        int[] result;
//        int porog = 10;
//        LinkedList<Integer> list = new LinkedList<>();
//        // initial powers for the number 0-9
//        long[] powers = { 0l, 1l, 2l, 3l, 4l, 5l, 6l, 7l, 8l, 9l };
//
//        for (int i = 1; i < N; i++) {
//            if (i == porog) {
//                porog *= 10;
//                // calculate i^length
//                for (int pi = 1; pi < 10; pi++) {
//                    powers[pi] *= pi;
//                }
//            }
//            int s = i;
//            int k = 0;
//            while (s > 0) {
//                int r = (int)(s % 10);
//                k += powers[r];
//                if (k > i)
//                    break;
//                s /= 10;
//            }
//
//            if (k == i)
//                list.add(i);
//        }
//        result = new int[list.size()];
//        for (int i = 0; i < list.size();i++)
//            result[i] = list.get(i);
//
//        return result;
//    }

}
