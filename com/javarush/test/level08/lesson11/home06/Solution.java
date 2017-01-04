package com.javarush.test.level08.lesson11.home06;

/* Вся семья в сборе
1. Создай класс Human с полями имя (String), пол (boolean), возраст (int), дети (ArrayList<Human>).
2. Создай объекты и заполни их так, чтобы получилось: два дедушки, две бабушки, отец, мать, трое детей.
3. Вывести все объекты Human на экран.
*/

import java.util.ArrayList;
import java.util.List;

public class Solution
{
    public static void main(String[] args)
    {
        Human ch1 = new Human("Саня", true, 13);

        Human ch2 = new Human("Василиса", false, 14);

        Human ch3 = new Human("Максим", true, 15);

        ArrayList<Human> childrendmp = new ArrayList<>();
        childrendmp.add(ch1);
        childrendmp.add(ch2);
        childrendmp.add(ch3);

        Human mum = new Human("Лена", false, 42, childrendmp);
        Human pap = new Human("Игорь", true, 44, childrendmp);

        ArrayList<Human> childrendb1 = new ArrayList<>();
        ArrayList<Human> childrendb2 = new ArrayList<>();
        childrendb1.add(pap);
        childrendb2.add(mum);
        Human ded1 = new Human("Вася", true, 60,childrendb1);
        Human bab1 = new Human("Муся", false, 72, childrendb1);
        Human ded2 = new Human("Иван", true, 65,childrendb2);
        Human bab2 = new Human("Катя", false, 62,childrendb2);





        System.out.println(ded1.toString());
        System.out.println(ded2.toString());
        System.out.println(bab1.toString());
        System.out.println(bab2.toString());
        System.out.println(mum.toString());
        System.out.println(pap.toString());
        System.out.println(ch1.toString());
        System.out.println(ch2.toString());
        System.out.println(ch3.toString());//напишите тут ваш код
    }

    public static class Human
    {
        String name;
        boolean sex;
        int age;
        List<Human> children = new ArrayList<>();

        public Human(String name, boolean sex, int age, ArrayList<Human> children)
        {
            this.name = name;
            this.sex = sex;
            this.age = age;
            this.children = children;
        }
        public Human(String name, boolean sex, int age)
        {
            this.name = name;
            this.sex = sex;
            this.age = age;
        }
        public String toString()
        {
            String text = "";
            text += "Имя: " + this.name;
            text += ", пол: " + (this.sex ? "мужской" : "женский");
            text += ", возраст: " + this.age;

            int childCount = this.children.size();
            if (childCount > 0)
            {
                text += ", дети: "+this.children.get(0).name;

                for (int i = 1; i < childCount; i++)
                {
                    Human child = this.children.get(i);
                    text += ", "+child.name;
                }
            }

            return text;
        }
    }

}
