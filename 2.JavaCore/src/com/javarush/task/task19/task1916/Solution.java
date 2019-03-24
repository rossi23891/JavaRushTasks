package com.javarush.task.task19.task1916;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* 
Отслеживаем изменения
*/

public class Solution {
    public static List<LineItem> lines = new ArrayList<LineItem>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String file1 = br.readLine();
        String file2 = br.readLine();
        br.close();
        ArrayList<String>lines1 = new ArrayList<>();
        ArrayList<String>lines2 = new ArrayList<>();
        try (BufferedReader reader1 = new BufferedReader(new FileReader(file1))){
            String line1;
            while (reader1.ready()){
                line1 = reader1.readLine();
                lines1.add(line1);
            }
        }
         try(BufferedReader reader2 = new BufferedReader(new FileReader(file2))){
             String line2;
             while (reader2.ready()){
                 line2 = reader2.readLine();
                 lines2.add(line2);
             }
         }
        Iterator<String> iter1 = lines1.iterator();
        Iterator<String> iter2 = lines2.iterator();
        String a=iter1.next();
        String b=iter2.next();
        while(iter1.hasNext()&& iter2.hasNext()) {
            if(a.equals(b)){
                lines.add(new LineItem(Type.SAME,a));
                a=iter1.next();
                b=iter2.next();
            }else {
                if(!lines2.contains(a)){
                    lines.add(new LineItem(Type.REMOVED,a));
                    a=iter1.next();
                }else if(!lines1.contains(b)){
                    lines.add(new LineItem(Type.ADDED,b));
                    b=iter2.next();
                }
            }
        }
        if(iter2.hasNext()){
            lines.add(new LineItem(Type.SAME,a));
            while (iter2.hasNext()){
                lines.add(new LineItem(Type.ADDED,iter2.next()));
            }
        }
        if(iter1.hasNext()){
            lines.add(new LineItem(Type.SAME,b));
            while (iter1.hasNext()){
                lines.add(new LineItem(Type.REMOVED,iter1.next()));
            }
        }

    }


    public static enum Type {
        ADDED,        //добавлена новая строка
        REMOVED,      //удалена строка
        SAME          //без изменений
    }

    public static class LineItem {
        public Type type;
        public String line;

        public LineItem(Type type, String line) {
            this.type = type;
            this.line = line;
        }
    }
}
