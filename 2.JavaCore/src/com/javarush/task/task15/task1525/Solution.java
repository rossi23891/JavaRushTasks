package com.javarush.task.task15.task1525;

import javax.imageio.stream.FileImageInputStream;
import java.io.*;
import java.util.ArrayList;
import java.util.List;

/* 
Файл в статическом блоке
*/

public class Solution {
    public static List<String> lines = new ArrayList<String>();
    static{
        try{
            BufferedReader br = new BufferedReader(new FileReader(Statics.FILE_NAME));
            String line;
            while((line=br.readLine())!=null){
                lines.add(line);
            }
        }catch (IOException e){
            e.printStackTrace();
        }
    }


    public static void main(String[] args) {
        System.out.println(lines);
    }
}
