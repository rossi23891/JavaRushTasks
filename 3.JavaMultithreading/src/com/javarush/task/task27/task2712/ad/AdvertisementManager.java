package com.javarush.task.task27.task2712.ad;

import java.util.ArrayList;
import java.util.List;

public class AdvertisementManager {
    //у каждого планшета будет свой объект менеджера, который будет подбирать оптимальный набор роликов и их последовательность для каждого заказа.
    //Он также будет взаимодействовать с плеером и отображать ролики
    final AdvertisementStorage storage = AdvertisementStorage.getInstance();
    private int timeSeconds;// time of cooking in SECONDS
    private long bestPrice;

    public AdvertisementManager(int timeSeconds) {
        this.timeSeconds = timeSeconds;
    }
    public void processVideos(){
        if(storage.list().isEmpty()){
            throw new NoVideoAvailableException();
        }
    }

    public List<Advertisement> findMostValuableAd(List<Advertisement> totalVideos,int timeSeconds){
        return null;
    }

    private int calculateTolalDuration(List<Advertisement> advertisements){// вычисляем продолжительноть набора видео
        int totalDuration = 0;
        for (Advertisement advertisement : advertisements) {
            totalDuration+=advertisement.getDuration();
        }
        return totalDuration;
    }

    private long calculateTotalAmount(List<Advertisement> advertisements){//вычиялет общую стоимость набора видео
        long totalAmount=0;
        for (Advertisement advertisement : advertisements) {
            totalAmount+=advertisement.getAmountPerOneDisplaying();
        }
        return totalAmount;
    }



}
