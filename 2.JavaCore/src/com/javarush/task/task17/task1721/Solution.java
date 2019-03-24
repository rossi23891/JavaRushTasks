package com.javarush.task.task17.task1721;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

/* 
Транзакционность
*/

public class Solution {
    public static List<String> allLines = new ArrayList<String>();
    public static List<String> forRemoveLines = new ArrayList<String>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        try{
            String fileName1 = br.readLine();
            String fileName2 = br.readLine();
            BufferedReader fileReader1 = new BufferedReader(new FileReader(fileName1));
            BufferedReader fileReader2 = new BufferedReader(new FileReader(fileName2));
            String line;
            String removedLine;
            while ((line=fileReader1.readLine())!=null){
                allLines.add(line);
            }
            while ((removedLine=fileReader2.readLine())!=null){
                forRemoveLines.add(removedLine);
            }
            br.close();
            fileReader1.close();
            fileReader2.close();
            Solution solution = new Solution();
            solution.joinData();
        } catch (Exception e){
            e.printStackTrace();
        }
    }

    public void joinData() throws CorruptedDataException {
        if(allLines.containsAll(forRemoveLines)){
            allLines.removeAll(forRemoveLines);
        }else{
            allLines.clear();
            throw new CorruptedDataException();
        }
    }
}
