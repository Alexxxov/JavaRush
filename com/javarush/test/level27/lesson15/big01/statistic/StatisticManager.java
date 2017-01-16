package com.javarush.test.level27.lesson15.big01.statistic;

import com.javarush.test.level27.lesson15.big01.ConsoleHelper;
import com.javarush.test.level27.lesson15.big01.kitchen.Cook;
import com.javarush.test.level27.lesson15.big01.statistic.event.CookedOrderEventDataRow;
import com.javarush.test.level27.lesson15.big01.statistic.event.EventDataRow;
import com.javarush.test.level27.lesson15.big01.statistic.event.EventType;
import com.javarush.test.level27.lesson15.big01.statistic.event.VideoSelectedEventDataRow;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;

/**
 * Created by Admin on 14.01.2017.
 */
public class StatisticManager {

    private Set<Cook> cooks;
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

    public Map<Date, Long> getAllAdsProfitPerDay()
    {
        Map<Date, Long> result = new TreeMap<>(Collections.<Date>reverseOrder());
        SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
        List<EventDataRow> selectedVideos = statisticStorage.eventList(EventType.SELECTED_VIDEOS);

        for (EventDataRow currSet: selectedVideos)
        {
            Date date = null;
            try
            {
                date = dateFormat.parse(dateFormat.format(currSet.getDate()));
            }
            catch (ParseException e) {}
            if (result.containsKey(date))
            {
                result.put(date, result.get(date) + ((VideoSelectedEventDataRow) currSet).getAmount());
            }
            else
            {
                result.put(date, ((VideoSelectedEventDataRow) currSet).getAmount());
            }
        }

        return result;
    }

    public Map<Date, Map<String, Integer>> getCookWorkloading()
    {
        Map<Date, Map<String, Integer>> result = new TreeMap<>(Collections.<Date>reverseOrder());
        Map<String, Integer> cook_time;
        SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
        List<EventDataRow> allCookOrders = statisticStorage.eventList(EventType.COOKED_ORDER);

        for (EventDataRow currCookOrder: allCookOrders)
        {
            Date date = null;
            try
            {
                date = dateFormat.parse(dateFormat.format(currCookOrder.getDate()));
            }
            catch (ParseException e) {}
            String currCookName = ((CookedOrderEventDataRow) currCookOrder).getCookName();
            int totalCookingTime = (int) Math.ceil(currCookOrder.getTime()/60);

            //если есть такая дата
            if (result.containsKey(date))
            {
                cook_time = result.get(date);
                //проверка есть ли повар или нет
                if (cook_time.containsKey(currCookName))
                {
                    cook_time.put(currCookName, cook_time.get(currCookName) + totalCookingTime);
                    result.put(date, cook_time);
                }
                else
                {
                    cook_time.put(currCookName, totalCookingTime);
                    result.put(date, cook_time);
                }
            }
            else
            {
                //если впервые видим дату - кладем в новую мапу повара и его время
                cook_time = new TreeMap<>();
                cook_time.put(currCookName, totalCookingTime);
                result.put(date, cook_time);
            }
        }

        return result;
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

        private List<EventDataRow> eventList(EventType et) {
            return map.get(et);
        }

        private void put(EventDataRow data)
        {
            map.get(data.getType()).add(data);
        }
    }
}
