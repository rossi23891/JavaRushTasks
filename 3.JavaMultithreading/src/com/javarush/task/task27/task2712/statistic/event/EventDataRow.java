package com.javarush.task.task27.task2712.statistic.event;

import java.util.Date;

public interface EventDataRow {//интерфейс-маркет. опр. связанность с событиями
    EventType getType();
    Date getDate();//дату создания записи
    int getTime(); //время - продолжительность
}
