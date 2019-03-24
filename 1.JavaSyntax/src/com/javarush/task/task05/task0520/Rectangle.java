package com.javarush.task.task05.task0520;

/* 
Создать класс прямоугольник (Rectangle)
*/


public class Rectangle {
    //напишите тут ваш код
    int left;
    int top;
    int width;
    int height;

    public Rectangle(int width, int height) {
        this.width = width;
        this.height = height;
    }

    public Rectangle(int left, int top, int width) {
        this.left = left;
        this.top = top;
        this.width = width;
        this.height = 17;
            }

    public Rectangle(int left, int top, int width, int height) {
        this.left = left;
        this.top = top;
        this.width = width;
        this.height = height;
    }

    public Rectangle(Rectangle rec) {
        this.top = rec.top;
        this.left = rec.left;
        this.width = rec.width;
        this.height = rec.height;
    }

    public static void main(String[] args) {

    }
}
