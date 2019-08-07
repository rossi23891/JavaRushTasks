package com.javarush.task.task27.task2712.kitchen;

import com.javarush.task.task27.task2712.ConsoleHelper;
import com.javarush.task.task27.task2712.statistic.StatisticManager;
import com.javarush.task.task27.task2712.statistic.event.CookedOrderEventDataRow;

import java.util.Observable;

public class Cook extends Observable{
    private String name;
    private boolean busy;
    private StatisticManager statisticManager = StatisticManager.getInstance();


    public Cook(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return name;
    }

    public boolean isBusy() {
        return busy;
    }

    public void startCookingOrder(Order order){
        busy=true;
        try {
            Thread.sleep(order.getTotalCookingTime()*10);
        } catch (InterruptedException e) {
        }
        ConsoleHelper.writeMessage(String.format("Start cooking — %s", order));
        StatisticManager.getInstance().register(new CookedOrderEventDataRow(order.getTablet().toString(),this.name,order.getTotalCookingTime()*60,order.getDishes()));
        setChanged();
        notifyObservers(order);
        busy=false;
    }

}
