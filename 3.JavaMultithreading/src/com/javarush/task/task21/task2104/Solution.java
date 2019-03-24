package com.javarush.task.task21.task2104;

import java.util.HashSet;
import java.util.Set;

/* 
Equals and HashCode
*/
public class Solution {
    private final String first, last;

    public Solution(String first, String last) {
        this.first = first;
        this.last = last;
    }

    public boolean equals(Object n) {
        if (this == n) return true;
        if (n == null || !(n instanceof Solution)) return false;
        Solution solution = (Solution)n;
        if(solution.first!=null? !solution.first.equals(first):first!=null){
            return false;
        }
        if(solution.last!=null? !solution.last.equals(last):last!=null){
            return false;
        }

        return true;
    }



    public int hashCode() {
        int hashCode = 0;
        if(first!=null){
            hashCode = 31*first.hashCode();
        }
        if(last!=null){
            hashCode=hashCode+last.hashCode();
        }

        return hashCode;
    }

    public static void main(String[] args) {
        Set<Solution> s = new HashSet<>();
        s.add(new Solution("Donald", "Duck"));
        System.out.println(s.contains(new Solution("Donald", "Duck")));
    }
}
