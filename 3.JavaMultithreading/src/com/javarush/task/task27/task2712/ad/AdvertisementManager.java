package com.javarush.task.task27.task2712.ad;


import com.javarush.task.task27.task2712.ConsoleHelper;
import com.javarush.task.task27.task2712.statistic.StatisticManager;
import com.javarush.task.task27.task2712.statistic.event.NoAvailableVideoEventDataRow;
import com.javarush.task.task27.task2712.statistic.event.VideoSelectedEventDataRow;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class AdvertisementManager {
    //у каждого планшета будет свой объект менеджера, который будет подбирать оптимальный набор роликов и их последовательность для каждого заказа.
    //Он также будет взаимодействовать с плеером и отображать ролики
    final AdvertisementStorage storage = AdvertisementStorage.getInstance();
    private int timeSeconds;// time of cooking in SECONDS
    private long bestPrice;
    private List<Advertisement> bestItems;

    public AdvertisementManager(int timeSeconds) {
        this.timeSeconds = timeSeconds;
    }

    public void processVideos() {
        if (storage.list().isEmpty()) {
            throw new NoVideoAvailableException();
        }
        List<Advertisement>checkAvailableHits =new ArrayList<>();
        for(Advertisement ad: storage.list()){
            if(ad.getHits()>0){
                checkAvailableHits.add(ad);
            }
        }
        List<Advertisement> videosToShow = findMostValuableAd(checkAvailableHits);
        Comparator<Advertisement> comparatorVideo = new Comparator<Advertisement>() {
            @Override
            public int compare(Advertisement o1, Advertisement o2) {
                long result = o2.getAmountPerOneDisplaying()-o1.getAmountPerOneDisplaying();
                if(result!=0){
                    return (int)result;
                }else{
                    return (int)((o1.getAmountPerOneDisplaying()/o1.getDuration()*1000) - (int)(o2.getAmountPerOneDisplaying()/o2.getDuration()*1000));
                }                 
            }
        };
        Collections.sort(videosToShow,comparatorVideo);
        for (Advertisement ad : videosToShow) {
            ConsoleHelper.writeMessage(ad.getName() + " is displaying... " + ad.getAmountPerOneDisplaying() + ", " + ad.getAmountPerOneDisplaying()*1000/(long)ad.getDuration());
            ad.revalidate();
        }
        if(videosToShow.size()>0){
            StatisticManager.getInstance().register(new VideoSelectedEventDataRow(videosToShow,calculateTotalAmount(videosToShow),calculateTolalDuration(videosToShow)));
        }else{
            StatisticManager.getInstance().register(new NoAvailableVideoEventDataRow(timeSeconds));
        }

    }

    public List<Advertisement> findMostValuableAd(List<Advertisement> totalVideos) {// лучший вариант
        findAllSets(totalVideos);
        return bestItems;
    }

    public void findAllSets(List<Advertisement> advertisements) {//найти все возм варианты
        if (advertisements.size() > 0) {
            checkIfBestSet(advertisements);
        }
        for (int i = 0; i < advertisements.size(); i++) {
            List<Advertisement> newSet = new ArrayList<>(advertisements);
            newSet.remove(i);
            findAllSets(newSet);
        }
    }

    private int calculateTolalDuration(List<Advertisement> advertisements) {// вычисляем продолжительноть набора видео
        int totalDuration = 0;
        for (Advertisement advertisement : advertisements) {
            totalDuration += advertisement.getDuration();
        }
        return totalDuration;
    }

    private long calculateTotalAmount(List<Advertisement> advertisements) {//вычиялет общую стоимость набора видео
        long totalAmount = 0;
        for (Advertisement advertisement : advertisements) {
            totalAmount += advertisement.getAmountPerOneDisplaying();
        }
        return totalAmount;
    }

    private void checkIfBestSet(List<Advertisement> advertisements) {
        if (bestItems == null) {
            if (calculateTolalDuration(advertisements) <= timeSeconds) {
                bestItems = advertisements;
                bestPrice = calculateTotalAmount(advertisements);
            }
        } else {
            if (calculateTolalDuration(advertisements) <= timeSeconds) {
                if (calculateTotalAmount(advertisements) > bestPrice) {
                    bestItems = advertisements;
                    bestPrice = calculateTotalAmount(advertisements);
                }else if(calculateTotalAmount(advertisements) == bestPrice){
                    if(calculateTolalDuration(bestItems)<calculateTolalDuration(advertisements)){
                        bestItems = advertisements;
                        bestPrice = calculateTotalAmount(advertisements);
                    }else if(calculateTolalDuration(bestItems)==calculateTolalDuration(advertisements)){
                        if(advertisements.size()<bestItems.size()){
                            bestItems = advertisements;
                            bestPrice = calculateTotalAmount(advertisements);
                        }
                    }
                }
            }
        }
    }


}
