package com.javarush.task.task08.task0818;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

/* 
Только для богачей
*/

public class Solution {
    public static HashMap<String, Integer> createMap() {
        //напишите тут ваш код
        HashMap<String,Integer> salary = new HashMap<>();
        salary.put("Ivan",80);
        salary.put("Ilona",860);
        salary.put("kolya",900);
        salary.put("lonu",499);
        salary.put("Emil",500);
        salary.put("ftyu",390);
        salary.put("ghio",238);
        salary.put("Tyui",359);
        salary.put("klop",459);
        salary.put("Alenj",489);
        return salary;
    }

    public static void removeItemFromMap(HashMap<String, Integer> map) {
        //напишите тут ваш код
        Iterator<Map.Entry<String,Integer>> iter = map.entrySet().iterator();
        while(iter.hasNext()){
            Map.Entry<String, Integer> pair = iter.next();
            if(pair.getValue()< 500){
                iter.remove();
            }
        }
    }

    public static void main(String[] args) {

    }
}