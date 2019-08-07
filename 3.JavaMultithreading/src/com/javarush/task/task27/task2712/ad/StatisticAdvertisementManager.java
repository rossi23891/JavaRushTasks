package com.javarush.task.task27.task2712.ad;

import java.util.ArrayList;
import java.util.List;

public class StatisticAdvertisementManager {
    private static StatisticAdvertisementManager ourInstance = new StatisticAdvertisementManager();
    AdvertisementStorage advertisementStorage = AdvertisementStorage.getInstance();

    public static StatisticAdvertisementManager getInstance() {
        return ourInstance;
    }

    private StatisticAdvertisementManager() {
    }

    public List<Advertisement> getInactiveVideoFromStorage(){
       List<Advertisement> inactiveVideos = new ArrayList<>();
        for (Advertisement advertisement : advertisementStorage.list()) {
            if(advertisement.getHits()==0){
                inactiveVideos.add(advertisement);
            }
        }
        return inactiveVideos;
    }

    public List<Advertisement> getActiveVideoFromStorage(){
        List<Advertisement> activeVideos = new ArrayList<>();
        for (Advertisement advertisement : advertisementStorage.list()) {
            if(advertisement.getHits()>0){
                activeVideos.add(advertisement);
            }
        }
        return activeVideos;
    }
}
