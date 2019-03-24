package com.javarush.task.task07.task0724;

/* 
Семейная перепись
*/

public class Solution {
    public static void main(String[] args) {
        // напишите тут ваш код
        Human grandad1 = new Human("Fedor",true,70);
        Human grandad2 = new Human("Makar",true,75);
        Human grandma1 = new Human("Vera",false,69);
        Human grandma2 = new Human("Luba",false,68);
        Human father = new Human("Alexander",true,45,grandad1,grandma1);
        Human mother = new Human("Anna",false,42,grandad2,grandma2);
        Human child1 = new Human("Lena",false,20,father,mother);
        Human child2 = new Human("Igor",true,17,father,mother);
        Human child3 = new Human("Ivan",true,10,father,mother);
        System.out.println(grandad1.toString());
        System.out.println(grandad2.toString());
        System.out.println(grandma1.toString());
        System.out.println(grandma2.toString());
        System.out.println(father.toString());
        System.out.println(mother.toString());
        System.out.println(child1.toString());
        System.out.println(child2.toString());
        System.out.println(child3.toString());

    }

    public static class Human {
        // напишите тут ваш код
        String name;
        boolean sex;
        int age;
        Human mother;
        Human father;

        public Human(String name, boolean sex,int age){
            this.name = name;
            this.sex = sex;
            this.age = age;
        }
        public Human(String name, boolean sex,int age,Human father, Human mother){
            this.name = name;
            this.sex = sex;
            this.age = age;
            this.father = father;
            this.mother = mother;
        }

        public String toString() {
            String text = "";
            text += "Имя: " + this.name;
            text += ", пол: " + (this.sex ? "мужской" : "женский");
            text += ", возраст: " + this.age;

            if (this.father != null)
                text += ", отец: " + this.father.name;

            if (this.mother != null)
                text += ", мать: " + this.mother.name;

            return text;
        }
    }
}