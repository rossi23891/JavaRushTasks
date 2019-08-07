package com.javarush.task.task27.task2712.ad;

import java.util.ArrayList;
import java.util.List;

public class AdvertisementStorage {
    //хранилище рекламных роликов
    private static AdvertisementStorage ourInstance = new AdvertisementStorage();

    public static AdvertisementStorage getInstance() {
        return ourInstance;
    }

    private AdvertisementStorage() {
        Object someContent = new Object();
        videos.add(new Advertisement(someContent, "First Video", 5000, 100, 3 * 60)); // 3 min
        videos.add(new Advertisement(someContent, "второе Video", 100, 3, 15 * 60)); //15 min
        videos.add(new Advertisement(someContent, "третье Video", 400, 2, 10 * 60)); //10 min
    }

    final List<Advertisement> videos = new ArrayList<>();

    public List<Advertisement>list(){
        return videos;
    }

    public void add(Advertisement advertisement){
        videos.add(advertisement);
    }
}
