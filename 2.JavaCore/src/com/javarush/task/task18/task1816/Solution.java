package com.javarush.task.task18.task1816;

/* 
Английские буквы
*/

import java.io.*;

public class Solution {
    public static void main(String[] args) throws IOException {
        FileInputStream fileInputStream = new FileInputStream(args[0]);
        int count = 0;
        while (fileInputStream.available()>0){
            int data = fileInputStream.read();
            if(((char)data>=65 &&(char)data<=90)||((char)data>=97 &&(char)data<=122)){
                count++;
            }
        }
        fileInputStream.close();
        System.out.println(count);
    }
}
