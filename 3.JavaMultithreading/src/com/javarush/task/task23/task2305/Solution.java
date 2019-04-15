package com.javarush.task.task23.task2305;

/* 
Inner
*/
public class Solution {
    public InnerClass[] innerClasses = new InnerClass[2];

    public class InnerClass {
    }

    public static Solution[] getTwoSolutions() {
        Solution[] total = new Solution[2];
        Solution solution1 = new Solution();
        Solution solution2 = new Solution();
        solution1.innerClasses[0]=solution1.new InnerClass();
        solution1.innerClasses[1]=solution1.new InnerClass();
        solution2.innerClasses[0]=solution2.new InnerClass();
        solution2.innerClasses[1]=solution2.new InnerClass();
        total[0] = solution1;
        total[1] = solution2;

        return total;
    }

    public static void main(String[] args) {

    }
}
