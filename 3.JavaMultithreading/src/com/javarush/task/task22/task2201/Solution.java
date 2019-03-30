package com.javarush.task.task22.task2201;

import com.sun.corba.se.impl.presentation.rmi.ExceptionHandler;

import java.util.ArrayList;

/*
Строки нитей или строковые нити? Вот в чем вопрос
*/
public class Solution {
    public static void main(String[] args) {
        new Solution();
    }

    public static final String FIRST_THREAD_NAME = "1#";
    public static final String SECOND_THREAD_NAME = "2#";

    private Thread thread1;
    private Thread thread2;
    private Thread thread3;

    public Solution() {
        initThreads();
    }

    protected void initThreads() {
        this.thread1 = new Thread(new Task(this, "A\tB\tC\tD\tE\tF\tG\tH\tI"), FIRST_THREAD_NAME);
        this.thread2 = new Thread(new Task(this, "J\tK\tL\tM\tN\tO\tP\tQ\tR\tS\tT\tU\tV\tW\tX\tY\tZ"), SECOND_THREAD_NAME);
        this.thread3 = new Thread(new Task(this, "\t\t"), "3#");

        Thread.setDefaultUncaughtExceptionHandler(new OurUncaughtExceptionHandler());

        this.thread1.start();
        this.thread2.start();
        this.thread3.start();
    }

    public synchronized String getPartOfString(String string, String threadName) {
        ArrayList<Integer> tabsInds = new ArrayList<>();
        RuntimeException e;
        Thread.UncaughtExceptionHandler exceptionHandler = Thread.getDefaultUncaughtExceptionHandler();
        if (string == null) {// прописать исключения
            if (Solution.FIRST_THREAD_NAME.equals(threadName)) {
                e = new StringForFirstThreadTooShortException();
                exceptionHandler.uncaughtException(Thread.currentThread(), e);
            } else if (Solution.SECOND_THREAD_NAME.equals(threadName)) {
                e = new StringForSecondThreadTooShortException();
                exceptionHandler.uncaughtException(Thread.currentThread(), e);
            } else {
                e = new RuntimeException();
                exceptionHandler.uncaughtException(Thread.currentThread(), e);
            }
        }
        for (int i = 0; i < string.length(); i++) {
            if (string.charAt(i)==9){
                tabsInds.add(i);
            }
        }
        if(tabsInds.isEmpty()||tabsInds.size()<2){
            if (Solution.FIRST_THREAD_NAME.equals(threadName)) {
                e = new StringForFirstThreadTooShortException();
                exceptionHandler.uncaughtException(Thread.currentThread(), e);
            } else if (Solution.SECOND_THREAD_NAME.equals(threadName)) {
                e = new StringForSecondThreadTooShortException();
                exceptionHandler.uncaughtException(Thread.currentThread(), e);
            } else {
                e = new RuntimeException();
                exceptionHandler.uncaughtException(Thread.currentThread(), e);
            }
        }
        int startIndex = tabsInds.get(0)+1;
        int endIndex = tabsInds.get(tabsInds.size()-1);
        String result = null;
        if(startIndex==endIndex){
            result="";
        }else{
            result= string.substring(startIndex,endIndex);
        }
        return result;
    }
}
