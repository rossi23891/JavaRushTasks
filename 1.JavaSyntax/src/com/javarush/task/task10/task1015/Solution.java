package com.javarush.task.task10.task1015;

import java.util.ArrayList;

/* 
Массив списков строк
*/

public class Solution {
    public static void main(String[] args) {
        ArrayList<String>[] arrayOfStringList = createList();
        printList(arrayOfStringList);
    }

    public static ArrayList<String>[] createList() {
        //напишите тут ваш код
        ArrayList<String>[] strListok = new ArrayList[3];
        ArrayList<String> ind0 = new ArrayList<>();
        ind0.add("nomer nol");
        ind0.add("opayt nol");
        strListok[0] = ind0;
        ArrayList<String> ind1 = new ArrayList<>();
        ind1.add("odyn");
        ind1.add("111111 e");
        ind1.add("nizerty");
        strListok[1] = ind1;
        ArrayList<String> ind2 = new ArrayList<>();
        ind2.add("dva");
        strListok[2] = ind2;

        return strListok;
    }

    public static void printList(ArrayList<String>[] arrayOfStringList) {
        for (ArrayList<String> list : arrayOfStringList) {
            for (String s : list) {
                System.out.println(s);
            }
        }
    }
}