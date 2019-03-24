package com.javarush.task.task09.task0930;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;

/* 
Задача по алгоритмам
*/

public class Solution {
    public static void main(String[] args) throws Exception {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        ArrayList<String> list = new ArrayList<>();
        while (true) {
            String s = reader.readLine();
            if (s.isEmpty()) break;
            list.add(s);
        }

        String[] array = list.toArray(new String[0]);
        sort(array);

        for (String x : array) {
            System.out.println(x);
        }
    }

    public static void sort(String[] array) {
        // напишите тут ваш код
        //ArrayList<Integer> numindex = new ArrayList<>();
        //ArrayList<Integer> wordindex = new ArrayList<>();
        ArrayList<Integer> nums = new ArrayList<>();
        ArrayList<String> words = new ArrayList<>();
        for (int i = 0; i <array.length ; i++) {
            if(isNumber(array[i])){
                //numindex.add(i);
                Integer num = Integer.parseInt(array[i]);
                nums.add(num);
            }
            else{
                //wordindex.add(i);
                words.add(array[i]);
            }
        }
        String temp = null;
        for (int i = 0; i < words.size()-1; i++) {
            for (int j = 1; j < words.size(); j++) {
                if (isGreaterThan(words.get(j-1),words.get(j))){
                    Collections.swap(words,j,j-1);
                }
            }

        }
        Collections.sort(nums);
        Collections.reverse(nums);
        for (int i = 0; i < array.length ; i++) {
            if(isNumber(array[i])){
                array[i]=nums.get(0).toString();
                nums.remove(0);
            }else{
                array[i] = words.get(0);
                words.remove(0);
            }
        }
    }

    // Метод для сравнения строк: 'а' больше чем 'b'
    public static boolean isGreaterThan(String a, String b) {
        return a.compareTo(b) > 0;
    }


    // Переданная строка - это число?
    public static boolean isNumber(String s) {
        if (s.length() == 0) return false;

        char[] chars = s.toCharArray();
        for (int i = 0; i < chars.length; i++) {
            char c = chars[i];
            if ((i != 0 && c == '-') // Строка содержит '-'
                    || (!Character.isDigit(c) && c != '-') // или не цифра и не начинается с '-'
                    || (chars.length == 1 && c == '-')) // или одиночный '-'
            {
                return false;
            }
        }
        return true;
    }
}
