package com.javarush.task.task19.task1906;

/* 
Четные символы
*/

import java.io.*;

public class Solution {
    public static void main(String[] args) throws IOException {
        String file1;
        String file2;
        try(BufferedReader br = new BufferedReader(new InputStreamReader(System.in))){
            file1 = br.readLine();
            file2 = br.readLine();
        }
        FileReader fileReader = new FileReader(file1);
        FileWriter fileWriter = new FileWriter(file2);
        int index =0;
        while(fileReader.ready()){
            index++;
            int data = fileReader.read();
            if(index%2==0){
                fileWriter.write(data);
            }
        }
            fileReader.close();
            fileWriter.close();
    }
}
