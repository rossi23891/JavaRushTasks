package com.javarush.task.task07.task0704;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Scanner;

/* 
Переверни массив
*/

public class Solution {
    public static void main(String[] args) throws Exception {
        int[]arr =  new int[10];
        Scanner sc = new Scanner(System.in);
        for (int i = 0; i <10 ; i++) {
            arr[i]= sc.nextInt();
        }
        for(int j = arr.length - 1;j>=0;j--){
            System.out.println(arr[j]);
        }
        //напишите тут ваш код
    }
}

