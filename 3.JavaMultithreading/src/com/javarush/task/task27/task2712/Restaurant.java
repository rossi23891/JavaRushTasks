package com.javarush.task.task27.task2712;

import com.javarush.task.task27.task2712.kitchen.Cook;
import com.javarush.task.task27.task2712.kitchen.Waiter;
import com.javarush.task.task27.task2712.statistic.StatisticManager;

import java.util.ArrayList;
import java.util.List;

public class Restaurant {
    private static final int ORDER_CREATING_INTERVAL = 100;
    public static void main(String[] args) {
        Cook cook = new Cook("Amigo");
        Cook cook2 = new Cook("Lui");
        StatisticManager.getInstance().register(cook);
        StatisticManager.getInstance().register(cook2);
        List<Tablet> tabs = new ArrayList<>();
        for (int i = 1; i < 6 ; i++) {
            Tablet tablet = new Tablet(i);
            tabs.add(tablet);
            tablet.addObserver(cook);
            tablet.addObserver(cook2);
        }
        cook.addObserver(new Waiter());
        cook2.addObserver(new Waiter());

        Thread testThread = new Thread(new RandomOrderGeneratorTask(tabs,ORDER_CREATING_INTERVAL));
        testThread.start();
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
        }

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
