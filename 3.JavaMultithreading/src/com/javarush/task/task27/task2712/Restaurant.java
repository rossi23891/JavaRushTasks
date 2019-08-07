package com.javarush.task.task27.task2712;

import com.javarush.task.task27.task2712.kitchen.Cook;
import com.javarush.task.task27.task2712.kitchen.Waiter;

public class Restaurant {
    public static void main(String[] args) {
        Tablet tablet = new Tablet(1);
        //Tablet tablet2 = new Tablet(1);
        Cook cook = new Cook("Amigo");
        //Cook cook2 = new Cook("Lui");
        tablet.addObserver(cook);
        cook.addObserver(new Waiter());
        tablet.createOrder();
        //tablet.createOrder();
        /*tablet.createOrder();
        tablet.createOrder();*/

        DirectorTablet directorTablet = new DirectorTablet();
        directorTablet.printActiveVideoSet();

        directorTablet.printArchivedVideoSet();


        /*Map<Date,Double> mapa = StatisticManager.getInstance().getAdvertisementProfitDataPerDay(StatisticManager.getInstance().get());
        System.out.println(mapa.toString());
        System.out.println("----------------------------");*/
        directorTablet.printAdvertisementProfit();
        //System.out.println("???????????????????????????????");
        directorTablet.printCookWorkloading();
    }
}
