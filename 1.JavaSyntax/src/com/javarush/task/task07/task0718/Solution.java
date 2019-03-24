package com.javarush.task.task07.task0718;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Scanner;

/* 
Проверка на упорядоченность
*/
public class Solution {
    public static void main(String[] args) throws IOException {
        //напишите тут ваш код
        ArrayList<String> begin = new ArrayList<>();
        Scanner sc = new Scanner(System.in);
        for (int i = 0; i <10 ; i++) {
            begin.add(sc.nextLine());
        }
        for (int i = 0; i < begin.size()-1 ;) {
            if(begin.get(i).length()<= begin.get(i+1).length()){
                i++;
            } else{
                System.out.println(i+1);
                break;
            }
        }
    }
}

