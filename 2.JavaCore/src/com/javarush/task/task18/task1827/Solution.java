package com.javarush.task.task18.task1827;

/* 
Прайсы
*/

import java.io.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Solution {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String fileName = br.readLine();
        br.close();
        BufferedReader reader = new BufferedReader(new FileReader(fileName));
        FileOutputStream fos = new FileOutputStream(fileName,true);

        if (args.length != 0) {
            String line;
            int maxID = 0;
            String idRegex = "(\\d){8}";
            Pattern pattern = Pattern.compile(idRegex);
            if (args[0].equals("-c")) {
                while ((line = reader.readLine()) != null) {
                    Matcher matcher = pattern.matcher(line);
                    while (matcher.find()) {
                        if (maxID <= Integer.parseInt(matcher.group())) {
                            maxID = Integer.parseInt(matcher.group()) + 1;
                        }
                    }
                }
                fos.write(String.format("\n%-8s%-30s%-8s%-4s",maxID,args[1],args[2],args[3]).getBytes());
            }
            reader.close();
            fos.close();
        }
    }
}
