package com.javarush.task.task21.task2113;

import java.util.ArrayList;
import java.util.List;

public class Hippodrome {
    private List<Horse> horses;
    public static Hippodrome game;

    public List<Horse> getHorses() {
        return horses;
    }

    public Hippodrome(List<Horse> horses) {
        this.horses = horses;
    }
    public void run(){
        for (int i = 1; i <= 100; i++) {
            move();
            print();
            try {
                Thread.sleep(200);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

    }
    public void move(){
        for (Horse horse : horses) {
            horse.move();
        }
    }
    public void print(){
        for (Horse horse : horses) {
            horse.print();
        }
        for (int i = 0; i <10 ; i++) {
            System.out.println();
        }
    }
    public Horse getWinner(){
        double max = horses.get(0).getDistance();
        int index = 0;
        for (int i = 1; i <horses.size() ; i++) {
            if(horses.get(i).getDistance()>max){
                max = horses.get(i).getDistance();
                index=i;
            }
        }
        return horses.get(index);

    }
    public void printWinner(){
        System.out.println("Winner is " + getWinner().getName() + "!");
    }

    public static void main(String[] args){
        List<Horse> currentHorses = new ArrayList<>();
        currentHorses.add(new Horse("Sivka",3.0,0.0));
        currentHorses.add(new Horse("Burka",3.0,0.0));
        currentHorses.add(new Horse("Kaurka",3.0,0.0));
        game = new Hippodrome(currentHorses);
        game.run();
        game.printWinner();
    }
}
