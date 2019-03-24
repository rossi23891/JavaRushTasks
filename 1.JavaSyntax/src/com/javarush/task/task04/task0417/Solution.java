package com.javarush.task.task04.task0417;

/* 
Существует ли пара?
*/

import java.io.*;
import java.util.Scanner;

public class Solution {
    public static void main(String[] args) throws Exception {
        //напишите тут ваш код
        Scanner sc = new Scanner (System.in);
        int a = sc.nextInt();
        int b = sc.nextInt();
        int c = sc.nextInt();
        if(a==b && a==c){
            System.out.println(a + " " + b + " " + c);
        } else if (a==b && b!=c){
            System.out.println(a+" "+b);
        } else if (a==c && b!=c){
            System.out.println(a+" "+c);
        }else if (c==b && a!=c){
            System.out.println(b+" "+c);
        }
    }
}