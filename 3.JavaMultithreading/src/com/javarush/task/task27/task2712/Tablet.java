package com.javarush.task.task27.task2712;

import com.javarush.task.task27.task2712.ad.AdvertisementManager;
import com.javarush.task.task27.task2712.ad.NoVideoAvailableException;
import com.javarush.task.task27.task2712.kitchen.Order;
import com.javarush.task.task27.task2712.kitchen.TestOrder;
import com.javarush.task.task27.task2712.statistic.StatisticManager;
import com.javarush.task.task27.task2712.statistic.event.NoAvailableVideoEventDataRow;

import java.io.IOException;
import java.util.Observable;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Tablet extends Observable {//планшет
    final int number;
    static Logger logger = Logger.getLogger(Tablet.class.getName());

    public Tablet(int number) {
        this.number = number;
    }

    public Order createOrder() {
        try {
            Order order = new Order(this);
            processOrder(order);
            return order;
        } catch (IOException e) {
            logger.log(Level.SEVERE,"Console is unavailable.");
        }
        return null;
    }

    private void processOrder(Order order) {
        ConsoleHelper.writeMessage(order.toString());

        if (!order.isEmpty()) {
            setChanged();
            notifyObservers(order);
            AdvertisementManager advertisementManager = new AdvertisementManager(order.getTotalCookingTime() * 60);
            try {
                advertisementManager.processVideos();
            } catch (NoVideoAvailableException e) {
                StatisticManager.getInstance().register(new NoAvailableVideoEventDataRow(order.getTotalCookingTime() * 60));
                logger.log(Level.INFO, "No video is available for the order " + order);
            }
        }
    }

    public void createTestOrder() {
        try {
            Order order = new TestOrder(this);
            processOrder(order);
        } catch (IOException e) {
            logger.log(Level.SEVERE,"Console is unavailable.");
        }
    }

    @Override
    public String toString() {
        return "Tablet{" +
                "number=" + number +
                '}';
    }


}
