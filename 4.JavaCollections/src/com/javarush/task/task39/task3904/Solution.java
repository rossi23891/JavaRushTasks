package com.javarush.task.task39.task3904;

/* 
Лестница
*/
public class Solution {
    private static int n = 70;

    public static void main(String[] args) {
        System.out.println("The number of possible ascents for " + n + " steps is: " + numberOfPossibleAscents(n));
    }

    public static long numberOfPossibleAscents(int n) {
        if(n<0){
            return 0;
        }else if(n==0){
            return 1;
        } else{
            long[] array = new long[n+1];
            array[0] = 1;
            array[1] = 2;
            array[2] = 4;
            for(int i=3;i<=n;i++){
                array[i] = array[i-1] + array[i-2] + array[i-3];
            }
            return array[n-1];
        }

    }
}

