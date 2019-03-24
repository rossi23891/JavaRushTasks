package com.javarush.task.task09.task0922;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.Locale;

import static java.util.Locale.ENGLISH;

/* 
Какое сегодня число?
*/

public class Solution {

    public static void main(String[] args) throws Exception {
        //напишите тут ваш код
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        SimpleDateFormat ft = new SimpleDateFormat("yyyy-MM-dd");
        String s = br.readLine();
        Date dat = ft.parse(s);
        Calendar cal = new GregorianCalendar();
        cal.setTime(dat);
        SimpleDateFormat ft2 = new SimpleDateFormat("MMM dd, yyyy",Locale.ENGLISH);
        String s1 = ft2.format(dat);
        System.out.println(s1.toUpperCase());
    }
}
