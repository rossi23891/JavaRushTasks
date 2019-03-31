package com.javarush.task.task22.task2208;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;


/* 
Формируем WHERE
*/
public class Solution {
    public static void main(String[] args) {
        Map<String,String> params = new LinkedHashMap<>();
        params.put("name",null);
        params.put("country",null);
        params.put("city",null);
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
        if(!sb.toString().equals("")){
            int i = sb.lastIndexOf(" and ");
            sb.replace(i,sb.length(),"");
        }
        return sb.toString();
    }
}
