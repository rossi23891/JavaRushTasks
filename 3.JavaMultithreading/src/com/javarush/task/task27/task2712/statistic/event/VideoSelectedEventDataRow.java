package com.javarush.task.task27.task2712.statistic.event;

import com.javarush.task.task27.task2712.ad.Advertisement;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Locale;

public class VideoSelectedEventDataRow implements EventDataRow {// event - выбрали набор видео-роликов для заказа
    List<Advertisement> optimalVideoSet;// - список видео-роликов, отобранных для показа
    long amount;// - сумма денег в копейках
    int totalDuration;// - общая продолжительность показа отобранных рекламных роликов
    Date currentDate;

    public VideoSelectedEventDataRow(List<Advertisement> optimalVideoSet, long amount, int totalDuration) {
        this.optimalVideoSet = optimalVideoSet;
        this.amount = amount;
        this.totalDuration = totalDuration;
        this.currentDate = new Date();
    }

    @Override
    public EventType getType() {
        return EventType.SELECTED_VIDEOS;
    }

    public long getAmount() {
        return amount;
    }

    @Override
    public Date getDate() {
        return currentDate;
    }

    @Override
    public int getTime() {
        return totalDuration;
    }
}
