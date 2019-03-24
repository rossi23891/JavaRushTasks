package com.javarush.task.task16.task1617;

/* 
Отсчет на гонках
*/

public class Solution {
    public static volatile int numSeconds = 4;

    public static void main(String[] args) throws InterruptedException {
        RacingClock clock = new RacingClock();
        Thread.sleep(3500);
        clock.interrupt();
        //add your code here - добавь код тут
    }

    public static class RacingClock extends Thread {
        public RacingClock() {
            start();
        }

        public void run() {
            //add your code here - добавь код тут
            Thread current = Thread.currentThread();
            while (!current.isInterrupted()){

                if(numSeconds<=0){
                    System.out.println("Марш!");
                    return;
                }
                System.out.print(numSeconds + " ");
                numSeconds--;
                try{
                    Thread.sleep(1000);
                }
                catch (InterruptedException e){
                    System.out.println("Прервано!");
                    return;
                }

            }

        }
    }
}
