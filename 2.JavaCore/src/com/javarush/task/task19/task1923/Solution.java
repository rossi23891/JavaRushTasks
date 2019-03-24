package com.javarush.task.task19.task1923;

/* 
Слова с цифрами
*/

import java.io.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new FileReader(args[0]));
        BufferedWriter writer = new BufferedWriter(new FileWriter(args[1]));
        String reg = "\\d+";
        Pattern pattern = Pattern.compile(reg);
        while (reader.ready()) {
            String[] words = reader.readLine().split(" ");
            for (String word : words) {
                Matcher matcher = pattern.matcher(word);
                if (matcher.find()) {
                    writer.write(word + " ");
                }
            }
        }
        reader.close();
        writer.close();
    }
}
