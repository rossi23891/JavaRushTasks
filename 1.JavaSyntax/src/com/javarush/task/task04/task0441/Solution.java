package com.javarush.task.task04.task0441;


/* 
Как-то средненько
*/
import java.io.*;
import java.util.Scanner;

public class Solution {
    public static void main(String[] args) throws Exception {
        Scanner sc = new Scanner(System.in);
        int a = sc.nextInt();
        int b = sc.nextInt();
        int c = sc.nextInt();
        int avg = 0;
        if((a<=b && b<=c) || (c<=b && b<=a)){
            avg =b;
        } else if((a>=b && a<=c) || (a<=b && c<=a)){
            avg=a;
        }else{
            avg = c;
        }
        System.out.println(avg);

    }
}
