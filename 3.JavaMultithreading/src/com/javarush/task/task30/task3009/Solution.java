package com.javarush.task.task30.task3009;

import java.math.BigInteger;
import java.util.HashSet;
import java.util.Set;
import java.util.TreeSet;

/* 
Палиндром?
*/

public class Solution {
    public static void main(String[] args) {
        System.out.println(getRadix("112"));        //expected output: [3, 27, 13, 15]
        System.out.println(getRadix("123"));        //expected output: [6]
        System.out.println(getRadix("5321"));       //expected output: []
        System.out.println(getRadix("1A"));         //expected output: []
    }

    private static Set<Integer> getRadix(String number){
        Set<Integer> countingSystems = new TreeSet<>();
        try {
            StringBuilder builder = new StringBuilder();
            for (int i = 2; i <=36 ; i++) {
                BigInteger helpInteger = new BigInteger(number,10);
                String checkPalindrom = helpInteger.toString(i);
                builder.append(checkPalindrom);
                if(checkPalindrom.equals(builder.reverse().toString())){
                    countingSystems.add(i);
                }
                builder.delete(0,checkPalindrom.length());
            }
        } catch (Exception e) {
        }
        return countingSystems;
    }
}