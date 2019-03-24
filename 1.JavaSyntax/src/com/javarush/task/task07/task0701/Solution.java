package com.javarush.task.task07.task0701;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Scanner;

/* 
Массивный максимум
*/

public class Solution {
    public static void main(String[] args) throws Exception {
        int[] array = initializeArray();
        int max = max(array);
        System.out.println(max);
    }

    public static int[] initializeArray() throws IOException {
        // создай и заполни массив
        Scanner sc = new Scanner(System.in);
        int[] arr = new int[20];
        for (int i = 0; i < 20; i++) {
            arr[i]= sc.nextInt();
        }
        return arr;
    }

    public static int max(int[] array) {
        // найди максимальное значение
        Arrays.sort(array);
        int max = array[array.length-1];
        return max;
    }
}
