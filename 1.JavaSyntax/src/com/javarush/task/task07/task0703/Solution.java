package com.javarush.task.task07.task0703;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Scanner;

/* 
Общение одиноких массивов
*/

public class Solution {
    public static void main(String[] args) throws Exception {
        //напишите тут ваш код
        String[]arr =  new String [10];
        int[] arr2 = new int[10];
        Scanner sc = new Scanner(System.in);
        for (int i = 0; i <10 ; i++) {
            arr[i]= sc.nextLine();
        }
        for (int i = 0; i <10 ; i++) {
            arr2[i]= arr[i].length();
        }
        for (int j:arr2){
            System.out.println(j);
        }
    }
}
