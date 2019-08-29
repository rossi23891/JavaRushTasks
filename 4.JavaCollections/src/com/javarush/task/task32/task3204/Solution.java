package com.javarush.task.task32.task3204;

import java.io.ByteArrayOutputStream;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/* 
Генератор паролей
*/
public class Solution {
    public static void main(String[] args) {
        ByteArrayOutputStream password = getPassword();
        System.out.println(password.toString());
    }

    public static ByteArrayOutputStream getPassword() {
        List<Integer> cases = new ArrayList<>();
        //0-digit
        //1 - uppercase letter
        //2 - LowerCase letter
        cases.add(0);
        cases.add(1);
        cases.add(2);
        for (int i = 3; i < 8; i++) {
            cases.add((int) (Math.random()*3));
        }
        Collections.shuffle(cases);
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        for (Integer aCase : cases) {
            switch (aCase){
                case 0:byteArrayOutputStream.write(48 + (byte)(Math.random()*9));
                break;
                case 1: byteArrayOutputStream.write((byte) (65 + Math.random() * 26));
                break;
                case 2:byteArrayOutputStream.write((byte) (97 + Math.random() * 26));
                break;
            }
        }
        return byteArrayOutputStream;
    }
}