package com.javarush.task.task37.task3714;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;

/* 
Древний Рим
*/
public class Solution {
    public static Map<Character,Integer> vals;
    static {
        vals = new HashMap<>();
        vals.put('I',1);
        vals.put('V',5);
        vals.put('X',10);
        vals.put('L',50);
        vals.put('C',100);
        vals.put('D',500);
        vals.put('M',1000);
    }

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        System.out.println("Input a roman number to be converted to decimal: ");
        String romanString = bufferedReader.readLine();
        System.out.println("Conversion result equals " + romanToInteger(romanString));
    }

    public static int romanToInteger(String s) {
        int total = 0;
        char[] nums = s.toCharArray();
        total+=vals.get(nums[0]);
        if(s.length()>1){
            for (int i = 1; i <= nums.length-1; i++) {
                if(vals.get(nums[i])>vals.get(nums[i-1])){
                    total-=vals.get(nums[i-1]);
                    total-=vals.get(nums[i-1]);
                    total+=vals.get(nums[i]);
                }else{
                    total+=vals.get(nums[i]);
                }
            }
        }

        return total;
    }


}
