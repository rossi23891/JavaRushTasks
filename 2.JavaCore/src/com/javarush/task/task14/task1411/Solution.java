package com.javarush.task.task14.task1411;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;

/* 
User, Loser, Coder and Proger
*/

public class Solution {
    public static void main(String[] args) throws Exception {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String key = null;
        PersonFactory factory = new PersonFactory();
        ArrayList<String> keys = new ArrayList<>();
        keys.add("user");
        keys.add("loser");
        keys.add("coder");
        keys.add("proger");

        while (keys.contains(key = reader.readLine())) {
            Person person=factory.createPerson(key);
            doWork(person);
        }
    }
         static class PersonFactory {
            static Person createPerson(String key){
                Person person = null;

        if(key.equals("user")){
            person = new Person.User();
        }
        else if(key.equals("loser")){
            person = new Person.Loser();
        }
        else if(key.equals("coder")){
            person = new Person.Coder();
        }
        else if(key.equals("proger")){
            person = new Person.Proger();
        }
          return person;
            }
         }

        //тут цикл по чтению ключей, пункт 1


    public static void doWork(Person person) {
        // пункт 3
        if(person instanceof Person.User){
            ((Person.User) person).live();
        } else if(person instanceof Person.Loser){
            ((Person.Loser) person).doNothing();
        }else if(person instanceof Person.Coder){
            ((Person.Coder) person).writeCode();
        }else if(person instanceof Person.Proger){
            ((Person.Proger) person).enjoy();
        }
    }
}
