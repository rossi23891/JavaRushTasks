package com.javarush.task.task27.task2712;

import com.javarush.task.task27.task2712.ad.AdvertisementManager;
import com.javarush.task.task27.task2712.kitchen.Order;

import java.io.IOException;
import java.util.Observable;
import java.util.logging.Logger;

public class Tablet extends Observable {//планшет
    final int number;
    static Logger logger = Logger.getLogger(Tablet.class.getName());

    public Tablet(int number) {
        this.number = number;
    }

    public Order createOrder(){
        Order order=null;
        AdvertisementManager advertisementManager;
        try {
             order = new Order(this);
             if(!order.isEmpty()){
                 setChanged();
                 notifyObservers(order);
                 advertisementManager = new AdvertisementManager(order.getTotalCookingTime()*60);
                 advertisementManager.processVideos();
             }

        } catch (IOException e) {
            logger.severe("Console is unavailable.");
        }
        return order;
    }

    @Override
    public String toString() {
        return "Tablet{" +
                "number=" + number +
                '}';
    }


}
