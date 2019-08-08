package com.javarush.task.task30.task3010;

/* 
Минимальное допустимое основание системы счисления
*/

import java.math.BigInteger;

public class Solution {
    public static void main(String[] args) {
        //напишите тут ваш код
        String s=null;
        try{
            s = args[0];
        }catch (Exception e){

        }
        System.out.println(findMinimalCountingSystem(s));
    }

    public static String findMinimalCountingSystem(String s){
        int minCountingSystem=0;
            for (int i = 2; i <=36 ; i++) {
                try{
                    BigInteger bigInteger=new BigInteger(s,i);
                    minCountingSystem=i;
                    return String.valueOf(minCountingSystem);
                }catch (Exception e){
                }
            }

            return "incorrect";
    }
}