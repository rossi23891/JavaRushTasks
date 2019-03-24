package com.javarush.task.task07.task0715;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;

/* 
Продолжаем мыть раму
*/

public class Solution {
    public static void main(String[] args) throws Exception {
        //напишите тут ваш код
        ArrayList<String> mama = new ArrayList<>();
        mama.add("мама");
        mama.add("мыла");
        mama.add("раму");
        for (int i = 1; i < 6; i+=2) {
            mama.add(i,"именно");
        }
        for(String s: mama){
            System.out.println(s);
        }
    }
}
