package com.javarush.task.task27.task2712.statistic;

import com.javarush.task.task27.task2712.kitchen.Cook;
import com.javarush.task.task27.task2712.statistic.event.EventDataRow;
import com.javarush.task.task27.task2712.statistic.event.EventType;

import java.util.*;

public class StatisticManager {
    private static StatisticManager ourInstance = new StatisticManager();
    private StatisticStorage statisticStorage =  new StatisticStorage();
    private Set<Cook> cooks = new HashSet<>();

    public static StatisticManager getInstance() {
        return ourInstance;
    }

    private StatisticManager() {
    }
    public void register(EventDataRow data){
        statisticStorage.put(data);
    }
    public void register(Cook cook){
       cooks.add(cook);
    }

    private class StatisticStorage{
        private Map<EventType, List<EventDataRow>> storage;

        public StatisticStorage() {
            storage = new HashMap<>();
            for(int i = 0; i < EventType.values().length; i++){
                storage.put(EventType.values()[i],new ArrayList<EventDataRow>());
            }
        }
        private void put(EventDataRow data){
            storage.get(data.getType()).add(data);
        }
    }
}
