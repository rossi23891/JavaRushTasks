package com.javarush.task.task27.task2712;

import com.javarush.task.task27.task2712.kitchen.Cook;
import com.javarush.task.task27.task2712.kitchen.Order;
import com.javarush.task.task27.task2712.kitchen.Waiter;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.LinkedBlockingQueue;

public class Restaurant {
    private static final int ORDER_CREATING_INTERVAL = 100;
    private static final LinkedBlockingQueue<Order> orderQueue = new LinkedBlockingQueue<>();
    public static void main(String[] args) {
        Cook cook = new Cook("Amigo");
        Cook cook2 = new Cook("Lui");
        cook.setQueue(orderQueue);
        cook2.setQueue(orderQueue);
        List<Tablet> tabs = new ArrayList<>();
        for (int i = 1; i < 6 ; i++) {
            Tablet tablet = new Tablet(i);
            tabs.add(tablet);
            tablet.setQueue(orderQueue);
        }

        cook.addObserver(new Waiter());
        cook2.addObserver(new Waiter());

        Thread testThread = new Thread(new RandomOrderGeneratorTask(tabs,ORDER_CREATING_INTERVAL));
        testThread.start();
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
        }

        Thread testCook = new Thread(cook);
        Thread testCook2 = new Thread(cook2);

        testThread.interrupt();


        DirectorTablet directorTablet = new DirectorTablet();
        directorTablet.printAdvertisementProfit();
        //System.out.println("???????????????????????????????");
        directorTablet.printCookWorkloading();
        directorTablet.printActiveVideoSet();
        //System.out.println("-----------");
        directorTablet.printArchivedVideoSet();
    }

}
