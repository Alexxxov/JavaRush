package com.javarush.test.level27.lesson15.big01;

import com.javarush.test.level27.lesson15.big01.ad.Advertisement;
import com.javarush.test.level27.lesson15.big01.ad.StatisticAdvertisementManager;
import com.javarush.test.level27.lesson15.big01.statistic.StatisticEventManager;

import java.text.SimpleDateFormat;
import java.util.*;

/**
 * Created by Admin on 16.01.2017.
 */
public class DirectorTablet {

    private SimpleDateFormat dateFormat = new SimpleDateFormat("dd-MMM-yyyy", Locale.ENGLISH);

    public void printAdvertisementProfit()
    {
        Map<Date,Long> allAdsProfitPerDay = StatisticEventManager.getInstance().getAllAdsProfitPerDay();

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
        Map<Date, Map<String, Integer>> allCookWorkloading = StatisticEventManager.getInstance().getCookWorkloading();

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
        List<Advertisement> activeVideoSet = StatisticAdvertisementManager.getInstance().getActiveVideoSet();
        Collections.sort(activeVideoSet, new Comparator<Advertisement>() {
            @Override
            public int compare(Advertisement o1, Advertisement o2) {
                return o1.getName().compareToIgnoreCase(o2.getName());
            }
        });

        for (Advertisement ad: activeVideoSet)
            ConsoleHelper.writeMessage(String.format("%s - %d", ad.getName(), ad.getHits()));
    }

    public void printArchivedVideoSet()
    {
        List<Advertisement> archivedVideoSet = StatisticAdvertisementManager.getInstance().getArchivedVideoSet();
        Collections.sort(archivedVideoSet, new Comparator<Advertisement>() {
            @Override
            public int compare(Advertisement o1, Advertisement o2) {
                return o1.getName().compareToIgnoreCase(o2.getName());
            }
        });

        for (Advertisement ad: archivedVideoSet)
            ConsoleHelper.writeMessage(ad.getName());
    }

}
