package com.javarush.task.task27.task2712.kitchen;

public enum Dish {
    Fish,
    Steak,
    Soup,
    Juice,
    Water;

    public static String allDishesToString(){
        StringBuilder builder = new StringBuilder();
        for(Dish dish: Dish.values()){
            builder.append(dish.toString());
            builder.append(", ");
        }
        String temp = builder.toString();
        return temp.substring(0,temp.length()-2);
    }
}
