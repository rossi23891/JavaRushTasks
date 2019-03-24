package com.javarush.task.task07.task0705;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Scanner;

/* 
Один большой массив и два маленьких
*/

public class Solution {
    public static void main(String[] args) throws Exception {
        //напишите тут ваш код
        Scanner sc = new Scanner(System.in);
        int[] arr = new int[20];
        for (int i = 0; i < 20; i++) {
            arr[i]= sc.nextInt();
        }
        int[]arr1 = new int[10];
        int[]arr2 = new int[10];
        System.arraycopy(arr,0,arr1,0,10);
        System.arraycopy(arr,10,arr2,0,10);
        for (int j:arr2){
            System.out.println(j);
        }
    }
}
