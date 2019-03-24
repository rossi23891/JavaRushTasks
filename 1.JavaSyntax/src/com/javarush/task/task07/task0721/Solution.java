package com.javarush.task.task07.task0721;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

/* 
Минимаксы в массивах
*/

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        int maximum;
        int minimum;

        //напишите тут ваш код
        int[] arr = new int[20];
        for (int i = 0; i < 20; i++) {
            arr[i]= Integer.parseInt(reader.readLine());
        }
        Arrays.sort(arr);
        maximum = arr[arr.length-1];
        minimum = arr[0];

        System.out.print(maximum + " " + minimum);
    }
}
