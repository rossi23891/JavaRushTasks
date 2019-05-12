package com.javarush.task.task25.task2512;

/* 
Живем своим умом
*/
public class Solution implements Thread.UncaughtExceptionHandler {

    @Override
    public void uncaughtException(Thread t, Throwable e) {
        t.interrupt();
        Throwable th = e;
        printStack(e);
    }

    public static void printStack(Throwable ex){
        if(ex==null){
            return;
        }
        printStack(ex.getCause());
        System.out.println(ex.toString());
    }

    public static void main(String[] args) {
        new Solution().uncaughtException(Thread.currentThread(),new Exception("ABC", new RuntimeException("DEF", new IllegalAccessException("GHI"))));
    }
}
