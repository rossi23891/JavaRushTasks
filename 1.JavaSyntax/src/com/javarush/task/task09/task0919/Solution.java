package com.javarush.task.task09.task0919;

/* 
Деление на ноль
*/

public class Solution {

    public static void main(String[] args) {
        try{
            divisionByZero();
        }
        catch(Exception e){
            e.printStackTrace();
        }
    }

    public static void divisionByZero(){
        int result = 100/0;
        System.out.println(result);
    }
}
