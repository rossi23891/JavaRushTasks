package com.javarush.task.task19.task1918;

/* 
Знакомство с тегами
*/

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.parser.Parser;
import org.jsoup.select.Elements;


public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String fileName = br.readLine();
        br.close();
        FileReader reader = new FileReader(fileName);
        StringBuilder sb = new StringBuilder();
        while (reader.ready()){
            sb.append((char)reader.read());
        }
        String text = sb.toString();
        reader.close();
        Document doc = Jsoup.parse(text,"", Parser.xmlParser());
        Elements elem = doc.select(args[0]);
        for(Element element:elem){
            System.out.println(element);
        }

    }
}
