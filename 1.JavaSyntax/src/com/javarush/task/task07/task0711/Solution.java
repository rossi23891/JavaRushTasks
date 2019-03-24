package com.javarush.task.task07.task0711;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/* 
Удалить и вставить
*/

public class Solution {
    public static void main(String[] args) throws Exception {
        //напишите тут ваш код
        ArrayList<String> strings = new ArrayList<>();
        Scanner sc = new Scanner(System.in);
        strings.add(sc.nextLine());
        strings.add(sc.nextLine());
        strings.add(sc.nextLine());
        strings.add(sc.nextLine());
        strings.add(sc.nextLine());
        for (int i = 0; i <13 ; i++) {
            String a = strings.get(strings.size()-1);
            strings.remove(strings.size()-1);
            strings.add(0,a);
        }
        for(String j:strings){
            System.out.println(j);
        }
    }
}
