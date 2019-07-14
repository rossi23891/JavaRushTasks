package com.javarush.task.task28.task2802;


import java.util.concurrent.ThreadFactory;
import java.util.concurrent.atomic.AtomicInteger;

/* 
Пишем свою ThreadFactory
*/
public class Solution {
    static final AtomicInteger fabricCount = new AtomicInteger(1);

    public static class AmigoThreadFactory implements ThreadFactory{
        Thread thread;
        AtomicInteger threadCount = new AtomicInteger(1);
        int poolNumber = fabricCount.getAndIncrement();

        @Override
        public Thread newThread(Runnable r) {
            thread = new Thread(r);
            if(thread.getPriority()!=Thread.NORM_PRIORITY){
                thread.setPriority(Thread.NORM_PRIORITY);
            }
            if(thread.isDaemon()){
                thread.setDaemon(false);
            }
            thread.setName(thread.getThreadGroup().getName() + "-pool-" + poolNumber + "-thread-" + threadCount.getAndIncrement());
            return thread;
        }
    }

    public static void main(String[] args) {
        class EmulatorThreadFactoryTask implements Runnable {
            @Override
            public void run() {
                emulateThreadFactory();
            }
        }

        ThreadGroup group = new ThreadGroup("firstGroup");
        Thread thread = new Thread(group, new EmulatorThreadFactoryTask());

        ThreadGroup group2 = new ThreadGroup("secondGroup");
        Thread thread2 = new Thread(group2, new EmulatorThreadFactoryTask());

        thread.start();
        thread2.start();
    }

    private static void emulateThreadFactory() {
        AmigoThreadFactory factory = new AmigoThreadFactory();
        Runnable r = new Runnable() {
            @Override
            public void run() {
                System.out.println(Thread.currentThread().getName());
            }
        };
        factory.newThread(r).start();
        factory.newThread(r).start();
        factory.newThread(r).start();
    }
}
