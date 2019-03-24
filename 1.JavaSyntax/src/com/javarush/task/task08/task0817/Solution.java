package com.javarush.task.task08.task0817;

import java.util.*;

/* 
Нам повторы не нужны
*/

public class Solution {
    public static HashMap<String, String> createMap() {
        //напишите тут ваш код
        HashMap<String,String> names = new HashMap<>();
        names.put("name1","val");
        names.put("name2","val2");
        names.put("name3","val3");
        names.put("name4","val4");
        names.put("name5","val");
        names.put("name6","val");
        names.put("name7","val4");
        names.put("name8","val9");
        names.put("name9","val10");
        names.put("name10","val1");
        return names;

    }

    public static void removeTheFirstNameDuplicates(Map<String, String> map) {
        //напишите тут ваш кодap
        Map<String,Integer> valuescount = new HashMap<>();
        for (Map.Entry<String,String> pair : map.entrySet()){
            String value0 = pair.getValue();
            if(!valuescount.containsKey(value0)){
                valuescount.put(value0,1);
            } else{
                int a = valuescount.get(value0);
                a++;
                valuescount.put(value0,a);
            }
        }
        for(Map.Entry<String,Integer> pair2: valuescount.entrySet()){
            Integer val2 = pair2.getValue();
            if(val2>1){
                removeItemFromMapByValue(map,pair2.getKey());
            }
        }
    }

    public static void removeItemFromMapByValue(Map<String, String> map, String value) {
        HashMap<String, String> copy = new HashMap<String, String>(map);
        for (Map.Entry<String, String> pair : copy.entrySet()) {
            if (pair.getValue().equals(value))
                map.remove(pair.getKey());
        }
    }

    public static void main(String[] args) {

    }
}
