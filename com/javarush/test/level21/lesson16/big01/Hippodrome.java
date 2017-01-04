package com.javarush.test.level21.lesson16.big01;

import java.util.ArrayList;

/**
 * Created by Admin on 08.11.2016.
 */
public class Hippodrome
{


    private static ArrayList<Horse> horses = new ArrayList<>();

    public ArrayList<Horse> getHorses()
    {
        return horses;
    }

    public static Hippodrome game;

    public static void main(String[] args) throws InterruptedException
    {
        game = new Hippodrome();
        game.getHorses().add(new Horse("Blitz", 3, 0));
        game.getHorses().add(new Horse("Donner", 3, 0));
        game.getHorses().add(new Horse("Schmoll", 3, 0));
        game.run();
        game.printWinner();
    }

    public void move()
    {
        for(Horse currentHorse: getHorses())
            currentHorse.move();
    }

    public void print()
    {
        for(Horse currentHorse: getHorses())
            currentHorse.print();

        System.out.println();
        System.out.println();
    }

    public void run() throws InterruptedException
    {
        for (int i = 1; i <= 100 ; i++)
        {
            move();
            print();
            Thread.sleep(200);
        }
    }

    public Horse getWinner()
    {
        Horse winner = null;
        double max = 0;
        for(Horse currentHorse: getHorses())
            if (currentHorse.getDistance()>max)
            {
                max = currentHorse.getDistance();
                winner = currentHorse;
            }

     return winner;
    }

    public void printWinner()
    {
        System.out.println("Winner is " + getWinner().getName() +"!");
    }

}
