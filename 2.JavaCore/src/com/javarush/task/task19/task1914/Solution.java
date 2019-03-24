package com.javarush.task.task19.task1914;

/* 
Решаем пример
*/

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

public class Solution {
    public static TestString testString = new TestString();

    public static void main(String[] args) {
        PrintStream console = System.out;
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        PrintStream stream = new PrintStream(byteArrayOutputStream);
        System.setOut(stream);
        testString.printSomething();
        String example = byteArrayOutputStream.toString();
        String[] params = example.split(" ");
        int result=0;
        if(params[1].equals("+")){
            result = Integer.parseInt(params[0])+Integer.parseInt(params[2]);
        }else if(params[1].equals("-")){
            result = Integer.parseInt(params[0])-Integer.parseInt(params[2]);
        }else if(params[1].equals("*")){
            result = Integer.parseInt(params[0])*Integer.parseInt(params[2]);
        }
        String finalEx = example+String.valueOf(result);
        System.setOut(console);
        System.out.println(finalEx);
    }

    public static class TestString {
        public void printSomething() {
            System.out.println("3 + 6 = ");
        }
    }
}

