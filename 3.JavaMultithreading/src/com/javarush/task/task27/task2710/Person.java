package com.javarush.task.task27.task2710;

public class Person implements Runnable {
    private final Mail mail;

    public Person(Mail mail) {
        this.mail = mail;
    }

    @Override
    public void run() {
        String name = Thread.currentThread().getName();
        try {
            synchronized (mail){
                Thread.sleep(1000);
                mail.setText("Person [" + name + "] wrote an email 'AAA'");
                mail.notify();
            }

        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
