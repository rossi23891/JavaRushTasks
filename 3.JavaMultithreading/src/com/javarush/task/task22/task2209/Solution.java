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
        String[] toSB=null;
        if(words.length==0){
            return new StringBuilder();
        }
        if(words.length==1){
            return new StringBuilder(words[0]);
        }
        for (int i = 0; i <words.length ; i++) {
            String w = words[i];
            String[]result = findChainForHeadAndTail(w,dropElementWithIndex(i,words));
            if(result.length == words.length-1){
                toSB = concateArray(w,result);
            }
        }
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < toSB.length ; i++) {
            sb.append(toSB[i]).append(" ");
        }
        return  sb;
    }

    private static String[] findChainForHeadAndTail(String head,String[]tail){
        if(tail.length==0){
            return new String[0];
        }
        if(tail.length==1){
            if(tail[0].toLowerCase().charAt(0)== head.toLowerCase().charAt(head.length()-1)){
                return tail;
            }else{
                return new String[0];
            }
        }
        for (int i = 0; i <tail.length ; i++) {
            String wd = tail[i];
            if(wd.toLowerCase().charAt(0)== head.toLowerCase().charAt(head.length()-1)){
                String[]result = findChainForHeadAndTail(wd,dropElementWithIndex(i,tail));
                if(result.length == tail.length-1){
                    return concateArray(wd,result);
                }
            }
        }
       return  new String[0];
    }

    private static String[] dropElementWithIndex(int i,String[]words){// функция создает массив размера на 1 меньше изначального, из него удалено нужное слово
        List<String> updated = new ArrayList<>();
        for (int j = 0; j <words.length ; j++) {
            if(j!=i){
                updated.add(words[j]);
            }
        }
        return updated.toArray(new String[words.length-1]);
    }

    private static String[] concateArray(String head,String[]tail){// собираем большой массив обратно
        List<String> concated = new ArrayList<>();
        for (String s : tail) {
            concated.add(s);
        }
        concated.add(0,head);
        return concated.toArray(new String[tail.length+1]);
    }

}
