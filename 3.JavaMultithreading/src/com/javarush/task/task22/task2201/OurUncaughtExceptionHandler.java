package com.javarush.task.task22.task2201;


public class OurUncaughtExceptionHandler implements Thread.UncaughtExceptionHandler {
    @Override
    public void uncaughtException(Thread t, Throwable e) {
        final String string = "%s : %s : %s";
        if (Solution.FIRST_THREAD_NAME.equals(t.getName())) {
            System.out.println(getFormattedStringForFirstThread(t, e, string));
        } else
            if (Solution.SECOND_THREAD_NAME.equals(t.getName())) {
                System.out.println(getFormattedStringForSecondThread(t, e, string));
            } else {
                System.out.println(getFormattedStringForOtherThread(t, e, string));
            }
    }

    protected String getFormattedStringForOtherThread(Thread t, Throwable e, String string) {
        String s3 = String.format(string,e.getClass(),e.getMessage(),t.getName());
        return s3;
    }

    protected String getFormattedStringForSecondThread(Thread t, Throwable e, String string) {
        String s2 = String.format(string,e.getMessage(),e.getClass(),t.getName());
        return s2;
    }

    protected String getFormattedStringForFirstThread(Thread t, Throwable e, String string) {
        String s1 = String.format(string,t.getName(),e.getClass(),e.getMessage());
        return s1;
    }
}

