package com.javarush.task.task18.task1824;

/* 
Файлы и исключения
*/

import java.io.*;

public class Solution {
    public static void main(String[] args) throws IOException {
        try(BufferedReader br = new BufferedReader(new InputStreamReader(System.in))){
            String fileName;
            while((fileName=br.readLine())!=null){
                try{
                    try(FileInputStream fileInputStream = new FileInputStream(fileName)){

                    }
                }catch (FileNotFoundException e){
                    System.out.println(fileName);
                }
            }
        }

    }
}
