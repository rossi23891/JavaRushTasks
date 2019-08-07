package com.javarush.task.task27.task2712.kitchen;

import com.javarush.task.task27.task2712.ConsoleHelper;
import com.javarush.task.task27.task2712.Tablet;
import com.javarush.task.task27.task2712.statistic.StatisticManager;
import com.javarush.task.task27.task2712.statistic.event.CookedOrderEventDataRow;

import java.util.Observable;
import java.util.Observer;

public class Cook extends Observable implements Observer {
    private String name;

    public Cook(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return name;
    }


    @Override
    public void update(Observable o, Object order) {
        Tablet tablet = (Tablet)o;
        Order order1 =(Order)order;
        ConsoleHelper.writeMessage(String.format("Start cooking — %s", order1));
        StatisticManager.getInstance().register(new CookedOrderEventDataRow(tablet.toString(),this.name,order1.getTotalCookingTime()*60,order1.getDishes()));
        setChanged();
        notifyObservers(order);
    }
}
