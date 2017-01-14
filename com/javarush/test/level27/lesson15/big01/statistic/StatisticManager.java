package com.javarush.test.level27.lesson15.big01.statistic;

import com.javarush.test.level27.lesson15.big01.statistic.event.EventDataRow;
import com.javarush.test.level27.lesson15.big01.statistic.event.EventType;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by Admin on 14.01.2017.
 */
public class StatisticManager {

    private StatisticStorage statisticStorage = new StatisticStorage();

    private static StatisticManager ourInstance = new StatisticManager();

    public static StatisticManager getInstance() {
        return ourInstance;
    }

    private StatisticManager()
    {
        this.statisticStorage = new StatisticStorage();
    }

    public void register(EventDataRow data)
    {
        //TODO
    }

    private class StatisticStorage
    {
        private Map<EventType, List<EventDataRow>> map;

        public StatisticStorage()
        {
            map = new HashMap<>();
            for (EventType et: EventType.values())
                map.put(et, new ArrayList<EventDataRow>());
        }
    }
}
