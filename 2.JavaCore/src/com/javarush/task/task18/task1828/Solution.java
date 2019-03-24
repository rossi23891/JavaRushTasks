package com.javarush.task.task18.task1828;

/* 
Прайсы 2
*/

import java.io.*;
import java.util.ArrayList;
import java.util.Iterator;


public class Solution {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String fileName = br.readLine();
        br.close();
        if(args.length==0){
            return;
        }
        ArrayList<String> lines = new ArrayList<>();
        try(BufferedReader reader = new BufferedReader(new FileReader(fileName))){
            String line;
            while ((line = reader.readLine()) != null) {
                lines.add(line);
            }
        }
        if (args[0].equals("-u")) {
            changeLine(lines,args[1],args[2],args[3],args[4]);
        } else if (args[0].equals("-d")) {
           deleteLine(lines,args[1]);
        }
        try(PrintWriter writer = new PrintWriter(new FileWriter(fileName))){
            for (String s : lines) {
                writer.println(s);
            }
        }
    }

    public static void changeLine(ArrayList<String> list,String id,String prName,String price, String quantity){
        String listID;
        String newLine;
        for (int i = 0; i <list.size(); i++) {
            listID=list.get(i).substring(0,8).trim();
            if(listID.equals(id)){
                newLine=String.format("%-8s%-30s%-8s%-4s", id, prName,price,quantity);
                list.set(i,newLine);
            }
        }
    }

    public static void deleteLine(ArrayList<String> list,String id){
        String listID;
        Iterator<String> iter = list.iterator();
            while (iter.hasNext()) {
                String l = iter.next();
                listID=l.substring(0,8).trim();
                if(listID.equals(id)){
                    iter.remove();
                }
            }
    }
}
