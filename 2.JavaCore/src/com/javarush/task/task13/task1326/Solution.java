package com.javarush.task.task13.task1326;
import java.io.*;
import java.util.*;

/* 
Сортировка четных чисел из файла
*/

public class Solution {
    public static void main(String[] args) throws IOException {
        // напишите тут ваш код
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        //String fileName = br.readLine();

        //InputStream fin = new FileInputStream(fileName);
        BufferedReader reader = new BufferedReader(new InputStreamReader(new FileInputStream(br.readLine())));
        ArrayList<Integer> list = new ArrayList<>();
        String line;
        while ((line = reader.readLine()) != null) {
            Integer number = Integer.valueOf(line);
            if (number % 2 == 0) {
                list.add(number);
            }
        }
        br.close();
        reader.close();
        //fin.close();
        Collections.sort(list);
        for (Integer integer : list) {
            System.out.println(integer);
        }

    }
}

