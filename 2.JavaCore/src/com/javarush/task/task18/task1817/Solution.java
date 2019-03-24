package com.javarush.task.task18.task1817;

/* 
Пробелы
*/

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

public class Solution {
    public static void main(String[] args) throws IOException {
        FileInputStream fis = new FileInputStream(args[0]);
        int total = fis.available();
        double spaces = 0;
        while (fis.available()>0){
            int data = fis.read();
            if((char)data==' '){
                spaces++;
            }
        }
        fis.close();
        double ratio = (spaces/total)*100;
        System.out.printf("%.2f",ratio);

    }
}
