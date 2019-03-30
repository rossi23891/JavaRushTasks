package com.javarush.task.task22.task2202;

/* 
Найти подстроку
*/
public class Solution {
    public static void main(String[] args) {
        try{
            System.out.println(getPartOfString(""));
        }catch (TooShortStringException e){
            System.out.println("too short");
        }
    }

    public static String getPartOfString(String string) throws TooShortStringException{
        if(string==null){
            throw new TooShortStringException();
        }
        int[] spacesIndicies =  new int[4];
        String result = null;
        int count = 0;
        for (int i = 0; i <string.length() ; i++) {
            if (string.charAt(i) == 32 && count < 4) {
                spacesIndicies[count] = i;
                count++;
            }
        }

            if(count>3){
                int finalIndex = spacesIndicies[3];
                int finishIndex = 0;
                if(finalIndex<string.length()-1){
                    for (int i = finalIndex+1; i <string.length() ; i++) {
                        if(string.charAt(i)!=32){
                            finishIndex=i;
                        }else{
                            break;
                        }
                    }
                }
                finishIndex =finishIndex+1;
                result= string.substring((spacesIndicies[0]+1),finishIndex);
            }else{
                throw new TooShortStringException();
            }

        return result;
    }

    public static class TooShortStringException extends RuntimeException{
    }
}
