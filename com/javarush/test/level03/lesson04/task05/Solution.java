package com.javarush.test.level03.lesson04.task05;

/* Сумма 10 чисел
Вывести на экран сумму чисел от 1 до 10 построчно (должно быть 10 строк):
1
1+2=3
1+2+3=6
1+2+3+4=10
...
Пример вывода:
1
3
6
10
...
*/

public class Solution
{
    public static void main(String[] args)
    {
        System.out.println(addSum(1));
        System.out.println(addSum(2));
        System.out.println(addSum(3));
        System.out.println(addSum(4));
        System.out.println(addSum(5));
        System.out.println(addSum(6));
        System.out.println(addSum(7));
        System.out.println(addSum(8));
        System.out.println(addSum(9));
        System.out.println(addSum(10));

    }
    public static int addSum( int num )
    {
        int sum = 0;
        do
        {
            sum = sum + (num);
            num--;
        }while (num>=1);
        return sum;
    }
}