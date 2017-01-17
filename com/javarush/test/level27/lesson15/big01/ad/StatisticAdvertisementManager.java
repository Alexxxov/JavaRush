package com.javarush.test.level27.lesson15.big01.ad;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Admin on 18.01.2017.
 */
public class StatisticAdvertisementManager {
    private static StatisticAdvertisementManager ourInstance = new StatisticAdvertisementManager();

    private static AdvertisementStorage advertisementStorage = AdvertisementStorage.getInstance();

    public static StatisticAdvertisementManager getInstance() {
        return ourInstance;
    }

    private StatisticAdvertisementManager() {}

    public List<Advertisement> getActiveVideoSet()
    {
        List<Advertisement> result = new ArrayList<>();
        for (Advertisement ad : advertisementStorage.list()) {
            if (ad.getHits() > 0)
                result.add(ad);
        }
        return result;
    }

    public List<Advertisement> getArchivedVideoSet()
    {
        List<Advertisement> result = new ArrayList<>();
        for (Advertisement ad : advertisementStorage.list()) {
            if (ad.getHits() == 0)
                result.add(ad);
        }
        return result;
    }

}
