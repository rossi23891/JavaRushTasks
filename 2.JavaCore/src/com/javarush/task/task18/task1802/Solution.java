package com.javarush.task.task18.task1802;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;

/* 
Минимальный байт
*/

public class Solution {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        FileInputStream fs= new FileInputStream(br.readLine());
        br.close();
        int minbyte=128;
        while (fs.available()>0){
            int data=fs.read();
            if(data<minbyte){
                minbyte=data;
            }
        }
        fs.close();
        System.out.println(minbyte);
    }
}
