package com.javarush.task.task18.task1804;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;

/* 
Самые редкие байты
*/

public class Solution {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        FileInputStream fs= new FileInputStream(br.readLine());
        br.close();
        ArrayList<Integer> bytesList = new ArrayList<>();
        ArrayList<Integer> output = new ArrayList<>();
        while(fs.available()>0){
            int data = fs.read();
            bytesList.add(data);
        }
        fs.close();
        int least = Collections.frequency(bytesList,bytesList.get(0));
        int rare = bytesList.get(0);
        for (int i = 1; i < bytesList.size(); i++) {
            int tempFreq=Collections.frequency(bytesList,bytesList.get(i));
            if(tempFreq<=least){
                least =tempFreq;
            }
        }
        for (int i = 0; i < bytesList.size(); i++) {
            if(Collections.frequency(bytesList,bytesList.get(i))==least &&!output.contains(bytesList.get(i))){
                output.add(bytesList.get(i));
            }
        }

        for (Integer integer : output) {
            System.out.print(integer + " ");
        }
    }
}
