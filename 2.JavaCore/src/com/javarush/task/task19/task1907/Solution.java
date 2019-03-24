package com.javarush.task.task19.task1907;

/* 
Считаем слово
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
        br.close();
        FileReader fileReader = new FileReader(file);
        int count=0;
        String reg = "\\bworld\\b";
        Pattern pattern = Pattern.compile(reg);
        StringBuilder sb = new StringBuilder();
        int data;
        while ((data=fileReader.read())!=-1){
            sb.append((char)data);
        }
        fileReader.close();
        Matcher matcher = pattern.matcher(sb);
        while (matcher.find()){
            count++;
        }
        System.out.println(count);


    }
}
