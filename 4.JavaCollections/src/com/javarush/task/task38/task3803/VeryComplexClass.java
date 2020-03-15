package com.javarush.task.task38.task3803;

/* 
Runtime исключения (unchecked exception)
*/

import java.util.ArrayList;
import java.util.List;

public class VeryComplexClass {
    public void methodThrowsClassCastException() throws ClassCastException {
        Object data = "data";
        Integer d = (Integer) data;
    }

    public void methodThrowsNullPointerException() throws NullPointerException{
        String s = null;
        System.out.println(s.length());
    }

    public static void main(String[] args) {

    }
}
