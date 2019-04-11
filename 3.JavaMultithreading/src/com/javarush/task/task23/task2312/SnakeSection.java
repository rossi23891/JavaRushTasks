package com.javarush.task.task23.task2312;

import java.util.Objects;

public class SnakeSection {
    private int x;
    private int y;

    public SnakeSection(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    @Override
    public int hashCode() {
        int hashcode = 0;
        hashcode = 31*x+y;
        return hashcode;
    }

    @Override
    public boolean equals(Object obj) {
         return Objects.equals(this,obj);
    }

    public void checkBorders(SnakeSection head){
        if(head.getX()<0 || head.getY()<0){

        }
    }
}
