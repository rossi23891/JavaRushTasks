package com.javarush.task.task08.task0827;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.Locale;

/* 
Работа с датой
*/

public class Solution {
    public static void main(String[] args) throws ParseException {
        System.out.println(isDateOdd("January 1 2013"));
    }

    public static boolean isDateOdd(String date) throws ParseException {
        DateFormat format = new SimpleDateFormat("MMMM d yyyy", Locale.ENGLISH);
        Date date1 = format.parse(date);
        Calendar cal = new GregorianCalendar();
        cal.setTime(date1);
        int dayOfYear = cal.get(Calendar.DAY_OF_YEAR);
        if((dayOfYear+1)%2==0){
            return true;
        } else{
            return false;
        }
    }
}
