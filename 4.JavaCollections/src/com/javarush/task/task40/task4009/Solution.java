package com.javarush.task.task40.task4009;

/* 
Buon Compleanno!
*/

import java.time.LocalDate;
import java.time.Year;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.time.format.TextStyle;
import java.util.Locale;

public class Solution {
    public static void main(String[] args) {
        System.out.println(getWeekdayOfBirthday("30.05.1984", "2015"));
    }

    public static String getWeekdayOfBirthday(String birthday, String year) {
        //напишите тут ваш код
        //напишите тут ваш код
        try {
            DateTimeFormatter formatDate = DateTimeFormatter.ofPattern("d.M.yyyy");
            LocalDate birthdayDate = LocalDate.parse(birthday, formatDate);

            Year yearOfQuery = Year.parse(year);
            LocalDate birthdayDateInYearOfQuery = LocalDate.of(
                    yearOfQuery.getValue()
                    , birthdayDate.getMonth()
                    , birthdayDate.getDayOfMonth());
            birthdayDateInYearOfQuery = birthdayDate.withYear(yearOfQuery.getValue());

            Locale locale = Locale.ITALIAN;
            TextStyle textStyle = TextStyle.FULL;

            return birthdayDateInYearOfQuery.getDayOfWeek().getDisplayName(textStyle, locale);
        } catch (DateTimeParseException exp) {

            System.out.println("Error! Unparseable date: " + birthday + " " + year);
            exp.printStackTrace();
        }
        return null;
    }
}
