package com.javarush.task.task17.task1710;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Locale;

/* 
CRUD
*/

public class Solution {
    public static List<Person> allPeople = new ArrayList<Person>();

    static {
        allPeople.add(Person.createMale("Иванов Иван", new Date()));  //сегодня родился    id=0
        allPeople.add(Person.createMale("Петров Петр", new Date()));  //сегодня родился    id=1
    }

    public static void main(String[] args) throws ParseException {
        //start here - начни тут
        SimpleDateFormat outputDateFormat = new SimpleDateFormat("dd-MMM-yyyy", Locale.ENGLISH);
        SimpleDateFormat inputDateFormat = new SimpleDateFormat("dd/MM/yyyy",Locale.ENGLISH);
        if(args[0].equals("-c")){
            Date dateInput = inputDateFormat.parse(args[3]);
            if(args[2].equals("м")){
                allPeople.add(Person.createMale(args[1],dateInput));
            }
            else if(args[2].equals("ж")){
                allPeople.add(Person.createFemale(args[1],dateInput));
            }
            System.out.println(allPeople.size()-1);
        }
        else if(args[0].equals("-u")){
            Person person = allPeople.get(Integer.parseInt(args[1]));
            person.setName(args[2]);
            if(args[3].equals("м")){
                person.setSex(Sex.MALE);
            }else if(args[3].equals("ж")){
                person.setSex(Sex.FEMALE);
            }
            Date dateInput = inputDateFormat.parse(args[4]);
            person.setBirthDate(dateInput);
        }

        else if(args[0].equals("-d")){
            Person person = allPeople.get(Integer.parseInt(args[1]));
            person.setName(null);
            person.setSex(null);
            person.setBirthDate(null);
        }

        else if(args[0].equals("-i")){
            Person person = allPeople.get(Integer.parseInt(args[1]));
            Date tempDate = person.getBirthDate();
            String outDate = outputDateFormat.format(tempDate);
            String outputSex = person.getSex()== Sex.MALE ? "м" : "ж";
            System.out.println(person.getName() + " " + outputSex + " " + outDate);
        }
    }
}
