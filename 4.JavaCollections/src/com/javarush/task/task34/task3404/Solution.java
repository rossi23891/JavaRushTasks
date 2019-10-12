package com.javarush.task.task34.task3404;

import java.util.Stack;

/*
Рекурсия для мат. выражения
*/
public class Solution {
    public static void main(String[] args) {
        Solution solution = new Solution();
        solution.recurse("sin(2*(-5+1.5*4)+28)", 0); //expected output 0.5 6

    }

    Stack<String> stack = new Stack<>();
    public void recurse(final String expression, int countOperation) {
        //implement

    }

    public Solution() {
        //don't delete
    }
}
