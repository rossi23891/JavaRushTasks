package com.javarush.task.task30.task3002;

import java.math.BigInteger;

/*
Осваиваем методы класса Integer
*/
public class Solution {

    public static void main(String[] args) {
        System.out.println(convertToDecimalSystem("0x16")); //22
        System.out.println(convertToDecimalSystem("012"));  //10
        System.out.println(convertToDecimalSystem("0b10")); //2
        System.out.println(convertToDecimalSystem("62"));   //62
    }

    public static String convertToDecimalSystem(String s) {
        //напишите тут ваш код
        int radix;
        String strForCheck = "";
        if (s.startsWith("-")) {
            strForCheck += "-";
            s = s.substring(1);
        }
        if (s.startsWith("0x")) {
            strForCheck += s.substring(2);
            radix = 16;
        } else if (s.startsWith("0b")) {
            strForCheck += s.substring(2);
            radix = 2;
        } else if (s.startsWith("0")) {
            strForCheck += s;
            radix = 8;
        } else {
            strForCheck += s;
            radix = 10;
        }

        return Integer.toString(Integer.parseInt(strForCheck, radix));
    }
}
