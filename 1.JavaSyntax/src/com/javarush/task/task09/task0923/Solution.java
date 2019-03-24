package com.javarush.task.task09.task0923;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/* 
Гласные и согласные
*/

public class Solution {
    public static char[] vowels = new char[]{'а', 'я', 'у', 'ю', 'и', 'ы', 'э', 'е', 'о', 'ё'};

    public static void main(String[] args) throws Exception {
        //напишите тут ваш код
        Scanner sc = new Scanner(System.in);
        List<Character> vow = new ArrayList<>();
        List<Character> nonvow = new ArrayList<>();
        String s = sc.nextLine();
        char[] sArray = s.toCharArray();
        char space = ' ';
        for (int i = 0; i < sArray.length ;i++) {
            if(isVowel(sArray[i])){
                vow.add(sArray[i]);
            }
            else if(sArray[i]==space){
            }
            else{
                nonvow.add(sArray[i]);
            }
        }
        for (Character character : vow) {
            System.out.print(character);
            System.out.print(" ");
        }
        System.out.println();
        for (Character character : nonvow) {
            System.out.print(character);
            System.out.print(" ");
        }

    }

    // метод проверяет, гласная ли буква
    public static boolean isVowel(char c) {
        c = Character.toLowerCase(c);  // приводим символ в нижний регистр - от заглавных к строчным буквам

        for (char d : vowels)   // ищем среди массива гласных
        {
            if (c == d)
                return true;
        }
        return false;
    }
}