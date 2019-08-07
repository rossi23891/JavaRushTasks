package com.javarush.task.task27.task2712;

import com.javarush.task.task27.task2712.statistic.StatisticManager;

import java.text.SimpleDateFormat;
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

    }

    public void printArchivedVideoSet(){

    }
}
