package com.javarush.task.task08.task0824;

/* 
Собираем семейство
*/

import java.util.ArrayList;

public class Solution {
    public static void main(String[] args) {
        //напишите тут ваш код
        ArrayList<Human> children0 = new ArrayList<>();
        Human child1 = new Human("Anya", false,10,children0);
        Human child2 = new Human("Inna", false,16,children0);
        Human child3 = new Human("Vova", true,6,children0);
        ArrayList<Human> children = new ArrayList<>();
        children.add(child1);
        children.add(child2);
        children.add(child3);
        Human father = new Human("Andrey",true,38,children);
        Human mother = new Human("Lena",false,35,children);
        ArrayList<Human> children1 = new ArrayList<>();
        children1.add(father);
        Human grandpa1 = new Human("Vasya",true, 80,children1);
        Human grandma1 = new Human("Dusya",false,65,children1);
        ArrayList<Human> children2 = new ArrayList<>();
        children2.add(mother);
        Human grandpa2 = new Human("Kolya",true,77,children2);
        Human grandma2 = new Human("Galina",false,69,children2);
        System.out.println(child1.toString());
        System.out.println(child2.toString());
        System.out.println(child3.toString());
        System.out.println(father.toString());
        System.out.println(mother.toString());
        System.out.println(grandma1.toString());
        System.out.println(grandpa1.toString());
        System.out.println(grandma2.toString());
        System.out.println(grandpa2.toString());
    }

    public static class Human {
        //напишите тут ваш код
        String name;
        boolean sex;
        int age;
        ArrayList<Human> children;

        public Human(String name, boolean sex, int age, ArrayList<Human> children) {
            this.name = name;
            this.sex = sex;
            this.age = age;
            this.children = children;
        }

        public String toString() {
            String text = "";
            text += "Имя: " + this.name;
            text += ", пол: " + (this.sex ? "мужской" : "женский");
            text += ", возраст: " + this.age;

            int childCount = this.children.size();
            if (childCount > 0) {
                text += ", дети: " + this.children.get(0).name;

                for (int i = 1; i < childCount; i++) {
                    Human child = this.children.get(i);
                    text += ", " + child.name;
                }
            }
            return text;
        }
    }

}
