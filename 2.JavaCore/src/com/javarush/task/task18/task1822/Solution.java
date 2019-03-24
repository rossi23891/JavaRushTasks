package com.javarush.task.task18.task1822;

/* 
Поиск данных внутри файла
*/

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String file = br.readLine();
        BufferedReader reader = new BufferedReader(new FileReader(file));
        String line;
        int id;
        String idRegex = "\\d+";
        Pattern pattern = Pattern.compile(idRegex);
        while((line=reader.readLine())!=null) {
            Matcher matcher = pattern.matcher(line);
            if (matcher.find()) {
                String group = matcher.group();
                id = Integer.parseInt(group);
                if (id == Integer.parseInt(args[0])) {
                    System.out.println(line);
                }
            }
        }
        br.close();
        reader.close();
    }
}
