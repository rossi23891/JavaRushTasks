package com.javarush.task.task27.task2712.kitchen;

import com.javarush.task.task27.task2712.ConsoleHelper;
import com.javarush.task.task27.task2712.Tablet;
import com.javarush.task.task27.task2712.statistic.StatisticManager;
import com.javarush.task.task27.task2712.statistic.event.CookedOrderEventDataRow;

import java.util.Observable;
import java.util.Observer;

public class Cook extends Observable{
    private String name;

    public Cook(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return name;
    }

    public void startCookingOrder(Order order){
        ConsoleHelper.writeMessage(String.format("Start cooking — %s", order));
        StatisticManager.getInstance().register(new CookedOrderEventDataRow(order.getTablet().toString(),this.name,order.getTotalCookingTime()*60,order.getDishes()));
        setChanged();
        notifyObservers(order);
    }

}
