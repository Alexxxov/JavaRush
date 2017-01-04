package com.javarush.test.level05.lesson07.task03;

/* Создать класс Dog
Создать класс Dog (собака) с тремя инициализаторами:
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

    public void initialize(String name)
    {
        this.name = name;
    }
    public void initialize(String name, int howTall)
    {
        this.name = name;
        this.howTall = howTall;

    }
    public void initialize(String name, int howTall, String color)
    {
        this.howTall = howTall;
        this.color = color;
        this.name = name;
    }

}
