package com.javarush.task.task27.task2712;

import com.javarush.task.task27.task2712.ad.Advertisement;
import com.javarush.task.task27.task2712.ad.StatisticAdvertisementManager;
import com.javarush.task.task27.task2712.statistic.StatisticManager;

import java.util.*;

public class DirectorTablet {

    public void printAdvertisementProfit(){
        Map<String,Double> adProfitMap = StatisticManager.getInstance().getAdvertisementProfitDataPerDay();
        Double total=0D;
        for (Map.Entry<String, Double> entry : adProfitMap.entrySet()) {
            ConsoleHelper.writeMessage(String.format(Locale.ENGLISH, "%s - %.2f", entry.getKey(), entry.getValue()));
            total+=entry.getValue();
        }
        if(total>0){
            ConsoleHelper.writeMessage(String.format(Locale.ENGLISH, "Total - %.2f", total));
        }
    }

    public void printCookWorkloading(){
        Map<String,Map<String,Integer>> cookPerDay = StatisticManager.getInstance().getCookStatisticPerDay();
        String currentDate = null;
        for(Map.Entry<String, Map<String, Integer>> entry :cookPerDay.entrySet()){
            for(Map.Entry<String, Integer> pairs : entry.getValue().entrySet()){
                if(currentDate!=(entry.getKey())){
                    currentDate = entry.getKey();
                    ConsoleHelper.writeMessage(entry.getKey());
                }
                String cookName = pairs.getKey();
                int workTime = (int) Math.ceil(pairs.getValue()/60.0);
                ConsoleHelper.writeMessage(String.format("%s - %d min", cookName, workTime));
            }
        }
    }

    public void printActiveVideoSet(){
        List<Advertisement> activeVideos = StatisticAdvertisementManager.getInstance().getActiveVideoFromStorage();
        Comparator<Advertisement> advertisementComparator = new Comparator<Advertisement>() {
            @Override
            public int compare(Advertisement o1, Advertisement o2) {
                return o1.getName().compareToIgnoreCase(o2.getName());
            }
        };
        Collections.sort(activeVideos,advertisementComparator);
        for (Advertisement activeVideo : activeVideos) {
            ConsoleHelper.writeMessage(String.format("%s - %d", activeVideo.getName(), activeVideo.getHits()));
        }
    }

    public void printArchivedVideoSet(){
        List<Advertisement> inactiveVideos = StatisticAdvertisementManager.getInstance().getInactiveVideoFromStorage();
        Comparator<Advertisement> advertisementComparator = new Comparator<Advertisement>() {
            @Override
            public int compare(Advertisement o1, Advertisement o2) {
                return o1.getName().compareToIgnoreCase(o2.getName());
            }
        };
        Collections.sort(inactiveVideos,advertisementComparator);
        for (Advertisement inactiveVideo : inactiveVideos) {
            ConsoleHelper.writeMessage(inactiveVideo.getName());
        }
    }
}
