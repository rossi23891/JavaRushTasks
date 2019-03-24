package com.javarush.task.task08.task0815;

import java.util.*;

/* 
Перепись населения
*/

public class Solution {
    public static HashMap<String, String> createMap() {
        //напишите тут ваш коa
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

    public static int getCountTheSameFirstName(HashMap<String, String> map, String name) {
        //напишите тут ваш код
        int count = 0;
        for (Map.Entry <String,String> pair : map.entrySet()){
            String value = pair.getValue();
            if(value.equals(name)){
                count++;
            }
        }
        return count;
    }

    public static int getCountTheSameLastName(HashMap<String, String> map, String lastName) {
        //напишите тут ваш ко
        int count = 0;
        if(map.containsKey(lastName)){
            count = 1;
        } else{
            count = 0;
        }
        return count;
    }

    public static void main(String[] args) {

    }
}
