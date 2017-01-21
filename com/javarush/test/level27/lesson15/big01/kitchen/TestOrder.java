package com.javarush.test.level27.lesson15.big01.kitchen;

import com.javarush.test.level27.lesson15.big01.Tablet;

import java.io.IOException;
import java.util.ArrayList;
import java.util.concurrent.ThreadLocalRandom;

/**
 * Created by Admin on 18.01.2017.
 */
public class TestOrder extends Order {

    public TestOrder(Tablet tablet) throws IOException
    {
        super(tablet);
    }

    @Override
    protected void initDishes()
    {
            this.dishes = new ArrayList<>();
            int rand = ThreadLocalRandom.current().nextInt(1, Dish.values().length);
            for (int i = 0; i < rand; i++) {
                int num = (int) (Math.random() * Dish.values().length);
                dishes.add(Dish.values()[num]);
            }
    }
}
