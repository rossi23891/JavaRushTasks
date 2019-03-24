package com.javarush.task.task19.task1921;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/* 
Хуан Хуанович
*/

public class Solution {
    public static final List<Person> PEOPLE = new ArrayList<Person>();

    public static void main(String[] args) throws IOException, ParseException {
        try (BufferedReader reader = new BufferedReader(new FileReader(args[0]))) {
            String reg = "\\d{1,2}\\s\\d{1,2}\\s\\d{4}";
            String reg1 = "\\D+";
            Pattern pattern = Pattern.compile(reg);
            Pattern pattern1 = Pattern.compile(reg1);
            SimpleDateFormat format = new SimpleDateFormat("dd MM yyyy");
            Date birthDate;
            String line;
            while (reader.ready()){
                line = reader.readLine();
                Matcher matcher = pattern.matcher(line);
                Matcher matcher1 = pattern1.matcher(line);
                if(matcher.find() && matcher1.find()){
                    String date = matcher.group();
                    birthDate = format.parse(date);
                    String nameSpace = matcher1.group();
                    String name = nameSpace.substring(0,nameSpace.length()-1);
                    PEOPLE.add(new Person(name,birthDate));
                }
            }

        }
    }
}
