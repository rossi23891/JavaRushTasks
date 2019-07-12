package com.javarush.task.task28.task2805;


import java.util.concurrent.atomic.AtomicInteger;

public class MyThread extends Thread {
    private static AtomicInteger count= new AtomicInteger(Thread.MIN_PRIORITY);
    {
        if(count.get()>10){count.set(Thread.MIN_PRIORITY);}
        if (count.get() > Thread.MAX_PRIORITY ) {count.set(Thread.MAX_PRIORITY);}
        setPriority(count.getAndIncrement());
    }

    public MyThread() {
    }

    public MyThread(Runnable target) {
        super(target);
    }

    public MyThread(ThreadGroup group, Runnable target) {
        super(group, target);
    }

    public MyThread(String name) {
        super(name);
    }

    public MyThread(ThreadGroup group, String name) {
        super(group, name);
    }

    public MyThread(Runnable target, String name) {
        super(target, name);
    }

    public MyThread(ThreadGroup group, Runnable target, String name) {
        super(group, target, name);
    }

    public MyThread(ThreadGroup group, Runnable target, String name, long stackSize) {
        super(group, target, name, stackSize);
    }



}
