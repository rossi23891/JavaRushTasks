package com.javarush.task.task04.task0432;



/* 
Хорошего много не бывает
*/

import java.io.*;

public class Solution {
    public static void main(String[] args) throws Exception {
        //напишите тут ваш код
        BufferedReader bd = new BufferedReader(new InputStreamReader(System.in));
        String n1 = bd.readLine();
        int N = Integer.parseInt(bd.readLine());

        while(N>0) {
            System.out.println(n1);
            N--;
        }
    }
}
