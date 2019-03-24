package com.javarush.task.task18.task1801;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;

/* 
Максимальный байт
*/

public class Solution {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        FileInputStream fs= new FileInputStream(br.readLine());
        br.close();
        int maxbyte=0;
        while (fs.available()>0){
            int data=fs.read();
            if(data>maxbyte){
                maxbyte=data;
            }
        }
        fs.close();
        System.out.println(maxbyte);
    }
}
