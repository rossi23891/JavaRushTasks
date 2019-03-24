package com.javarush.task.task18.task1809;

/* 
Реверс файла
*/

import java.io.*;

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String file1 = br.readLine();
        String file2 = br.readLine();
        br.close();
        FileInputStream fis = new FileInputStream(file1);
        FileOutputStream fos = new FileOutputStream(file2);
        byte[]buffer = new byte[fis.available()];
        while(fis.available()>0){
            int count = fis.read(buffer);
            for (int i = 0; i < buffer.length/2 ; i++) {
                byte temp= buffer[i];
                buffer[i]=buffer[buffer.length-i-1];
                buffer[buffer.length-1-i]=temp;
            }
            fos.write(buffer,0,count);
        }
        fis.close();
        fos.close();
    }
}
