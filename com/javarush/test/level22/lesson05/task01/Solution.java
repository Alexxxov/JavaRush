package com.javarush.test.level22.lesson05.task01;



/* Найти подстроку
Метод getPartOfString должен возвращать подстроку начиная с символа после 1-го пробела и до конца слова,
которое следует после 4-го пробела.
Пример: "JavaRush - лучший сервис обучения Java."
Результат: "- лучший сервис обучения"
На некорректные данные бросить исключение TooShortStringException (сделать исключением).
Сигнатуру метода getPartOfString не менять.
Метод main не участвует в тестировании.
*/
public class Solution {
    public static void main(String[] args) throws TooShortStringException
    {
        System.out.println(getPartOfString("JavaRush - лучший сервис обучения Java."));
    }
    public static String getPartOfString(String string) throws TooShortStringException
    {
        if (string==null || string.isEmpty())
            throw new TooShortStringException();
//        if (!string.matches("[^ ]*\\s[^ ]*\\s[^ ]*\\s[^ ]*\\s.*"))
//            throw new TooShortStringException();
        int start = string.indexOf(" ")+1;
        int end = 0;
        int counter = 0;
        for (int i = start; i < string.length(); i++)
        {
            if(Character.isWhitespace(string.charAt(i)))
                counter++;
            if (counter==4)
            {
                end = i;
                break;
            }
        }
        if (counter<4)
            throw new TooShortStringException();

        return string.substring(start,end);
    }

    public static class TooShortStringException extends Exception {
    }
}
