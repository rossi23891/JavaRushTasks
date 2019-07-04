package com.javarush.task.task18.task1821;

/* 
Встречаемость символов
*/

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Map;
import java.util.SortedMap;
import java.util.TreeMap;

public class Solution {
    public static void main(String[] args) throws IOException {
        FileInputStream fileInputStream = new FileInputStream(args[0]);
        Map<Character,Integer> frequency = new TreeMap<>();
        while(fileInputStream.available()>0){
            int data = fileInputStream.read();
            if(!frequency.containsKey((char)data)){
                frequency.put((char)data,1);
            }else{
                int count = frequency.get((char)data);
                frequency.put((char)data,count+1);
            }
        }
        fileInputStream.close();
        for(Map.Entry<Character,Integer> pairs: frequency.entrySet()){
            char c = pairs.getKey();
            int num = pairs.getValue();
            System.out.println(c + " " + num);
        }

    }
}
