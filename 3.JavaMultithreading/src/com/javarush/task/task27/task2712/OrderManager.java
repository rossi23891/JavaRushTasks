package com.javarush.task.task27.task2712;

import com.javarush.task.task27.task2712.kitchen.Cook;
import com.javarush.task.task27.task2712.kitchen.Order;
import com.javarush.task.task27.task2712.statistic.StatisticManager;

import java.util.Observable;
import java.util.Observer;
import java.util.concurrent.LinkedBlockingQueue;

public class OrderManager implements Observer {
    LinkedBlockingQueue<Order> orderQueue = new LinkedBlockingQueue<>();

    public OrderManager() {
        Thread checkCooksAvailableThread = new Thread(new Runnable() {
            @Override
            public void run() {
                while (true){
                    if(orderQueue.isEmpty()){
                        try {
                            Thread.sleep(10);
                        } catch (InterruptedException e) {
                        }
                    }else{
                        for(Cook cook: StatisticManager.getInstance().getCooks()){
                            if(!cook.isBusy()){
                                Order orderToTake = orderQueue.poll();
                                cook.startCookingOrder(orderToTake);
                            }
                        }
                    }
                }

            }
        });
        checkCooksAvailableThread.setDaemon(true);
        checkCooksAvailableThread.start();

    }

    @Override
    public void update(Observable o, Object order) {
        try {
            orderQueue.put((Order)order);
        } catch (InterruptedException e) {
        }
    }
}
