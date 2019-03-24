package com.javarush.task.task18.task1805;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.Collections;
import java.util.HashSet;
import java.util.Set;
import java.util.TreeSet;

/* 
Сортировка байт
*/

public class Solution {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        FileInputStream fs= new FileInputStream(br.readLine());
        br.close();
        Set<Integer> bytes = new TreeSet<>();
        while (fs.available()>0){
            int data=fs.read();
            if(!bytes.contains(data)){
                bytes.add(data);
            }
        }
        fs.close();
        for (Integer aByte : bytes) {
            System.out.print(aByte + " ");
        }
    }
}
