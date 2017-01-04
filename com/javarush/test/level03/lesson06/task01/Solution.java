package com.javarush.test.level03.lesson06.task01;

/* Мама мыла раму
Вывести на экран все возможные комбинации слов «Мама», «Мыла», «Раму».
Подсказка: их 6 штук. Каждую комбинацию вывести с новой строки. Слова не разделять. Пример:
МылаРамуМама
РамуМамаМыла
...
*/

public class Solution
{
    public static void main(String[] args)
    {
        String str1 = "Мама";
        String str2 = "Мыла";
        String str3 = "Раму";
        System.out.println(str1 + str2 + str3);
        System.out.println(str1 + str3 + str2);
        System.out.println(str2 + str1 + str3);
        System.out.println(str2 + str3 + str1);
        System.out.println(str3 + str2 + str1);
        System.out.println(str3 + str1 + str2);

        //напишите тут ваш код
    }


}