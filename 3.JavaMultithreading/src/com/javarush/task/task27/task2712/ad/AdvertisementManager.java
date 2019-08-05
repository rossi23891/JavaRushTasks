package com.javarush.task.task27.task2712.ad;

public class AdvertisementManager {
    //у каждого планшета будет свой объект менеджера, который будет подбирать оптимальный набор роликов и их последовательность для каждого заказа.
    //Он также будет взаимодействовать с плеером и отображать ролики
    final AdvertisementStorage storage = AdvertisementStorage.getInstance();
    private int timeSeconds;// time of cooking in SECONDS

    public AdvertisementManager(int timeSeconds) {
        this.timeSeconds = timeSeconds;
    }
    public void processVideos(){
        System.out.println("calling processVideos method");
    }

}
