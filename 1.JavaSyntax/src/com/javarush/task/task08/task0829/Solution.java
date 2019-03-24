package com.javarush.task.task08.task0829;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/* 
Модернизация ПО
*/

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        // List of addresses and cities
        Map<String,String> locals = new HashMap<>();
        while (true) {
            String town = reader.readLine();
            if (town.isEmpty()) break;
            String family = reader.readLine();
            if (family.isEmpty()) break;
            locals.put(town,family);
        }
        String input = reader.readLine();

        if(locals.containsKey(input)){
            String output = locals.get(input);
            System.out.println(output);
        }

        // Read the house number
        /*int houseNumber = Integer.parseInt(reader.readLine());

        if (0 <= houseNumber && houseNumber < addresses.size()) {
            String familyName = addresses.get(houseNumber);
            System.out.println(familyName);
        }*/
    }
}
