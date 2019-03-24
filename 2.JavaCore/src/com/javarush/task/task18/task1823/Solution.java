package com.javarush.task.task18.task1823;

import java.io.*;
import java.util.*;

/* 
Нити и байты
*/

public class Solution {
    public static Map<String, Integer> resultMap = new HashMap<String, Integer>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String fileName;
        while (!(fileName = br.readLine()).equals("exit")){
            new ReadThread(fileName).start();
        }
        br.close();
    }

    public static class ReadThread extends Thread {
        String fileName;
        int maxbyte=0;
        public ReadThread(String fileName) {
            //implement constructor body
            this.fileName = fileName;
        }
        // implement file reading here - реализуйте чтение из файла тут
        @Override
        public void run() {
            Map<Integer,Integer> frequency = new HashMap<>();
            try {
                FileInputStream fileInputStream = new FileInputStream(fileName);
                while (fileInputStream.available()>0){
                    int data = fileInputStream.read();
                    if(!frequency.containsKey(data)){
                        frequency.put(data,1);
                    }else{
                        frequency.put(data,frequency.get(data)+1);
                    }
                }
                fileInputStream.close();
            }catch (IOException e){
                e.printStackTrace();
            }
            Iterator<Map.Entry<Integer,Integer>> iterator = frequency.entrySet().iterator();
            int max = 0;
            while(iterator.hasNext()){
                Map.Entry<Integer,Integer> pair = iterator.next();
                if(pair.getValue()>max){
                    max=pair.getValue();
                    maxbyte = pair.getKey();
                }
            }
            synchronized (resultMap){
                resultMap.put(fileName,maxbyte);
            }
        }
    }
}
