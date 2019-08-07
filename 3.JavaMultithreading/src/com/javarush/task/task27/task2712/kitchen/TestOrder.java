package com.javarush.task.task27.task2712.kitchen;

import com.javarush.task.task27.task2712.Tablet;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class TestOrder extends Order{
    public TestOrder(Tablet tablet) throws IOException {
        super(tablet);
        dishes= initDishes();
    }

    @Override
    protected List<Dish> initDishes() throws IOException {
        List<Dish> testDishes = new ArrayList<>();
        int size = (int) (Math.random() * 10);
        Random random = new Random();

        for (int i = 0; i < size; i++) {
            testDishes.add(Dish.values()[random.nextInt(Dish.values().length)]);
        }
        return testDishes;
    }

    @Override
    public String toString() {
        return super.toString();
    }
}
