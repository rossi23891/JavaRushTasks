package com.javarush.task.task20.task2025;

import java.util.ArrayList;
import java.util.List;

/*
Алгоритмы-числа
*/
public class Solution {
    public static long[] getNumbers(long N) {
        long[] result = null;
        int numberOfDigits;
        ArrayList<Integer> sets = new ArrayList<>();
        for (int i = 0; i <N; i++) {
            int tempRes;
            numberOfDigits = (int)Math.log10(i);
           while (i>0){
               tempRes=i%10;
               sets.add(tempRes);
               i=i/10;
           }
        }
        return result;
    }



    public static void main(String[] args) {

    }
}
