package com.javarush.task.task06.task0612;

/* 
Калькулятор
*/

public class Calculator {
    public static int plus(int a, int b) {
        //напишите тут ваш код
        int plus = a+b;
        return plus;
    }

    public static int minus(int a, int b) {
        //напишите тут ваш код
        int minus = a-b;
        return minus;
    }

    public static int multiply(int a, int b) {
        //напишите тут ваш код
        int mult = a*b;
        return mult;
    }

    public static double division(int a, int b) {
        //напишите тут ваш код
        double div = (double)a/(double)b;
        return div;
    }

    public static double percent(int a, int b) {
        //напишите тут ваш код
        double percent = a*((double)b/100);
        return percent;
    }

    public static void main(String[] args) {

    }
}