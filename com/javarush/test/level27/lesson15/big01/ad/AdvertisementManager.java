package com.javarush.test.level27.lesson15.big01.ad;

import com.javarush.test.level27.lesson15.big01.ConsoleHelper;

/**
 * Created by Admin on 08.01.2017.
 */
public class AdvertisementManager {

    private int timeSeconds;

    public AdvertisementManager(int timeSeconds) {
        this.timeSeconds = timeSeconds;
    }

    public void processVideos()
    {
        ConsoleHelper.writeMessage("processVideos method calling");
    }

    private final AdvertisementStorage storage = AdvertisementStorage.getInstance();

}
