package com.javarush.test.level27.lesson15.big01.ad;

import com.javarush.test.level27.lesson15.big01.ConsoleHelper;

import java.util.*;

/**
 * Created by Admin on 08.01.2017.
 */
public class AdvertisementManager {

    private int timeSeconds;

    private final AdvertisementStorage storage = AdvertisementStorage.getInstance();

    public AdvertisementManager(int timeSeconds) {
        this.timeSeconds = timeSeconds;
    }

    public void processVideos()
    {
        List<Advertisement> ads = getMaxProfitVideos(powerSet(storage.list()));

        if (ads.size() <= 0 || ads == null) throw new NoVideoAvailableException();

        //сортируем сначала по убыванию стоимости показа одного видео(если разная стоимость показа),
        //затем (если стоимости равны) сортируем в порядке увеличения стоимости одной секунды видео
        Collections.sort(ads, new Comparator<Advertisement>() {
            @Override
            public int compare(Advertisement o1, Advertisement o2)
            {
                if (o2.getAmountPerOneDisplaying() != o1.getAmountPerOneDisplaying())
                    return Long.compare(o2.getAmountPerOneDisplaying(), o1.getAmountPerOneDisplaying());
                else
                {
                    long oneSecondCost1 = (o1.getAmountPerOneDisplaying() * 1000) / o1.getDuration();
                    long oneSecondCost2 = (o2.getAmountPerOneDisplaying() * 1000) / o2.getDuration();
                    return Long.compare(oneSecondCost1, oneSecondCost2);
                }
            }
        });

        for (Advertisement ad: ads)
        {
                ad.revalidate();
                ConsoleHelper.writeMessage(String.format("%s is displaying... %d, %d",
                        ad.getName(),
                        ad.getAmountPerOneDisplaying(),
                        ad.getAmountPerOneDisplaying() * 1000 / ad.getDuration()));
        }

    }

    private <Advertisement> List<List<Advertisement>> powerSet(List<Advertisement> originalList)
    {
        List<List<Advertisement>> lists = new ArrayList<>();
        if (originalList.isEmpty()) {
            lists.add(new ArrayList<Advertisement>());
            return lists;
        }
        List<Advertisement> recurseList = new ArrayList<>(originalList);
        Advertisement head = recurseList.get(0);
        List<Advertisement> rest = new ArrayList<>(recurseList.subList(1, recurseList.size()));
        for (List<Advertisement> list : powerSet(rest)) {
            List<Advertisement> newList = new ArrayList<>();
            newList.add(head);
            newList.addAll(list);
            lists.add(newList);
            lists.add(list);
        }
        return lists;
    }

    public List<Advertisement> getMaxProfitVideos(List<List<Advertisement>> list){


        Iterator<List<Advertisement>> iter = list.iterator();
        while (iter.hasNext())
        {
            int timePerList = 0;
            boolean removeSet = false;
            for (Advertisement a:iter.next())
            {
                timePerList += a.getDuration();
                if(a.getHits()<=0 || timePerList > timeSeconds)
                    removeSet=true;
            }
            if(removeSet)
                iter.remove();
        }

        Collections.sort(list, new Comparator<List<Advertisement>>() {
            @Override
            public int compare(List<Advertisement> o1, List<Advertisement> o2) {

                long profit1 = calcTotalAmount(o1);
                long profit2 = calcTotalAmount(o2);
                int duration1 = calcTotalTime(o1);
                int duration2 = calcTotalTime(o2);


                if (profit1 != profit2)  // первичная по прибыли от показа (по убыванию)
                    return Long.compare(profit2, profit1);
                else if (duration1 != duration2)  // вторичная по длительности (по убыванию)
                    return Integer.compare(duration2, duration1);
                else
                    return Integer.compare(o1.size(), o2.size());  // по размеру списка (по возрастанию)
            }
        });

        return list.get(0);
    }

    //вычисляет общий вес набора предметов ( общее время показа видео )
    private int calcTotalTime(List<Advertisement> ads)
    {
        int sumTime = 0;
        if (ads == null) return sumTime;

        for(Advertisement ad : ads)
            sumTime += ad.getDuration();

        return sumTime;
    }

    //вычисляет общую стоимость набора предметов ( общая цена показа видео )
    private long calcTotalAmount(List<Advertisement> ads)
    {
        long sumAmount = 0;
        if (ads == null) return sumAmount;

        for(Advertisement ad : ads)
            sumAmount += ad.getAmountPerOneDisplaying();

        return sumAmount;
    }
}
