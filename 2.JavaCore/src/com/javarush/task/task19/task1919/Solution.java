package com.javarush.task.task19.task1919;

/* 
Считаем зарплаты
*/

import java.io.*;
import java.util.Map;
import java.util.TreeMap;

public class Solution {
    public static void main(String[] args) throws IOException {
        Map<String,Double> pairs = new TreeMap<>();
        try (BufferedReader reader = new BufferedReader(new FileReader(args[0]))) {
            while (reader.ready()){
                String[] line = reader.readLine().split(" ");
                if(!pairs.containsKey(line[0])){
                    pairs.put(line[0],Double.parseDouble(line[1]));
                }else{
                    pairs.put(line[0],pairs.get(line[0])+Double.parseDouble(line[1]));
                }
            }
            for(Map.Entry<String,Double> map : pairs.entrySet()){
                System.out.println(map.getKey() + " " + map.getValue());
            }
        }
    }
}
