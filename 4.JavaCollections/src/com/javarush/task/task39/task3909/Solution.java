package com.javarush.task.task39.task3909;

import java.util.Arrays;

/* 
Одно изменение
*/
public class Solution {
    public static void main(String[] args) {
        System.out.println(isOneEditAway("ваперы", "вапер"));
    }

    public static boolean isOneEditAway(String first, String second) {

        if (first == null || second == null)
            return false;

        if (first.length() == 0 && second.length() == 1
                || first.length() == 1 && second.length() == 0
                || first.length() == 0 && second.length() == 0)
            return true;

        char[] one = first.toCharArray();
        char[] two = second.toCharArray();

        int abs = Math.abs(first.length() - second.length());
        if (abs > 1){
            return false;
        }
         else if (abs == 1){

            if(first.length()> second.length()){
                 return checkArrays(two, one);
            }else{
                 return checkArrays(one, two);
            }
        }else {
            int count = 0;
            for (int i = 0; i<one.length; i++ ){
                if(one[i] != two[i]) {
                    count++;
                }
            }
            return count <= 1;

        }
    }

    private static boolean checkArrays(char[] one, char[] two) {
        int dif = 0;
        for (int i = 0, j=0; i < two.length && j<one.length; i++) {
            if(two[i]!=one[j]){
                dif++;
                if (dif>1){
                    return false;
                }
            }else{
                j++;
            }
        }
        return dif==1 || dif==0;
    }

}
