package com.javarush.task.task07.task0714;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

/* 
Слова в обратном порядке
*/

public class Solution {
    public static void main(String[] args) throws Exception {
        //напишите тут ваш код
        Scanner sc = new Scanner(System.in);
        ArrayList<String> str = new ArrayList<>();
        str.add(sc.nextLine());
        str.add(sc.nextLine());
        str.add(sc.nextLine());
        str.add(sc.nextLine());
        str.add(sc.nextLine());
        str.remove(2);
        for (int i = str.size()-1; i >=0; i--) {
            System.out.println(str.get(i));
        }

    }
}


