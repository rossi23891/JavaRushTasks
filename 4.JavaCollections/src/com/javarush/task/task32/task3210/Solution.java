package com.javarush.task.task32.task3210;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.RandomAccessFile;

/* 
Используем RandomAccessFile
*/

public class Solution {
    public static void main(String... args) throws IOException {
        RandomAccessFile raf = new RandomAccessFile(args[0],"rw");
        int pos =Integer.parseInt(args[1]);
        raf.seek(pos);
        byte [] bytes = new byte[args[2].length()];
        raf.read(bytes, 0,args[2].length());
        String fileText = new String(bytes);
        raf.seek(raf.length());
        if(args[2].equals(fileText)){
            raf.write("true".getBytes());
        }else{
            raf.write("false".getBytes());
        }
    }
}
