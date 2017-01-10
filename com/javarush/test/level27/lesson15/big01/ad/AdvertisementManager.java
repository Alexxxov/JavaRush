package com.javarush.test.level27.lesson15.big01.ad;

import com.javarush.test.level27.lesson15.big01.ConsoleHelper;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

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
        List<Advertisement> ads = new ArrayList<>();
        List<Advertisement> adsFromStorage = new ArrayList<>(storage.list());

        Collections.sort(adsFromStorage, new Comparator<Advertisement>()
        {
            @Override
            public int compare(Advertisement o1, Advertisement o2)
            {
                return Long.compare(o2.getAmountPerOneDisplaying(), o1.getAmountPerOneDisplaying());
            }
        });

        int timeLeft = timeSeconds;

        for (Advertisement ad: adsFromStorage)
        {
            if (timeLeft <=0) break;
            if (timeLeft >= ad.getDuration()){
                ads.add(ad);
                timeLeft -= ad.getDuration();
            }
        }

        if (ads.isEmpty()) throw new NoVideoAvailableException();

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
}
