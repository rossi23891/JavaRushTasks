package com.javarush.task.task17.task1711;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Locale;

/* 
CRUD 2
*/

public class Solution {
    public static volatile List<Person> allPeople = new ArrayList<Person>();

    static {
        allPeople.add(Person.createMale("Иванов Иван", new Date()));  //сегодня родился    id=0
        allPeople.add(Person.createMale("Петров Петр", new Date()));  //сегодня родился    id=1
        //allPeople.add(Person.createMale("Vasiliev Vasya", new Date()));  //сегодня родился    id=2
    }

    public static void main(String[] args) throws ParseException {
        //start here - начни тут
        SimpleDateFormat outputDateFormat = new SimpleDateFormat("dd-MMM-yyyy", Locale.ENGLISH);
        SimpleDateFormat inputDateFormat = new SimpleDateFormat("dd/MM/yyyy",Locale.ENGLISH);
        switch (args[0]){
            case "-c" :
                synchronized (allPeople){
                    int i=0;
                    while(i+3 < args.length){
                        Date dateInput = inputDateFormat.parse(args[i+3]);
                        if(args[i+2].equals("м")){
                            allPeople.add(Person.createMale(args[i+1],dateInput));
                        }
                        else if(args[i+2].equals("ж")){
                            allPeople.add(Person.createFemale(args[i+1],dateInput));
                        }
                        System.out.println(allPeople.size()-1);
                        i+=3;
                    }
                }
                break;
            case "-u" :
                synchronized (allPeople){
                    int i=0;
                    while(i+4 < args.length){
                        Person person = allPeople.get(Integer.parseInt(args[i+1]));
                        person.setName(args[i+2]);
                        if(args[i+3].equals("м")){
                            person.setSex(Sex.MALE);
                        }else if(args[i+3].equals("ж")){
                            person.setSex(Sex.FEMALE);
                        }
                        Date dateInput = inputDateFormat.parse(args[i+4]);
                        person.setBirthDate(dateInput);
                        i+=4;
                    }
                }
            break;

            case "-d" :
                synchronized (allPeople){
                    int i = 0;
                    while(i+1 <args.length){
                        Person person = allPeople.get(Integer.parseInt(args[i+1]));
                        person.setName(null);
                        person.setSex(null);
                        person.setBirthDate(null);
                        i++;
                    }
                }
            break;

            case "-i" :
                synchronized (allPeople){
                    for(int i=0;i<args.length-1;i++){
                            Person person = allPeople.get(Integer.parseInt(args[i+1]));
                            Date tempDate = person.getBirthDate();
                            String outDate = outputDateFormat.format(tempDate);
                            String outputSex = person.getSex()== Sex.MALE ? "м" : "ж";
                            System.out.println(person.getName() + " " + outputSex + " " + outDate);
                    }
                }
                break;
        }

    }

}
