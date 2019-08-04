package com.javarush.task.task27.task2712;

import com.javarush.task.task27.task2712.kitchen.Dish;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class ConsoleHelper {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    public static void writeMessage(String message){
        System.out.println(message);
    }
    public static String readString() throws IOException {
        return br.readLine();
    }

    public static List<Dish> getAllDishesForOrder() throws IOException {// просит пользователя выбрать блюдо и добавляет его в список
        List<Dish> order = new ArrayList<>();
        List<String> dishesList = new ArrayList<>();
        for(Dish dish: Dish.values()){
            dishesList.add(dish.toString());
        }
        writeMessage(Dish.allDishesToString());
        writeMessage("Please, enter the name of the dish you'd like to choose");
        String dishChosen;
        while (!(dishChosen=readString()).equals("exit")){
            if(!dishesList.contains(dishChosen)){
                writeMessage("No such dish on the menu");
            }else{
                order.add(Dish.valueOf(dishChosen));
            }
        }
        return order;
    }
}
