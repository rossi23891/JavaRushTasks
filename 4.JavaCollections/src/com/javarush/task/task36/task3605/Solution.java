package com.javarush.task.task36.task3605;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import java.util.TreeSet;

/* 
Использование TreeSet
*/
public class Solution {
    public static void main(String[] args) throws IOException {
        Set<Character> alphabet = new TreeSet<>();
        List<String>list = Files.readAllLines(Paths.get(args[0]));
        for (String s : list) {
            char[]chars = s.toLowerCase().toCharArray();
            for (char letter : chars) {
                if (Character.isAlphabetic(letter)) {
                    alphabet.add(letter);
                }
            }
        }

        if(alphabet.size()<=5){
            alphabet.forEach(System.out::print);
        }else{
            Iterator<Character>iterator=alphabet.iterator();
            for (int i = 0; i < 5; i++) {
                System.out.print(iterator.next());
            }
        }
    }
}
