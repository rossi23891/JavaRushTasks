package com.javarush.task.task22.task2210;

import java.util.ArrayList;
import java.util.StringTokenizer;

/*
StringTokenizer
*/
public class Solution {
    public static void main(String[] args) {
        String[]arr = getTokens("level22.lesson13.task01", ".");
        for (String s : arr) {
            System.out.println(s);
        }
    }
    public static String [] getTokens(String query, String delimiter) {
        ArrayList<String> tokens = new ArrayList<>();
        StringTokenizer tokenizer = new StringTokenizer(query,delimiter);
        String token = null;
        while (tokenizer.hasMoreTokens()){
            token = tokenizer.nextToken();
            tokens.add(token);
        }
        String[] result = new String[tokens.size()];
        for (int i = 0; i <result.length ; i++) {
            result[i]=tokens.get(i);
        }
        return result;
    }
}
