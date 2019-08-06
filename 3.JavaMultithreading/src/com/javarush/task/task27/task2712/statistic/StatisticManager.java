package com.javarush.task.task27.task2712.statistic;

import com.javarush.task.task27.task2712.kitchen.Cook;
import com.javarush.task.task27.task2712.statistic.event.CookedOrderEventDataRow;
import com.javarush.task.task27.task2712.statistic.event.EventDataRow;
import com.javarush.task.task27.task2712.statistic.event.EventType;
import com.javarush.task.task27.task2712.statistic.event.VideoSelectedEventDataRow;

import java.text.SimpleDateFormat;
import java.util.*;

public class StatisticManager {
    private static StatisticManager ourInstance = new StatisticManager();
    private StatisticStorage statisticStorage = new StatisticStorage();
    private Set<Cook> cooks = new HashSet<>();

    public static StatisticManager getInstance() {
        return ourInstance;
    }

    private StatisticManager() {
    }

    public void register(EventDataRow data) {
        statisticStorage.put(data);
    }

    public void register(Cook cook) {
        cooks.add(cook);
    }

    public Map<String, Double> getAdvertisementProfitDataPerDay() {
        Map<String, Double> profitPerDay = new TreeMap<>(Collections.reverseOrder());
        List<EventDataRow> advertisementEvents = statisticStorage.getStorage().get(EventType.SELECTED_VIDEOS);
        SimpleDateFormat format = new SimpleDateFormat("dd-MMMM-yyyy", Locale.ENGLISH);
        for (EventDataRow ad : advertisementEvents) {
            VideoSelectedEventDataRow videoEvent = (VideoSelectedEventDataRow) ad;
            String dateVideo = format.format(videoEvent.getDate());
            if (!profitPerDay.containsKey(dateVideo)) {
                profitPerDay.put(dateVideo, Double.valueOf(videoEvent.getAmount()));
            } else {
                double newAmount = profitPerDay.get(dateVideo) + videoEvent.getAmount();
                profitPerDay.put(dateVideo, newAmount);
            }
        }
        return profitPerDay;
    }

    public Map<Date, Map<String, Integer>> getCookStatisticPerDay() {
        Map<Date, Map<String, Integer>> cookPerDay = new TreeMap<>();
        List<EventDataRow> cookEvents = statisticStorage.getStorage().get(EventType.COOKED_ORDER);
        for (EventDataRow eventDataRow : cookEvents) {
            CookedOrderEventDataRow cookEvent = (CookedOrderEventDataRow) eventDataRow;
            Date date = cookEvent.getDate();
            Map<String, Integer> cookDataMap = new TreeMap<>();
            for (EventDataRow event1 : cookEvents) {
                CookedOrderEventDataRow cookEvent1 = (CookedOrderEventDataRow) eventDataRow;
                int time = cookEvent1.getTime();
                String name = cookEvent1.getCookName();
                if (cookEvent.getDate() == date) {
                    if (!cookDataMap.containsKey(name)) {
                        cookDataMap.put(name, time);
                    } else {
                        int newTime = cookDataMap.get(name) + cookEvent1.getTime();
                        cookDataMap.put(name, newTime);
                    }
                }

            }
            cookPerDay.put(date, cookDataMap);
        }

        return cookPerDay;
    }


    private class StatisticStorage {
        private Map<EventType, List<EventDataRow>> storage;

        public Map<EventType, List<EventDataRow>> getStorage() {
            return storage;
        }

        public StatisticStorage() {
            storage = new HashMap<>();
            for (int i = 0; i < EventType.values().length; i++) {
                storage.put(EventType.values()[i], new ArrayList<EventDataRow>());
            }
        }

        private void put(EventDataRow data) {
            storage.get(data.getType()).add(data);
        }
    }
}
