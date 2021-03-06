package com.javarush.task.task22.task2203;

/* 
Между табуляциями
*/
public class Solution {

    public static String getPartOfString(String string) throws TooShortStringException {
        if(string==null){
            throw new TooShortStringException();
        }
        int count = 0;
        int startIndex=0;
        int endIndex = 0;
        for (int i = 0; i < string.length(); i++) {
            if(string.charAt(i)==9){
                count++;
                if(count==1){
                    startIndex=i+1;
                }else if(count==2){
                    endIndex=i;
                }
            }
        }
        if(count<2){
            throw new TooShortStringException();
        }
        String result = string.substring(startIndex,endIndex);

        return result;
    }

    public static class TooShortStringException extends Exception {
    }

    public static void main(String[] args) throws TooShortStringException{

        try{
            System.out.println(getPartOfString(""));
        } catch (TooShortStringException e){
            System.out.println("incorrect string");
        }
    }
}
