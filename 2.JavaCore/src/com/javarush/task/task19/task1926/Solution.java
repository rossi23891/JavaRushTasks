package com.javarush.task.task19.task1926;

/* 
Перевертыши
*/

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String FileName = br.readLine();
        br.close();
        BufferedReader reader = new BufferedReader( new FileReader(FileName));

        String line;
        while (reader.ready()){
            StringBuilder sb = new StringBuilder();
            line = reader.readLine();
            sb.append(line);
            String rev = sb.reverse().toString();
            System.out.println(rev);
        }
        reader.close();

    }
}
