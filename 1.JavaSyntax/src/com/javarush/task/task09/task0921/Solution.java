package com.javarush.task.task09.task0921;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/* 
Метод в try..catch
*/

public class Solution {
    public static void main(String[] args){
        readData();
    }

    public static void readData() {
        //напишите тут ваш код
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        ArrayList<Integer> list = new ArrayList<>();
        while (true) {
            try {
                String s = br.readLine();
                Integer s1 = Integer.parseInt(s);
                list.add(s1);
            } catch (NumberFormatException e) {
                for (Integer integer : list) {
                    System.out.println(integer);
                }
                break;

            } catch (IOException e) {
                e.printStackTrace();
            }

        }
    }
}
