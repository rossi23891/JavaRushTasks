package com.javarush.task.task04.task0424;

/* 
Три числа
*/

import java.io.*;
import java.util.Scanner;

public class Solution {
    public static void main(String[] args) throws Exception {
        //напишите тут ваш код
        Scanner sc = new Scanner(System.in);
        int a =  sc.nextInt();
        int b =  sc.nextInt();
        int c =  sc.nextInt();
        if(a==b && b!=c){
            System.out.println("3");
        }
        if (a==c && b!=c){
            System.out.println("2");
        }
        if (b==c && a!=b){
            System.out.println("1");
        }
    }
}
