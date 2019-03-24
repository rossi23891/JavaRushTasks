package com.javarush.task.task04.task0433;


/* 
Гадание на долларовый счет
*/

import java.io.*;

public class Solution {
    public static void main(String[] args) throws Exception {
        //напишите тут ваш код
        int line = 10;
        int width = 10;
        char s = 'S';
        while(line>0){
            while(width>0){
                System.out.print(s);
                width--;
            }
            line--;
            System.out.println();
        }

    }
}
