package com.javarush.task.task19.task1925;

/* 
Длинные слова
*/

import java.io.*;
import java.util.ArrayList;

public class Solution {
    public static void main(String[] args) throws IOException {
        ArrayList<String> wds = new ArrayList<>();
        try (BufferedReader reader = new BufferedReader(new FileReader(args[0]))) {
            String line;

            while ((line=reader.readLine())!=null) {
                String[] words = line.split(" ");
                for (String word : words) {
                    if (word.length() > 6) {
                        wds.add(word);
                    }
                }
            }
        }
        try (FileWriter writer = new FileWriter(args[1])) {
            for (int i = 0; i <=wds.size()-2 ; i++) {
                writer.write(wds.get(i)+",");
            }
            writer.write(wds.get(wds.size()-1));
        }
    }
}
