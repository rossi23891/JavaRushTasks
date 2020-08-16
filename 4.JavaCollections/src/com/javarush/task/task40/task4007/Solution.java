package com.javarush.task.task40.task4007;

/* 
Работа с датами
*/

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;

public class Solution {
    public static void main(String[] args) {
        printDate("21.4.2014 15:56:45");
        System.out.println();
        printDate("21.4.2014");
        System.out.println();
        printDate("17:33:40");

        printDate("13.1.2019");
    }

    public static void printDate(String date) {
        //напишите тут ваш код
        date=date.trim();


        DateFormat dateFormat = null;
        String result = "";
        try {
            Calendar calendar = Calendar.getInstance();
            if (date.contains(":") && date.contains(".")) {
                dateFormat = new SimpleDateFormat("dd.MM.yyyy HH:mm:ss");
                calendar.setTime(dateFormat.parse(date));
                result = getDateFromCalendar(calendar) + "\n" + getTime(calendar);
            } else if (date.contains(":")) {
                dateFormat = new SimpleDateFormat("HH:mm:ss");
                calendar.setTime(dateFormat.parse(date));
                result = getTime(calendar);
            } else if (date.contains(".")) {
                dateFormat = new SimpleDateFormat("dd.MM.yyyy");
                calendar.setTime(dateFormat.parse(date));
                result = getDateFromCalendar(calendar);
            }


        } catch (ParseException e) {
            e.printStackTrace();
        }
        System.out.println(result);
    }

    private static String getDateFromCalendar(Calendar calendar) {
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append("День: ").append(calendar.get(Calendar.DAY_OF_MONTH)).append("\n");

        DateFormat dateFormat = new SimpleDateFormat("E");
        int dayOfWeekEuro = calendar.get(Calendar.DAY_OF_WEEK ) == 1 ? 7 : calendar.get(Calendar.DAY_OF_WEEK )-1;
        stringBuffer.append("День недели: ").append(String.valueOf(dayOfWeekEuro)).append("\n");
        stringBuffer.append("День месяца: ").append(calendar.get(Calendar.DAY_OF_MONTH  )).append("\n");
        stringBuffer.append("День года: ").append(calendar.get(Calendar.DAY_OF_YEAR)).append("\n");
        stringBuffer.append("Неделя месяца: ").append(calendar.get(Calendar.WEEK_OF_MONTH)).append("\n");
        stringBuffer.append("Неделя года: ").append(calendar.get(Calendar.WEEK_OF_YEAR)).append("\n");
        stringBuffer.append("Месяц: ").append(calendar.get(Calendar.MONTH ) +1).append("\n");
        stringBuffer.append("Год: ").append(calendar.get(Calendar.YEAR));
        return stringBuffer.toString();
    }

    private static String getTime(Calendar calendar) {
        StringBuffer stringBuffer = new StringBuffer();
        DateFormat dateFormat = new SimpleDateFormat("a");
        stringBuffer.append("AM или PM: ").append(dateFormat.format(calendar.getTime())).append("\n");
        stringBuffer.append("Часы: ").append(calendar.get(Calendar.HOUR)).append("\n");
        stringBuffer.append("Часы дня: ").append(calendar.get(Calendar.HOUR_OF_DAY)).append("\n");
        stringBuffer.append("Минуты: ").append(calendar.get(Calendar.MINUTE)).append("\n");
        stringBuffer.append("Секунды: ").append(calendar.get(Calendar.SECOND));
        return stringBuffer.toString();
    }
}
