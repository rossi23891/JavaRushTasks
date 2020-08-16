package com.javarush.task.task40.task4008;

/* 
Работа с Java 8 DateTime API
*/

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoField;
import java.util.Calendar;

public class Solution {
    public static void main(String[] args) {
        printDate("9.10.2017 5:56:45");
        System.out.println();
        printDate("21.4.2014 15:56:45");
        System.out.println();
        printDate("21.4.2014");
        System.out.println();
        printDate("17:33:40");
    }

    public static void printDate(String date) {
        // if (date.matches("dd.MM.yyyy HH:mm:ss")){
        if (date.contains(" ")){
            printD(date.split(" ")[0]);
            printT(date.split(" ")[1]);
        }
        else if (date.contains("."))
            printD(date);
        else if (date.contains(":"))
            printT(date);
    }
    private static void printD(String date){
        DateTimeFormatter  dateFormat = DateTimeFormatter.ofPattern("d.M.yyyy");
        LocalDate localDate = LocalDate.parse(date, dateFormat);


        System.out.println("День: " + localDate.getDayOfMonth());
        System.out.println("День недели: " + (localDate.getDayOfWeek().getValue()));
        System.out.println("День месяца: " + localDate.getDayOfMonth());
        System.out.println("День года: " + localDate.getDayOfYear());
        System.out.println("Неделя месяца: " + (localDate.getDayOfMonth() / 7 + 1));
        System.out.println("Неделя года: " + ((localDate.getDayOfYear() + 1) / 7 + 1));
        System.out.println("Месяц: " + localDate.getMonthValue());
        System.out.println("Год: " + localDate.getYear());
    }
    private static void printT(String date){
        DateTimeFormatter  dateFormat = DateTimeFormatter.ofPattern("H:m:s");
        LocalTime localTime = LocalTime.parse(date, dateFormat);

        System.out.println("AM или PM: " +  (localTime.get(ChronoField.AMPM_OF_DAY)==1?"PM" : "AM"));
        System.out.println("Часы: " + localTime.get(ChronoField.CLOCK_HOUR_OF_AMPM));

        System.out.println("Часы дня: " + localTime.getHour());
        System.out.println("Минуты: " + localTime.getMinute());
        System.out.println("Секунды: " + localTime.getSecond());

    }
}
