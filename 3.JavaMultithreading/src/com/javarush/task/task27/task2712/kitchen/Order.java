package com.javarush.task.task27.task2712.kitchen;

import com.javarush.task.task27.task2712.ConsoleHelper;
import com.javarush.task.task27.task2712.Tablet;

import java.io.IOException;
import java.util.List;

public class Order {//должна быть информация, относящаяся к списку выбранных пользователем блюд
    private final Tablet tablet;

    public Tablet getTablet() {
        return tablet;
    }

    public List<Dish> getDishes() {
        return dishes;
    }

    protected List<Dish> dishes;

    public Order(Tablet tablet) throws IOException {
        this.tablet = tablet;
        dishes=initDishes();
    }

    @Override
    public String toString() {
        if(dishes.isEmpty()){
            return "";
        }else{
            return "Your order: " + dishes + " of " + tablet.toString() + ", cooking time " + getTotalCookingTime() + "min" ;
        }
    }

    public boolean isEmpty(){
       return dishes.isEmpty();
    }

    public int getTotalCookingTime(){
        int totalTime = 0;
        for (Dish dish : dishes) {
            totalTime+=dish.getDuration();
        }
        return totalTime;
    }

    protected List<Dish> initDishes() throws IOException {
        dishes = ConsoleHelper.getAllDishesForOrder();
        return dishes;
    }


}
