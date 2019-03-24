package com.javarush.task.task06.task0610;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Scanner;

/* 
Класс ConsoleReader
*/

public class ConsoleReader {
    public static String readString() throws Exception {
        //напишите тут ваш код
        Scanner sc = new Scanner(System.in);
        String s = sc.nextLine();
        return s;
    }

    public static int readInt() throws Exception {
        //напишите тут ваш код
        Scanner sc1 = new Scanner(System.in);
        int r = sc1.nextInt();
        return r;
    }

    public static double readDouble() throws Exception {
        //напишите тут ваш код
        Scanner sc2 = new Scanner(System.in);
        double ds = sc2.nextDouble();
        return ds;
    }

    public static boolean readBoolean() throws Exception {
        //напишите тут ваш код
        Scanner sc3 = new Scanner(System.in);
        boolean bl = sc3.nextBoolean();
        return  bl;
    }

    public static void main(String[] args) {

    }
}
