package com.javarush.task.task19.task1924;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/* 
Замена чисел
*/

public class Solution {
    public static Map<Integer, String> map = new HashMap<Integer, String>();

    static {
        map.put(0, "ноль");
        map.put(1, "один");
        map.put(2, "два");
        map.put(3, "три");
        map.put(4, "четыре");
        map.put(5, "пять");
        map.put(6, "шесть");
        map.put(7, "семь");
        map.put(8, "восемь");
        map.put(9, "девять");
        map.put(10, "десять");
        map.put(11, "одиннадцать");
        map.put(12, "двенадцать");
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String file = br.readLine();
        br.close();
        try (BufferedReader reader = new BufferedReader(new FileReader(file))) {
            String line;
            String reg = "\\d+";
            Pattern pattern = Pattern.compile(reg);
            while (reader.ready()) {
                line = reader.readLine();
                //String[] words = line.split(" ");
                //for (String word : words) {
                    Matcher matcher = pattern.matcher(line);
                    while (matcher.find()) {
                        String num = matcher.group(0);
                        if (map.containsKey(Integer.parseInt(num))) {
                            line = line.replaceAll("\\b" + num + "\\b", map.get(Integer.parseInt(num)));
                        }

                    }

                //}
                System.out.println(line);
            }
        }
    }
}

