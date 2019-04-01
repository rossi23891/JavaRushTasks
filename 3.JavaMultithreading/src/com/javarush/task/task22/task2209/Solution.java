package com.javarush.task.task22.task2209;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

/*
Составить цепочку слов
*/
public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        String fileName = bufferedReader.readLine();
        BufferedReader fileReader = new BufferedReader(new FileReader(fileName));
        StringBuilder sb = new StringBuilder();
        while (fileReader.ready()){
            sb.append(fileReader.readLine()).append(" ");
        }
        bufferedReader.close();
        fileReader.close();
        String[]words = sb.toString().split(" ");
        //...
        StringBuilder result = getLine(words);
        System.out.println(result.toString());
    }

    public static StringBuilder getLine(String...words) {
        if(words.length==0){
            return new StringBuilder();
        }else if(words.length==1){
            return new StringBuilder(words[0]);
        }
        ArrayList<String> temp = new ArrayList<>(Arrays.asList(words));
        Collections.sort(temp);
        ArrayList<String> result = new ArrayList<>();
        for (int i = 0; i <temp.size()-1 ; i++) {
            for (int j = i+1; j <temp.size() ; j++) {
                char wd = temp.get(i).toLowerCase().charAt(temp.get(i).length()-1);
                char wd1 = temp.get(j).toLowerCase().charAt(0);
                if(wd== wd1){
                    result.add(temp.get(i));
                    result.add(temp.get(j));
                    temp.remove(j);
                    temp.remove(i);
                    j=temp.size();
                    i=temp.size();
                }
            }
        }
        for (int i = 0; i <temp.size() ;) {
            char wd = result.get(result.size()-1).toLowerCase().charAt(result.get(result.size()-1).length()-1);
            char wd1 = temp.get(i).toLowerCase().charAt(0);
            char wd2 =result.get(0).toLowerCase().charAt(0);
            char wd3 = temp.get(i).toLowerCase().charAt(temp.get(i).length()-1);
            if(wd==wd1){
                result.add(temp.get(i));
                temp.remove(i);
                i=0;
            }else if(wd2==wd3){
                result.add(0,temp.get(i));
                temp.remove(i);
                i=0;
            }
            else{
                i++;
            }
        }
        for (String s : temp) {
            result.add(s);
        }
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i <result.size()-1; i++) {
            sb.append(result.get(i)).append(" ");
        }
        sb.append(result.get(result.size()-1));
        return sb;
    }


}
