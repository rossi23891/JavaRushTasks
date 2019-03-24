package com.javarush.task.task08.task0821;

import java.util.HashMap;
import java.util.Map;

/* 
Однофамильцы и тёзки
*/

public class Solution {
    public static void main(String[] args) {
        Map<String, String> map = createPeopleList();
        printPeopleList(map);
    }

    public static Map<String, String> createPeopleList() {
        //напишите тут ваш код
        Map<String,String> people = new HashMap<>();
        people.put("F1","N1");
        people.put("F2","N2");
        people.put("F3","N3");
        people.put("F4","N4");
        people.put("F5","N5");
        people.put("F6","N6");
        people.put("F7","N7");
        people.put("F8","N8");
        people.put("F1","N9");
        people.put("F10","N1");
        return people;
    }

    public static void printPeopleList(Map<String, String> map) {
        for (Map.Entry<String, String> s : map.entrySet()) {
            System.out.println(s.getKey() + " " + s.getValue());
        }
    }
}
