package com.javarush.task.task20.task2003;

import java.io.*;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;

/* 
Знакомство с properties
*/
public class Solution {
    public static Map<String, String> properties = new HashMap<>();
    Properties prop = new Properties();

    public void fillInPropertiesMap() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String file = br.readLine();
        br.close();
        FileInputStream fis;
        try{
            fis = new FileInputStream(file);
            load(fis);
        }catch(Exception e){
            e.printStackTrace();
        }
        //implement this method - реализуйте этот метод
    }

    public void save(OutputStream outputStream) throws Exception {
        //implement this method - реализуйте этот метод
        for(Map.Entry<String,String> pairs: properties.entrySet()){
            String key = pairs.getKey();
            String value = pairs.getValue();
            prop.setProperty(key,value);
        }
        prop.store(outputStream,"");
    }

    public void load(InputStream inputStream) throws Exception {
        //implement this method - реализуйте этот метод
        prop.load(inputStream);
            for(String key:prop.stringPropertyNames()){
                properties.put(key,prop.getProperty(key));
            }
    }

    public static void main(String[] args) {

    }
}
