package com.javarush.task.task18.task1820;

/* 
Округление чисел
*/

import java.io.*;

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String file1 = br.readLine();
        String file2 = br.readLine();
        br.close();
        BufferedReader reader = new BufferedReader(new FileReader(file1));
        BufferedWriter writer = new BufferedWriter(new FileWriter(file2));
        String line;
        while((line=reader.readLine())!=null){
            String[]doubles = line.split(" ");
            for (String aDouble : doubles) {
                int newInt = (int) Math.round(Double.parseDouble(aDouble));
                writer.write(newInt + " ");
            }
        }
        reader.close();
        writer.close();

    }
}
