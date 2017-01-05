package com.javarush.test.level27.lesson15.big01.kitchen;

/**
 * Created by Admin on 05.01.2017.
 */
public enum Dish {
    Fish, Steak, Soup, Juice, Water;

    public static String allDishesToString()
    {
        StringBuilder result = new StringBuilder();
        for (Dish d: Dish.values())
            result.append(d.toString()).append(", ");
        result.delete(result.length()-2,result.length());
        return result.toString();
    }

}
