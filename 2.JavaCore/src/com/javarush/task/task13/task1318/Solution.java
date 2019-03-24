package com.javarush.task.task13.task1318;

import java.io.*;
import java.util.Scanner;

/* 
Чтение файла
*/

public class Solution {
    public static void main(String[] args) throws IOException {
        // напишите тут ваш код
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String fileName = br.readLine();
        InputStream inputstream = new FileInputStream(fileName);
        while(inputstream.available()>0){
            char data = (char)inputstream.read();
            System.out.print(data);
        }
        inputstream.close();
        br.close();
    }
}