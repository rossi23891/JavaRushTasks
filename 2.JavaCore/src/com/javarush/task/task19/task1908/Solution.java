package com.javarush.task.task19.task1908;

/* 
Выделяем числа
*/

import java.io.*;

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String file1 = br.readLine();
        String file2 = br.readLine();
        br.close();
        BufferedReader reader = new BufferedReader(new FileReader(file1));
        BufferedWriter writer = new BufferedWriter(new FileWriter(file2));
        while (reader.ready()){
            String[] tokens = reader.readLine().split(" ");
            for (String token : tokens) {
                try{
                   int a = Integer.parseInt(token);
                   writer.write(String.valueOf(a)+" ");
                }catch (NumberFormatException e){

                }
            }
        }
        reader.close();
        writer.close();
    }
}
