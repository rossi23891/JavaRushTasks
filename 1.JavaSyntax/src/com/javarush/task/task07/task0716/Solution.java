package com.javarush.task.task07.task0716;

import java.util.ArrayList;

/* 
Р или Л
*/

public class Solution {
    public static void main(String[] args) throws Exception {
        ArrayList<String> list = new ArrayList<String>();
        list.add("роза"); // 0
        list.add("лоза"); // 1
        list.add("лира"); // 2
        list = fix(list);

        for (String s : list) {
            System.out.println(s);
        }
    }

    public static ArrayList<String> fix(ArrayList<String> list) {
        //напишите тут ваш код
        for (int i = 0; i < list.size();) {
            char[] listChars = list.get(i).toCharArray();
            ArrayList <Character> chars = new ArrayList<>();
            for(char c: listChars){
                  chars.add(c);
                }
                if(chars.contains('р') && !chars.contains('л')){
                    list.remove(i);
                }else if(chars.contains('л') && !chars.contains('р')){
                    list.add(i+1,list.get(i));
                    i+=2;
                }else{
                    i++;
                }

        }
        return list;
    }
}