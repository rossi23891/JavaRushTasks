package com.javarush.task.task05.task0502;

/* 
Реализовать метод fight
*/

public class Cat {
    public int age;
    public int weight;
    public int strength;

    public Cat() {
    }

    public boolean fight(Cat anotherCat) {
        //напишите тут ваш код
        return ((this.strength+ this.age+this.weight)-(anotherCat.strength+anotherCat.age+anotherCat.weight)>2);
        }
    public static void main(String[] args) {
        Cat cat1 = new Cat();
        cat1.age =3;
        cat1.weight = 4;
        cat1.strength=100;
        Cat cat2 = new Cat();
        cat2.age = 2;
        cat2.weight=4;
        cat2.strength=150;
        System.out.println(cat1.fight(cat2));
    }
}
