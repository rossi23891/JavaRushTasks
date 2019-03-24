package com.javarush.task.task18.task1814;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/* 
UnsupportedFileName
*/

public class TxtInputStream extends FileInputStream {
    String fileName;
    String suffix = ".txt";


    public TxtInputStream(String fileName) throws IOException, UnsupportedFileNameException {
        super(fileName);
        if(!fileName.endsWith(suffix)){
            super.close();
            throw new UnsupportedFileNameException();
        }else{
           return;
        }
    }



    public static void main(String[] args) {
    }
}

