package com.javarush.task.task16.task1632;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class Solution {
    public static List<Thread> threads = new ArrayList<>(5);
    static {
        Thread t1 = new ThreadOne();
        Thread t2 = new ThreadTwo();
        Thread t3 = new ThreadThree();
        Thread t4 = new ThreadFour();
        Thread t5 = new ThreadFive();
        threads.add(t1);
        threads.add(t2);
        threads.add(t3);
        threads.add(t4);
        threads.add(t5);

    }


    public static void main(String[] args) {
        for (Thread thread : threads) {
            thread.start();
        }
        ((ThreadFour)threads.get(3)).showWarning();
    }

    public static class ThreadOne extends Thread{
        @Override
        public void run() {
            while (true){

            }
        }
    }

    public static class ThreadTwo extends Thread{
        @Override
        public void run() {
            try{
                Thread.sleep(500);
            }catch (InterruptedException e){
                System.out.println("InterruptedException");
            }
        }
    }

    public static class ThreadThree extends Thread{
        @Override
        public void run() {
            try {
                while (true){
                    System.out.println("Ура");
                    Thread.sleep(500);
                }
            } catch (InterruptedException e) {

            }
        }
    }

    public static class ThreadFour extends Thread implements Message{

        @Override
        public void run() {
            while (!isInterrupted()){

            }
        }

        @Override
        public void showWarning() {
            this.interrupt();
        }
    }

    public static class ThreadFive extends Thread{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String line;
        int number;
        int sum=0;

        @Override
        public void run() {
            try{
                while(!(line=br.readLine()).equals("N")){
                    number = Integer.parseInt(line);
                    sum+=number;
                }
                System.out.println(sum);
            }catch (IOException e){

            }

        }
    }
}