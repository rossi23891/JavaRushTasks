package com.javarush.task.task09.task0927;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/* 
Десять котов
*/

public class Solution {
    public static void main(String[] args) {
        Map<String, Cat> map = createMap();
        Set<Cat> set = convertMapToSet(map);
        printCatSet(set);
    }

    public static Map<String, Cat> createMap() {
        //напишите тут ваш код
        Map<String,Cat> catmapa = new HashMap<>();
        String[] names = {"barsik","zaika","lola","murka","esmi","persik","tishka","vaska","polli","andrew"};
        for (String name : names) {
            Cat cat = new Cat(name);
            catmapa.put(name,cat);
        }
        return catmapa;
    }

    public static Set<Cat> convertMapToSet(Map<String, Cat> map) {
        //напишите тут ваш код
        Set<Cat> catset = new HashSet<>();
        for(Map.Entry<String,Cat> pair : map.entrySet()){
            Cat catti = pair.getValue();
            if(!catset.contains(catti)){
                catset.add(catti);
            }
        }
        return catset;
    }

    public static void printCatSet(Set<Cat> set) {
        for (Cat cat : set) {
            System.out.println(cat);
        }
    }

    public static class Cat {
        private String name;

        public Cat(String name) {
            this.name = name;
        }

        public String toString() {
            return "Cat " + this.name;
        }
    }


}
