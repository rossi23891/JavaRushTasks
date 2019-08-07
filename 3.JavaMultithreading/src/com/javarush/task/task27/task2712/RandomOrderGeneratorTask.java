package com.javarush.task.task27.task2712;

import java.util.List;

public class RandomOrderGeneratorTask implements Runnable {
    List<Tablet> tablets;
    Tablet selectedTablet;
    private  int interval;

    public RandomOrderGeneratorTask(List<Tablet> tablets, int interval) {
        this.tablets = tablets;
        this.interval = interval;
    }

    @Override
    public void run() {
        selectedTablet = tablets.get((int) (Math.random() * tablets.size()));
        try {
            Thread.sleep(interval);
            selectedTablet.createTestOrder();
        } catch (InterruptedException e) {
        }
    }
}
