package com.javarush.task.task39.task3910;

import com.fasterxml.jackson.databind.util.ISO8601Utils;

/*
isPowerOfThree
*/
public class Solution {
    public static void main(String[] args) {
        System.out.println(isPowerOfThree(0));
    }

    public static boolean isPowerOfThree(int n) {
        if (n < 1)
        {
            return false;
        }
        if (n == 1)
        {
            return true;
        }
        double c = n;
        while(true){
            c /=3;
            if(c<2){break;}
        }
        return c==1;
    }
}
