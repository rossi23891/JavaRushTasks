package com.javarush.task.task15.task1527;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/* 
Парсер реквестов
*/

public class Solution {
    public static void main(String[] args) throws IOException {
        //add your code here
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String URL = br.readLine();
        int qIndex = URL.indexOf("?");
        String URLsubstring = URL.substring(qIndex+1);
        String[] parameters = URLsubstring.split("(&)|(=)");
        for (String parameter : parameters) {
            System.out.println(parameter);
        }
        for (String parameter : parameters) {
            try{
                double d =Double.parseDouble(parameter);
                alert(d);
            }catch (NumberFormatException e){
                alert(parameter);
            }
        }

    }

    public static void alert(double value) {
        System.out.println("double: " + value);
    }

    public static void alert(String value) {
        System.out.println("String: " + value);
    }
}
