package com.javarush.task.task14.task1420;

/* 
НОД
*/

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Solution {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

            int a = Integer.parseInt(br.readLine());
            int b = Integer.parseInt(br.readLine());
        System.out.println(GCD(a,b));


        /*} catch (NumberFormatException e){
            System.out.println("Please, enter another number");
        }
        catch (PositiveNumberException e){
            e.getMessage();
        }

    }
    public static void testMyException (int a,int b) throws PositiveNumberException {
        if(a<=0 || b<=0){
            throw new PositiveNumberException("Please, enter number above 0");
        }
    }
    static class PositiveNumberException extends Exception{
        public PositiveNumberException(){

        }public PositiveNumberException(String message){
            super(message);
        }*/

    }
    public static int GCD(int a,int b){
        int max = Math.max(a,b);
        int min = Math.min(a,b);
        while(min>0){
            int mod = max%min;
             if(mod!=0){
                 max = min;
                 min=mod;
             }
        }
        return min;
    }
}
