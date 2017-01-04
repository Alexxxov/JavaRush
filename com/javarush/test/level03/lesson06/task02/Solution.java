package com.javarush.test.level03.lesson06.task02;

/* Таблица умножения
Выведи на экран таблицу умножения 10 на 10 в следующем виде:
1 2 3 …
2 4 6 …
3 6 9 …
…
*/

public class Solution
{
    public static void main(String[] args)
    {

        int [][] table = new int[10][10];
        table [0][0] = 1;
        for (int i = 0; i < 10 ; i++)
        {
            table [0][i] = i+1;
            table [i][0] = i+1;
        }

        for (int j = 0; j < 10; j++)
        {
            for (int i = 0; i < 10; i++)
            {
               table[i][j] = table[0][i] * table [j][0];
                System.out.print(table[i][j]+" ");
            }
            System.out.println("");
        }

        //напишите тут ваш код

    }
}