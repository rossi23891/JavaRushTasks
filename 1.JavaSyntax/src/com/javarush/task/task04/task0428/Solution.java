package com.javarush.task.task04.task0428;

/* 
Положительное число
*/

import javax.xml.bind.SchemaOutputResolver;
import java.io.*;
import java.util.Scanner;

public class Solution {
    public static void main(String[] args) throws Exception {
        //напишите тут ваш код
        Scanner sc = new Scanner(System.in);
        int a = sc.nextInt();
        int b = sc.nextInt();
        int c = sc.nextInt();
        int count = 0;
        if(a>0){
            count++;
        }
        if(b>0){
            count++;
        }
        if(c>0){
            count++;
        }
        System.out.println(count);
    }
}
