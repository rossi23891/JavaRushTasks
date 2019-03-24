package com.javarush.task.task07.task0720;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

/* 
Перестановочка подоспела
*/

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        //напишите тут ваш код
        int N = Integer.parseInt(reader.readLine());
        int M = Integer.parseInt(reader.readLine());
        ArrayList <String> exp = new ArrayList<>();
        for (int i = 0; i < N; i++) {
            exp.add(reader.readLine());
        }
        int count = 1;
            while(count<=M){
                exp.add(exp.get(0));
                exp.remove(0);
                count++;
            }


            for (String s:exp) {
                System.out.println(s);
            }

    }
}
