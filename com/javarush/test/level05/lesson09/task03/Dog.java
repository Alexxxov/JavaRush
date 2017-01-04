package com.javarush.test.level05.lesson09.task03;

/* Создать класс Dog
Создать класс Dog (собака) с тремя конструкторами:
- Имя
- Имя, рост
- Имя, рост, цвет
*/

public class Dog
{
    public static void main(String[] args)
    {

    }

    String name;
    int howTall;
    String color;

    public Dog(String name)
    {
        this.name = name;
    }
    public Dog(String name, int howTall)
    {
        this.name = name;
        this.howTall = howTall;

    }
    public Dog(String name, int howTall, String color)
    {
        this.howTall = howTall;
        this.color = color;
        this.name = name;
    }
    //напишите тут ваш код

}
