package com.javarush.task.task39.task3901;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

/* 
Уникальные подстроки
*/
public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        System.out.println("Please enter your string: ");
        String s = bufferedReader.readLine();

        System.out.println("The longest unique substring length is: \n" + lengthOfLongestUniqueSubstring(s));
    }

    public static int lengthOfLongestUniqueSubstring(String s) {
        int max=1;
        int currentMax = 0;
        if(s==null || s.isEmpty()){
            return 0;
        }
        Set<Character> letters = new HashSet<>();
        for (int i = 0; i < s.length() ; i++) {
            if(!letters.contains(s.charAt(i))){
                letters.add(s.charAt(i));
                currentMax++;
                if(currentMax>max){
                    max=currentMax;
                }
            }else{
                currentMax=1;
            }
        }
        return max;
    }
}
