package com.javarush.task.task27.task2712;

import com.javarush.task.task27.task2712.statistic.StatisticManager;

import java.text.SimpleDateFormat;
import java.util.*;

public class DirectorTablet {

    public void printAdvertisementProfit(){
        Map<String,Double> adProfitMap = StatisticManager.getInstance().getAdvertisementProfitDataPerDay();
        double total=0.0;
        for (Map.Entry<String, Double> entry : adProfitMap.entrySet()) {
            ConsoleHelper.writeMessage(String.format(Locale.ENGLISH, "%s - %.2f", entry.getKey(), entry.getValue()/100.0));
            total+=entry.getValue();
        }
        if(total>0){
            ConsoleHelper.writeMessage(String.format(Locale.ENGLISH, "Total - %.2f", total/100.0));
        }
    }

    public void printCookWorkloading(){
        Map<Date,Map<String,Integer>> cookPerDay = StatisticManager.getInstance().getCookStatisticPerDay();

        for(Map.Entry entry :cookPerDay.entrySet()){
            SimpleDateFormat format = new SimpleDateFormat("dd-MMMM-yyyy", Locale.ENGLISH);
            ConsoleHelper.writeMessage(format.format(entry.getKey()));
            Map<String,Integer> cooksList = (Map)entry.getValue();
            for(Map.Entry pairs : cooksList.entrySet()){
                int totalCookingTime = (int)(pairs.getValue());
                ConsoleHelper.writeMessage(pairs.getKey() + " - " + totalCookingTime/60 + " min");
            }
        }
    }

    public void printActiveVideoSet(){

    }

    public void printArchivedVideoSet(){

    }
}
