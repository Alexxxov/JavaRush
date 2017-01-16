package com.javarush.test.level27.lesson15.big01.statistic;

import com.javarush.test.level27.lesson15.big01.ConsoleHelper;
import com.javarush.test.level27.lesson15.big01.kitchen.Cook;
import com.javarush.test.level27.lesson15.big01.statistic.event.EventDataRow;
import com.javarush.test.level27.lesson15.big01.statistic.event.EventType;

import java.util.*;

/**
 * Created by Admin on 14.01.2017.
 */
public class StatisticManager {

    Set<Cook> cooks;

    private StatisticStorage statisticStorage = new StatisticStorage();

    private static StatisticManager ourInstance = new StatisticManager();

    public static StatisticManager getInstance() {
        return ourInstance;
    }

    private StatisticManager()
    {
        this.statisticStorage = new StatisticStorage();
        this.cooks = new HashSet<>();
    }

    public void register(EventDataRow data)
    {
        statisticStorage.put(data);
    }

    public void register(Cook cook)
    {
        cooks.add(cook);
    }

    private class StatisticStorage
    {
        Map<EventType, List<EventDataRow>> map;

        public StatisticStorage()
        {
            map = new HashMap<>();
            for (EventType et: EventType.values())
                map.put(et, new ArrayList<EventDataRow>());
        }

        private void put(EventDataRow data)
        {
            map.get(data.getType()).add(data);
        }
    }
}
