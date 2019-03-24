package com.javarush.task.task10.task1013;

/* 
Конструкторы класса Human
*/

public class Solution {
    public static void main(String[] args) {
    }

    public static class Human {
        // Напишите тут ваши переменные и конструкторы
        private int age;
        private char sex;
        private String name;
        private String complexity;
        private double weight;
        private boolean employed;

        public Human(int age) {
            this.age = age;
        }

        public Human(int age, char sex, String name) {
            this.age = age;
            this.sex = sex;
            this.name = name;
        }

        public Human(char sex, boolean employed) {
            this.sex = sex;
            this.employed = employed;
        }

        public Human(int age, char sex, String name, String complexity) {
            this.age = age;
            this.sex = sex;
            this.name = name;
            this.complexity = complexity;
        }

        public Human(boolean employed, int age) {
            this.employed = employed;
            this.age = age;
        }

        public Human(double weight) {
            this.weight = weight;
        }

        public Human(int age, char sex, String complexity, double weight) {
            this.age = age;
            this.sex = sex;
            this.complexity = complexity;
            this.weight = weight;
        }

        public Human(int age, char sex) {
            this.age = age;
            this.sex = sex;
        }

        public Human(int age, char sex, String name, String complexity, double weight) {
            this.age = age;
            this.sex = sex;
            this.name = name;
            this.complexity = complexity;
            this.weight = weight;
        }

        public Human(int age, char sex, String name, String complexity, double weight, boolean employed) {
            this.age = age;
            this.sex = sex;
            this.name = name;
            this.complexity = complexity;
            this.weight = weight;
            this.employed = employed;
        }
    }
}
