package com.javarush.test.level27.lesson15.big01.kitchen;

/**
 * Created by Admin on 05.01.2017.
 */
public enum Dish {
    Fish(25), Steak(30), Soup(15), Juice(5), Water(3);

    private int duration;

    public int getDuration() {
        return duration;
    }

    Dish(int duration) {
        this.duration = duration;
    }

    public static String allDishesToString()
    {
        StringBuilder result = new StringBuilder();
        for (Dish d: Dish.values())
            result.append(d.toString()).append(", ");
        result.delete(result.length()-2,result.length());
        return result.toString();
    }

}
