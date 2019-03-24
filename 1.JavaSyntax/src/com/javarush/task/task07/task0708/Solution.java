package com.javarush.task.task07.task0708;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/* 
Самая длинная строка
*/

public class Solution {
    private static List<String> strings = new ArrayList<>() ;

    public static void main(String[] args) throws Exception {
        //напишите тут ваш код
        Scanner sc = new Scanner(System.in);
        strings.add(sc.nextLine());
        strings.add(sc.nextLine());
        strings.add(sc.nextLine());
        strings.add(sc.nextLine());
        strings.add(sc.nextLine());
        int maxLength = 0;
        for (int i = 0; i < strings.size() ; i++) {
            if(strings.get(i).length()>maxLength){
                maxLength = strings.get(i).length();
            }
        }
        for (int i = 0; i < strings.size() ; i++) {
            if(strings.get(i).length()==maxLength){
                System.out.println(strings.get(i));
            }
        }

    }
}
