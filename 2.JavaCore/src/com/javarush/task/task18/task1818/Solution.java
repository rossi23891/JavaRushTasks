package com.javarush.task.task18.task1818;

/* 
Два в одном
*/

import java.io.*;

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String file1 = br.readLine();
        String file2 = br.readLine();
        String file3 = br.readLine();
        FileInputStream fileInputStream = new FileInputStream(file2);
        FileOutputStream fileOutputStream = new FileOutputStream(file1, true);
        while (fileInputStream.available() > 0) {
            int data = fileInputStream.read();
            fileOutputStream.write(data);
        }
        FileInputStream fileInputStream2 = new FileInputStream(file3);
        while (fileInputStream2.available() > 0) {
            int data = fileInputStream2.read();
            fileOutputStream.write(data);
        }
        fileInputStream.close();
        fileInputStream2.close();
        fileOutputStream.close();

    }
}
