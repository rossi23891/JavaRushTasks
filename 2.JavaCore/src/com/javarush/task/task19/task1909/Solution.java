package com.javarush.task.task19.task1909;

/* 
Замена знаков
*/

import java.io.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String file1 = br.readLine();
        String file2 = br.readLine();
        br.close();
        String reg = "\\.";
        Pattern pattern = Pattern.compile(reg);
        BufferedReader reader = new BufferedReader(new FileReader(file1));
        BufferedWriter writer = new BufferedWriter(new FileWriter(file2));
        String newData=null;
        while (reader.ready()){
            Matcher matcher = pattern.matcher(reader.readLine());
            while(matcher.find()){
                 newData = matcher.replaceAll("\\!");
            }
            writer.write(newData);
        }
        reader.close();
        writer.close();
    }
}
