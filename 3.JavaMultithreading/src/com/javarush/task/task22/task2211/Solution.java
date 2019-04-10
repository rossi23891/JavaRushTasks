package com.javarush.task.task22.task2211;

import java.io.*;
import java.nio.charset.Charset;

/* 
Смена кодировки
*/
public class Solution {
    public static void main(String[] args) throws IOException {
        Charset windows1251 = Charset.forName("Windows-1251");
        Charset utf8 = Charset.forName("UTF-8");
        InputStream inputStream = new FileInputStream(args[0]);
        byte[]buffer = new byte[inputStream.available()];
        while (inputStream.available()>0){
            inputStream.read(buffer);
        }
        inputStream.close();
        String data = new String(buffer,windows1251);
        buffer = data.getBytes(utf8);
        OutputStream outputStream = new FileOutputStream(args[1]);
        outputStream.write(buffer);
        outputStream.close();
    }
}
