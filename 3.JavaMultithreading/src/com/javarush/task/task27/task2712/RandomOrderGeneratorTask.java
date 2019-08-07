package com.javarush.task.task27.task2712;

import java.util.List;

public class RandomOrderGeneratorTask implements Runnable {
    List<Tablet> allTabList;
    Tablet selectedTablet;
    private  int interval;

    public RandomOrderGeneratorTask(List<Tablet> allTabList, int interval) {
        this.allTabList = allTabList;
        this.interval = interval;
    }

    @Override
    public void run() {
        selectedTablet = allTabList.get((int) (Math.random() * allTabList.size()));
        try {
            Thread.sleep(interval);
            selectedTablet.createTestOrder();
        } catch (InterruptedException e) {
        }
    }
}
