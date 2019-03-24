package com.javarush.task.task18.task1826;

/* 
Шифровка
*/

import java.io.*;

public class Solution {
    public static void main(String[] args) throws IOException {
        String fileName = args[1];
        String fileOutputName = args[2];
        FileInputStream fis = new FileInputStream(fileName);
        FileOutputStream fos = new FileOutputStream(fileOutputName);
        if(args[0].equals("-e")){
            while(fis.available()>0){
                int data = fis.read();
                fos.write(data+1);
            }
        }
        else if(args[0].equals("-d")){
            while(fis.available()>0){
                int data = fis.read();
                fos.write(data-1);
            }
        }
        fis.close();
        fos.close();
    }

}
