package com.javarush.task.task18.task1825;

import java.io.*;
import java.util.*;

/* 
Собираем файл
*/

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String fileName;
        ArrayList<String> fileNames = new ArrayList<>();
        while (!(fileName=br.readLine()).equals("end")){
            fileNames.add(fileName);
        }
        String forParsing = fileNames.get(0);
        String[] parts = forParsing.split(".part");
        String destFile = parts[0];
        FileOutputStream bos = new FileOutputStream(destFile);


        Collections.sort(fileNames);
        for(String name:fileNames){
            BufferedInputStream inputStream = new BufferedInputStream(new FileInputStream(name));
            while (inputStream.available()>0){
                byte[]buffer = new byte[inputStream.available()];
                inputStream.read(buffer);
                bos.write(buffer);
            }
            inputStream.close();
        }
        bos.close();
        br.close();
    }
}
