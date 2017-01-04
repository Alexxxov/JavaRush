package com.javarush.test.level07.lesson12.home06;

/* Семья
Создай класс Human с полями имя(String), пол(boolean),возраст(int), отец(Human), мать(Human).
Создай объекты и заполни их так, чтобы получилось: Два дедушки, две бабушки, отец, мать, трое детей. Вывести объекты на экран.
Примечание:
Если написать свой метод String toString() в классе Human, то именно он будет использоваться при выводе объекта на экран.
Пример вывода:
Имя: Аня, пол: женский, возраст: 21, отец: Павел, мать: Катя
Имя: Катя, пол: женский, возраст: 55
Имя: Игорь, пол: мужской, возраст: 2, отец: Михаил, мать: Аня
…
*/

public class Solution
{
    public static void main(String[] args)
    {
        Human ded1 = new Human("Вася", true, 60);
        Human ded2 = new Human("Иван", true, 65);
        Human bab1 = new Human("Муся", false, 72);
        Human bab2 = new Human("Катя", false, 62);
        Human mum = new Human("Лена", false, 42);
        mum.mother = bab1;
        mum.father = ded1;
        Human pap = new Human("Игорь", true, 44);
        pap.mother = bab2;
        pap.father = ded2;
        Human ch1 = new Human("Саня", true, 13);
        ch1.mother = mum;
        ch1.father = pap;
        Human ch2 = new Human("Василиса", false, 14);
        ch2.mother = mum;
        ch2.father = pap;
        Human ch3 = new Human("Максим", true, 15);
        ch3.mother = mum;
        ch3.father = pap;

        System.out.println(ded1.toString());
        System.out.println(ded2.toString());
        System.out.println(bab1.toString());
        System.out.println(bab2.toString());
        System.out.println(mum.toString());
        System.out.println(pap.toString());
        System.out.println(ch1.toString());
        System.out.println(ch2.toString());
        System.out.println(ch3.toString());

    }

    public static class Human
    {
        String name;
        boolean sex;
        int age;
        Human mother;
        Human father;

        public Human( String name, boolean sex, int age)
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

            if (this.father != null)
                text += ", отец: " + this.father.name;

            if (this.mother != null)
                text += ", мать: " + this.mother.name;

            return text;
        }
    }

}
