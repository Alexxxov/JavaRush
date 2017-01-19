package com.javarush.test.level27.lesson15.big01.kitchen;

import com.javarush.test.level27.lesson15.big01.ConsoleHelper;
import com.javarush.test.level27.lesson15.big01.Tablet;

import java.io.IOException;
import java.util.List;

/**
 * Created by Admin on 05.01.2017.
 */
public class Order
{
    protected List<Dish> dishes;
    private Tablet tablet;

    public Order(Tablet tablet) throws IOException
    {
        this.tablet = tablet;
        initDishes();
    }

    public List<Dish> getDishes() {
        return dishes;
    }

    public boolean isEmpty()
    {
        return dishes.isEmpty();
    }

    public int getTotalCookingTime()
    {
        int total = 0;
        for(Dish d: dishes)
            total += d.getDuration();
        return total;
    }

    protected void initDishes() throws IOException
    {
        this.dishes = ConsoleHelper.getAllDishesForOrder();
    }

    public Tablet getTablet() {
        return tablet;
    }

    @Override
    public String toString()
    {
        return isEmpty() ? "" : String.format("Your order: %s of %s", dishes.toString(), tablet.toString());
    }
}
