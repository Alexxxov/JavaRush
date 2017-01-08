package com.javarush.test.level27.lesson15.big01.ad;

/**
 * Created by Admin on 08.01.2017.
 */
public class AdvertisementStorage {
    private static AdvertisementStorage ourInstance = new AdvertisementStorage();

    public static AdvertisementStorage getInstance() {
        return ourInstance;
    }

    private AdvertisementStorage() {
    }
}
