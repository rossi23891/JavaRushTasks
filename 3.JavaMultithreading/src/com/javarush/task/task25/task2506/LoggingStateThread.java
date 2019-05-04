package com.javarush.task.task25.task2506;

public class LoggingStateThread extends Thread {
    Thread thread;


    public LoggingStateThread(Thread thread) {
        this.thread = thread;
        System.out.println(thread.getState());

    }

    @Override
    public void run() {
        State state=null;
        State lastState=null;
        lastState = thread.getState();
        while (lastState!=State.TERMINATED){
            state=thread.getState();
            if(state!=lastState){
                System.out.println(state);
                lastState=state;
            }
        }
            thread.interrupt();
    }
}
