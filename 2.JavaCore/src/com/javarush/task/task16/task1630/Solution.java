package com.javarush.task.task16.task1630;

import java.io.*;

public class Solution {
    public static String firstFileName;
    public static String secondFileName;

    //add your code here - добавьте код тут
    static {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        try {
            firstFileName = br.readLine();
            secondFileName = br.readLine();
            br.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) throws InterruptedException {
        systemOutPrintln(firstFileName);
        systemOutPrintln(secondFileName);
    }

    public static class ReadFileThread extends Thread implements ReadFileInterface{
        String fullFileName;
        StringBuilder sb =  new StringBuilder();
        @Override
        public void setFileName(String fullFileName) {
            this.fullFileName = fullFileName;
        }

        @Override
        public String getFileContent() {
            return sb.toString();
        }

        @Override
        public void run() {
            try {
                BufferedReader fileReader = new BufferedReader(new FileReader(fullFileName));
                String line;

                while ((line = fileReader.readLine())!=null){
                    sb.append(line);
                    sb.append(" ");
                }
                fileReader.close();
            } catch (IOException e) {
            }

        }
    }

    public static void systemOutPrintln(String fileName) throws InterruptedException {
        ReadFileInterface f = new ReadFileThread();
        f.setFileName(fileName);
        f.start();
        f.join();
        //add your code here - добавьте код тут
        System.out.println(f.getFileContent());
    }

    public interface ReadFileInterface {

        void setFileName(String fullFileName);

        String getFileContent();

        void join() throws InterruptedException;

        void start();
    }

    //add your code here - добавьте код тут
}
