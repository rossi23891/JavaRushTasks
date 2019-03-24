package com.javarush.task.task07.task0717;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Scanner;

/* 
Удваиваем слова
*/

public class Solution {
    public static void main(String[] args) throws Exception {
        // Считать строки с консоли и объявить ArrayList list тут
        ArrayList<String> begin = new ArrayList<>();
        Scanner sc = new Scanner(System.in);
        for (int i = 0; i <10 ; i++) {
            begin.add(sc.nextLine());
        }

        ArrayList<String> result = doubleValues(begin);

        // Вывести на экран result
        for(String s : result){
            System.out.println(s);
        }
    }

    public static ArrayList<String> doubleValues(ArrayList<String> list) {
        //напишите тут ваш код
        int n = list.size();
        for (int i = 0; i < n*2 ; i+=2) {
           list.add(i+1,list.get(i));
        }
        return list;
    }
}
