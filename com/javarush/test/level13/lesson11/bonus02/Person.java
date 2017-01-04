package com.javarush.test.level13.lesson11.bonus02;

public class Person implements RepkaItem
{
    private String name;
    private String namePadezh;

    @Override
    public String getNamePadezh()
    {
        //namePadezh = namePadezh.substring(0,name.length()-2) + "у";

        return this.namePadezh;
    }

    public Person(String name, String namePadezh)
    {
        this.name = name;
        this.namePadezh = namePadezh;
    }
    public void pull(Person person)
    {
        System.out.println(this.name + " за " + person.namePadezh);
    }
}
