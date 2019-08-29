package com.javarush.task.task32.task3202;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.StringWriter;

/* 
Читаем из потока
*/
public class Solution {
    public static void main(String[] args) throws IOException {
        StringWriter writer = getAllDataFromInputStream(new FileInputStream("testFile.log"));
        System.out.println(writer.toString());
    }

    public static StringWriter getAllDataFromInputStream(InputStream is) throws IOException {

        StringWriter stringWriter = null;
        try {
            stringWriter = new StringWriter();
            String test;
            byte[] bytes = new byte[is.available()];
            is.read(bytes, 0, is.available());
            test = new String(bytes);

            stringWriter.write(test);
        } catch (NullPointerException e) {
        }

        return stringWriter;
    }
}