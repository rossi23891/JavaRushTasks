package com.javarush.task.task19.task1920;

/* 
Самый богатый
*/

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Collection;
import java.util.Collections;
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
            Collection<Double> vals = pairs.values();
            Double max = Collections.max(vals);
            for(Map.Entry<String,Double> map : pairs.entrySet()){
                Double currentVal = map.getValue();
                if(currentVal.equals(max)){
                    System.out.println(map.getKey() + " ");
                }
            }
        }
    }
}
