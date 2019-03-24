package com.javarush.task.task14.task1419;

import java.io.File;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/* 
Нашествие исключений
*/

public class Solution {
    public static List<Exception> exceptions = new ArrayList<Exception>();
    public static int doSmth(int a){
        int b= a*3;
        if(b>18){
            try {
                throw new MyException();
            } catch (MyException e) {
                exceptions.add(e);;
            }
        }
        return b;
    }


    public static void main(String[] args) throws Exception {
        initExceptions();

        for (Exception exception : exceptions) {
            System.out.println(exception);
        }
    }


    private static void initExceptions() throws Exception {   //the first exception
        try {
            float i = 1 / 0;

        } catch (Exception e) {
            exceptions.add(e);
        }
        int[] test = new int[5];
        String word = null;
        try{
            int a = test[8];
        }catch (Exception e){
            exceptions.add(e);
        }
        try{
            word = "art";
            String word1 = word.substring(1,10);
        }catch (Exception e){
            exceptions.add(e);
        }
        try{
            word.toUpperCase();
        }catch (Exception e){
            exceptions.add(e);
        }
        word = "56ssss";
        try{
            Integer.parseInt(word);
        } catch (Exception e){
            exceptions.add(e);
        }

        try{
            int[] test1 = new int[-3];
            for (int i : test1) {
                System.out.println(test1[i]);
            }
        } catch (Exception e){
            exceptions.add(e);
        }
        try{
            Object o = Integer.valueOf(6);
            String s = (String)o;
        } catch (Exception e){
            exceptions.add(e);
        }
        Scanner sc = new Scanner("New 2.0 is coming");
        try{
            sc.next();
            sc.next();
            sc.next();
            sc.next();
            sc.next();
            sc.next();
            sc.next();
        } catch (Exception e){
            exceptions.add(e);
        }
        List<String> list = new ArrayList<>();
        list.add("new");
        list.add("styu");
        try{
            String a = list.get(3);
        }catch (Exception e){
            exceptions.add(e);
        }
        try{
            File file = new File("D://file.txt");
            FileReader fr = new FileReader(file);
        }catch (Exception e){
            exceptions.add(e);
        }
        try{
            Solution.doSmth(10);
        } catch (Exception e){
            exceptions.add(e);
        }






        //напишите тут ваш код

    }

      static class MyException extends Exception {
        public MyException(){

        }
         public MyException(String message){
            super(message);
         }
    }
}
