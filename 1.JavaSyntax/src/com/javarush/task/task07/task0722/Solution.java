package com.javarush.task.task07.task0722;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

/* 
Это конец
*/

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        //напишите тут ваш код
        ArrayList<String> tillEnd = new ArrayList<>();
        String end = "end";
        while (true){
            String s = reader.readLine();
            if(!s.equals(end)){
                tillEnd.add(s);
            }else{
                break;
            }
        }
        for(String s: tillEnd){
            System.out.println(s);
        }
    }
}