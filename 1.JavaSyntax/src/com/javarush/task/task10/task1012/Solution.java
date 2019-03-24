package com.javarush.task.task10.task1012;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;

/* 
Количество букв
*/

public class Solution {
    public static void main(String[] args) throws Exception {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        // Алфавит
        String abc = "абвгдеёжзийклмнопрстуфхцчшщъыьэюя";
        char[] abcArray = abc.toCharArray();

        ArrayList<Character> alphabet = new ArrayList<Character>();
        for (int i = 0; i < abcArray.length; i++) {
            alphabet.add(abcArray[i]);
        }

        // Ввод строк
        ArrayList<String> list = new ArrayList<String>();
        for (int i = 0; i < 10; i++) {
            String s = reader.readLine();
            list.add(s.toLowerCase());
        }
        int[] counts = new int[abcArray.length];
        for (String s:list) {
            for (int i = 0; i < s.length(); i++) {
                //System.out.println(alphabet.indexOf(s.charAt(i)));
                if(alphabet.contains(s.charAt(i))) {
                    counts[alphabet.indexOf(s.charAt(i))]++;
                }
                /*if(s.charAt(i)>=160 && s.charAt(i)<166){
                    counts[s.charAt(i)-160]++;
                }
                if(s.charAt(i)==241){
                    counts[6]++;
                }
                if(s.charAt(i)>=166 && s.charAt(i)<176){
                    counts[s.charAt(i)-159]++;
                }
                if(s.charAt(i)>=224 && s.charAt(i)<240){
                    counts[s.charAt(i)-197]++;
                }*/
            }
        }
        for (int i = 0; i < alphabet.size() ; i++) {
            System.out.println(alphabet.get(i) + " " + counts[i]);
        }



    }

}
