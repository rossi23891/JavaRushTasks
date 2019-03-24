package com.javarush.task.task08.task0823;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/* 
Омовение Рамы
*/

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String s = reader.readLine();
        String[] tokens = s.split("\\s+");
        String[] output = new String[tokens.length];
        for (int i = 0; i < tokens.length; i++) {
            output[i] = tokens[i].substring(0,1).toUpperCase()+tokens[i].substring(1);
//            if(tokens[i].length()>1){
//                output[i] = tokens[i].substring(0,1).toUpperCase()+tokens[i].substring(1);
//            } else{
//                output[i] = tokens[i].toUpperCase();
//            }
        }
        for(String d: output){
            System.out.print(d);
            System.out.print(" ");
        }


        //напишите тут ваш код
    }
}
