package com.javarush.task.task34.task3403;

import com.fasterxml.jackson.databind.util.ISO8601Utils;

import java.util.ArrayList;
import java.util.List;

/*
Разложение на множители с помощью рекурсии
*/
public class Solution {

    public void recurse(int n) {
        int div = 2;
        if(n<=1){
            return;
        }
        while (div<=n){
            if(n%div==0){
                System.out.print(div + " ");
              if(n==div){
                  return;
              }
             break;
            }
            div++;
        }
        recurse(n/div);
    }

    public static void main(String[] args) {
        new Solution().recurse(132);
    }
}
