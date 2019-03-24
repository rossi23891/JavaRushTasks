package com.javarush.task.task07.task0709;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/* 
Выражаемся покороче
*/

public class Solution {
    public static void main(String[] args) throws Exception {
        //напишите тут ваш код
        ArrayList <String> strings = new ArrayList<>();
        Scanner sc = new Scanner(System.in);
        strings.add(sc.nextLine());
        strings.add(sc.nextLine());
        strings.add(sc.nextLine());
        strings.add(sc.nextLine());
        strings.add(sc.nextLine());
        int minLength = strings.get(0).length();
        for (int i = 1; i < strings.size() ; i++) {
            if(strings.get(i).length()<= minLength){
                minLength = strings.get(i).length();
            }
        }
        for (int i = 0; i < strings.size() ; i++) {
            if(strings.get(i).length()== minLength){
                System.out.println(strings.get(i));
            }
        }

    }
}
