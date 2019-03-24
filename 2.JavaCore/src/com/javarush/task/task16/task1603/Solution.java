package com.javarush.task.task16.task1603;

import java.util.ArrayList;
import java.util.List;

/* 
Список и нити
*/

public class Solution {
    public static volatile List<Thread> list = new ArrayList<Thread>(5);

    public static void main(String[] args) {
        //Add your code here - добавьте свой код тут
        SpecialThread s1 = new SpecialThread();
        Thread thread1 = new Thread(s1);
        list.add(thread1);


        SpecialThread s2 = new SpecialThread();
        Thread thread2 = new Thread(s2);
        list.add(thread2);


        SpecialThread s3 = new SpecialThread();
        Thread thread3 = new Thread(s3);
        list.add(thread3);


        SpecialThread s4 = new SpecialThread();
        Thread thread4 = new Thread(s4);
        list.add(thread4);


        SpecialThread s5 = new SpecialThread();
        Thread thread5 = new Thread(s5);
        list.add(thread5);


    }

    public static class SpecialThread implements Runnable {
        public void run() {
            System.out.println("it's a run method inside SpecialThread");
        }
    }
}
