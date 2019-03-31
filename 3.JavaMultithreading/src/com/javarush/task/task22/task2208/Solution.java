package com.javarush.task.task22.task2208;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.TreeMap;

/* 
Формируем WHERE
*/
public class Solution {
    public static void main(String[] args) {
        Map<String,String> params = new LinkedHashMap<>();
        params.put("name","Ivanov");
        params.put("country","Ukraine");
        params.put("city","Kiev");
        params.put("age",null);
        System.out.println(getQuery(params));
    }
    public static String getQuery(Map<String, String> params) {
        StringBuilder sb = new StringBuilder();
        for (Map.Entry<String,String> pair: params.entrySet()){
            String key = pair.getKey();
            String value = pair.getValue();
            if(value!=null){
                sb.append(key);
                sb.append(" = '");
                sb.append(value);
                sb.append("' and ");
            }
        }

        return sb.toString();
    }
}
