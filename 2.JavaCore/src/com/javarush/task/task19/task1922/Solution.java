package com.javarush.task.task19.task1922;


import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;


/* 
Ищем нужные строки
*/

public class Solution {
    public static List<String> words = new ArrayList<String>();

    static {
        words.add("файл");
        words.add("вид");
        words.add("В");
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String file = br.readLine();
        br.close();
        BufferedReader reader = new BufferedReader(new FileReader(file));
            String line=null;
            while(reader.ready()){
                int count = 0;
                line = reader.readLine();
                String[]lineWords = line.split(" ");
                for (String lineWord : lineWords) {
                    if(words.contains(lineWord)){
                        count++;
                    }
                }
                if(count==2){
                    System.out.println(line);
                }
            }
            reader.close();
    }

}
