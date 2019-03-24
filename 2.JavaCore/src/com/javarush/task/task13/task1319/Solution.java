package com.javarush.task.task13.task1319;

import java.io.*;
import java.util.ArrayList;

/* 
Писатель в файл с консоли
*/

public class Solution {
    public static void main(String[] args) throws IOException {
        // напишите тут ваш код
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String fileName = br.readLine();
        BufferedWriter bw = new BufferedWriter(new FileWriter(fileName));
        String line;
        while (true){
            line = br.readLine();
            bw.write(String.format("%s\n", line));
            if(line.equals("exit")){
                break;
            }
        }
        br.close();
        bw.close();
    }
}
