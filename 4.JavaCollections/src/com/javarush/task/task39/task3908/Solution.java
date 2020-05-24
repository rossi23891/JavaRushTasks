package com.javarush.task.task39.task3908;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

/*
Возможен ли палиндром?
*/
public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        System.out.println(isPalindromePermutation(bufferedReader.readLine()));
    }

    public static boolean isPalindromePermutation(String s) {
        if(s==null || s.isEmpty()){
            return false;
        }
        String s1 = s.toLowerCase();
        Map<Character,Integer> map = new HashMap<>();
        for (int i = 0; i < s.length() ; i++) {
            char charAt = s1.charAt(i);
            map.put(charAt, map.containsKey(charAt) ? map.get(charAt) + 1 : 1);
        }
        List<Integer> data = new ArrayList<>(map.values());
        if(data.size()<2){
            return true;
        }else if(data.size()==2){
            if(data.get(0)%2==1){
                return data.get(1)%2==0;
            }else{
                return true;
            }
        }else{
            Map<Integer,Integer> dev = new HashMap<>();
            for (Integer datum : data) {
                int d = datum % 2;
                dev.put(d, dev.containsKey(d) ? dev.get(d) + 1 : 1);
            }
            if(dev.keySet().size()==1 && dev.containsKey(0)){
                return true;
            }else if(dev.get(1)==1){
                return  true;
            }
        }
        return false;
    }
}
