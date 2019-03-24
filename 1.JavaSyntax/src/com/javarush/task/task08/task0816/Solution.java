package com.javarush.task.task08.task0816;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;

/* 
Добрая Зинаида и летние каникулы
*/

public class Solution {
    public static HashMap<String, Date> createMap() throws ParseException {
        DateFormat df = new SimpleDateFormat("MMMMM d yyyy", Locale.ENGLISH);
        HashMap<String, Date> map = new HashMap<String, Date>();
        map.put("Stallone", df.parse("JUNE 1 1980"));
        map.put("Stal", df.parse("JULY 1 1989"));
        map.put("Doc", df.parse("AUGUST 1 1975"));
        map.put("bugf", df.parse("SEPTEMBER 1 1907"));
        map.put("EDOL", df.parse("JANUARY 31 1954"));
        map.put("timor", df.parse("DECEMBER 10 1924"));
        map.put("roma", df.parse("JUNE 19 1980"));
        map.put("tromp", df.parse("MAY 4 1909"));
        map.put("EFOP", df.parse("NOVEMBER 6 1999"));
        map.put("krazy", df.parse("APRIL 8 2009"));

        //напишите тут ваш код
        return map;

    }

    public static void removeAllSummerPeople(HashMap<String, Date> map) {
        //напишите тут ваш код
        Iterator<Map.Entry<String,Date>> iter = map.entrySet().iterator();
        while(iter.hasNext()){
            Map.Entry<String, Date> pair = iter.next();
            Date date =  pair.getValue();
            String name = pair.getKey();
            Calendar calendar = new GregorianCalendar();
            calendar.setTime(date);
            try {
                if(calendar.get(Calendar.MONTH) >=5 && calendar.get(Calendar.MONTH)<=7){
                    iter.remove();
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    public static void main(String[] args) throws ParseException {
        HashMap<String, Date> map = createMap();
        removeAllSummerPeople(map);

    }
}
