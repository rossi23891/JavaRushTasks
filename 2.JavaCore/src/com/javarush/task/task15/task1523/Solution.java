package com.javarush.task.task15.task1523;

/* 
Перегрузка конструкторов
*/

public class Solution {
    int data;
    String word;
    int data1;
    public Solution(int data) {
        this.data = data;
    }

    protected Solution(int data, String word) {
        this.data = data;
        this.word = word;
    }

    private Solution(int data, int data1) {
        this.data = data;
        this.data1 = data1;
    }
    Solution() {
    }

    public static void main(String[] args) {

    }
}

