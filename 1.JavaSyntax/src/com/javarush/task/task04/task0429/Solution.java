package com.javarush.task.task04.task0429;

/* 
Положительные и отрицательные числа
*/

import java.io.*;
import java.util.Scanner;

public class Solution {
    public static void main(String[] args) throws Exception {
        //напишите тут ваш код
        Scanner sc = new Scanner(System.in);
        int a = sc.nextInt();
        int b = sc.nextInt();
        int c = sc.nextInt();
        int countPos = 0;
        int countNeg = 0;
        if(a>0){
            countPos++;
        }else if(a<0){
            countNeg++;
        }
        if(b>0){
            countPos++;
        }else if(b<0){
            countNeg++;
        }
        if(c>0){
            countPos++;
        }else if(c<0){
            countNeg++;
        }
        System.out.println("количество отрицательных чисел: " + countNeg);
        System.out.println("количество положительных чисел: " + countPos);
    }
}
