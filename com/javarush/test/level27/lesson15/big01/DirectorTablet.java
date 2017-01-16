package com.javarush.test.level27.lesson15.big01;

import com.javarush.test.level27.lesson15.big01.statistic.StatisticManager;

import java.text.SimpleDateFormat;
import java.util.*;

/**
 * Created by Admin on 16.01.2017.
 */
public class DirectorTablet {

    private SimpleDateFormat dateFormat = new SimpleDateFormat("dd-MMM-yyyy", Locale.ENGLISH);

    public void printAdvertisementProfit()
    {
        Map<Date,Long> allAdsProfitPerDay = StatisticManager.getInstance().getAllAdsProfitPerDay();

        double total = 0;
        for (Map.Entry<Date, Long> entry: allAdsProfitPerDay.entrySet())
        {
            double amount = entry.getValue()/100.0;
            total += amount;
            ConsoleHelper.writeMessage(String.format("%s - %.2f", dateFormat.format(entry.getKey()), amount));
        }
        ConsoleHelper.writeMessage("Total - " + total);
    }

    public void printCookWorkloading()
    {
        Map<Date, Map<String, Integer>> allCookWorkloading = StatisticManager.getInstance().getCookWorkloading();

        for (Map.Entry<Date, Map<String, Integer>> dates: allCookWorkloading.entrySet())
        {
            ConsoleHelper.writeMessage(dateFormat.format(dates.getKey()));
            for (Map.Entry<String, Integer>  cooks : dates.getValue().entrySet())
                ConsoleHelper.writeMessage(String.format("%s - %d min", cooks.getKey(), cooks.getValue()));
            ConsoleHelper.writeMessage("");
        }
    }

    public void printActiveVideoSet()
    {

    }

    public void printArchivedVideoSet()
    {

    }

}
