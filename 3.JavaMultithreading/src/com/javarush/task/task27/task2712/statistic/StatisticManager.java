package com.javarush.task.task27.task2712.statistic;

import com.javarush.task.task27.task2712.statistic.event.CookedOrderEventDataRow;
import com.javarush.task.task27.task2712.statistic.event.EventDataRow;
import com.javarush.task.task27.task2712.statistic.event.EventType;
import com.javarush.task.task27.task2712.statistic.event.VideoSelectedEventDataRow;

import java.text.SimpleDateFormat;
import java.util.*;

public class StatisticManager {
    private static StatisticManager ourInstance = new StatisticManager();
    private StatisticStorage statisticStorage = new StatisticStorage();

    public static StatisticManager getInstance() {
        return ourInstance;
    }

    private StatisticManager() {
    }

    public void register(EventDataRow data) {
        statisticStorage.put(data);
    }

    public Map<String, Double> getAdvertisementProfitDataPerDay() {
        Map<String, Double> profitPerDay = new TreeMap<>(Collections.reverseOrder());
        List<EventDataRow> advertisementEvents = statisticStorage.getAllRowsOfType(EventType.SELECTED_VIDEOS);
        SimpleDateFormat format = new SimpleDateFormat("dd-MMM-yyyy", Locale.ENGLISH);
        for (EventDataRow ad : advertisementEvents) {
            VideoSelectedEventDataRow videoEvent = (VideoSelectedEventDataRow) ad;
            String dateVideo = format.format(videoEvent.getDate());
            if (!profitPerDay.containsKey(dateVideo)) {
                profitPerDay.put(dateVideo, videoEvent.getAmount()/100.0);
            } else {
                double newAmount = profitPerDay.get(dateVideo) + videoEvent.getAmount()/100.0;
                profitPerDay.put(dateVideo, newAmount);
            }
        }
        return profitPerDay;
    }

    public Map<String, Map<String, Integer>> getCookStatisticPerDay() {
        Map<String, Map<String, Integer>> cookPerDay = new TreeMap<>(Collections.reverseOrder());
        List<EventDataRow> cookEvents = statisticStorage.getAllRowsOfType(EventType.COOKED_ORDER);
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("dd-MMM-yyyy", Locale.ENGLISH);
        for (EventDataRow eventDataRow : cookEvents) {
            CookedOrderEventDataRow cookEvent = (CookedOrderEventDataRow) eventDataRow;
            String dateKey = simpleDateFormat.format(cookEvent.getDate());
            String cookName = cookEvent.getCookName();
            Integer workTime = cookEvent.getTime();

            if (workTime > 0) {
                if (cookPerDay.containsKey(dateKey))
                {
                    //Получаем все записи с этой датой
                    Map<String, Integer> cooks = cookPerDay.get(dateKey);
                    //Если запись с поваром уже есть
                    if (cooks.containsKey(cookName))
                    {
                        //Обновляем запись с новой суммой времени
                        cooks.put(cookName, cooks.get(cookName) + cookEvent.getTime());
                    }
                    else
                    {
                        //Иначе добавляем нового повара
                        cooks.put(cookName, cookEvent.getTime());
                    }
                }
                else {
                    //Если записи с датой нет, то добавляем новую запись
                    cookPerDay.put(dateKey, new TreeMap<>());
                    cookPerDay.get(dateKey).put(cookName, cookEvent.getTime());
                }
            }
        }

        return cookPerDay;
    }


    private class StatisticStorage {
        private Map<EventType, List<EventDataRow>> storage;

        private List<EventDataRow> getAllRowsOfType(EventType eventType)
        {
            return storage.get(eventType);
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
