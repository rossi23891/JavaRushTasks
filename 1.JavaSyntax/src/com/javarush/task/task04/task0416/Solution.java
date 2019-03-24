package com.javarush.task.task04.task0416;

/* 
Переходим дорогу вслепую
*/

import javax.xml.bind.SchemaOutputResolver;
import java.io.*;
import java.util.Scanner;
public class Solution {
    public static void main(String[] args) throws Exception {
        //напишите тут ваш код
       Scanner sc = new Scanner (System.in);
       double d = sc.nextDouble();
       int time = (int)d+1;
       if (time%5==0){
           System.out.println("красный");
       } else if(time%5==4){
           System.out.println("желтый");
       } else{
           System.out.println("зеленый");
       }
    }
}