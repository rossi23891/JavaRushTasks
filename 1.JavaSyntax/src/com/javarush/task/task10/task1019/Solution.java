package com.javarush.task.task10.task1019;

import java.io.*;
import java.util.HashMap;
import java.util.Map;

/* 
Функциональности маловато!
*/

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        HashMap<String, Integer> map = new HashMap<>();

        while (true) {
            // заново написать number format exception и подумать, че делать со стригном
            String s = reader.readLine();
            if (s.isEmpty()) {
                break;
            }
            int id = Integer.parseInt(s);
            String name = reader.readLine();
            if (name.isEmpty()) {
                map.put(name, id);
                break;
            }
            map.put(name, id);

        }
        for (Map.Entry<String, Integer> pair : map.entrySet()) {
            int id = pair.getValue();
            String name = pair.getKey();
            System.out.println(id + " " + name);
        }

    }
}
