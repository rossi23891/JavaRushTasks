package com.javarush.task.task18.task1819;

/* 
Объединение файлов
*/

import java.io.*;

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String file1 = br.readLine();
        String file2 = br.readLine();
        br.close();
        FileInputStream fileInputStream2 = new FileInputStream(file2);
        FileInputStream fileInputStream1 = new FileInputStream(file1);

        byte[] buffer1 =  new byte[fileInputStream1.available()];
        fileInputStream1.read(buffer1);
        fileInputStream1.close();

        byte[] buffer2 = new byte[fileInputStream2.available()];
        fileInputStream2.read(buffer2);
        fileInputStream2.close();

        FileOutputStream fileOutputStream = new FileOutputStream(file1);
        byte[]allBuffer = new byte[buffer1.length+buffer2.length];
        System.arraycopy(buffer2,0,allBuffer,0,buffer2.length);
        System.arraycopy(buffer1,0,allBuffer,buffer2.length,buffer1.length);
        fileOutputStream.write(allBuffer);
        fileOutputStream.close();
    }
}
