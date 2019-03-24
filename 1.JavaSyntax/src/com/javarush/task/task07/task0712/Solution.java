package com.javarush.task.task07.task0712;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Scanner;

/* 
Самые-самые
*/

public class Solution {
    public static void main(String[] args) throws Exception {
        //напишите тут ваш код
        ArrayList<String> strings = new ArrayList<>();
        Scanner sc = new Scanner(System.in);
        for (int i = 0; i < 10; i++) {
            strings.add(sc.nextLine());
        }
        int minLength = strings.get(0).length();
        int maxLength = strings.get(0).length();
        int maxIndex = 0;
        int minIndex = 0;
        for (int i = 1; i < strings.size() ; i++) {
            if(strings.get(i).length()< minLength){
                minLength = strings.get(i).length();
                minIndex=i;
            }
            if(strings.get(i).length()>maxLength){
                maxLength = strings.get(i).length();
                maxIndex=i;
            }
        }
        if(maxIndex>minIndex){
            System.out.println(strings.get(minIndex));
        } else{
            System.out.println(strings.get(maxIndex));
        }

    }
}
