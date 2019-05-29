package com.javarush.task.task30.task3008;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class ConsoleHelper {
    private static BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

    public static void writeMessage(String message){
        System.out.println(message);
    }

    public static String readString(){
        String text=null;
        while (true){
            try {
                text = reader.readLine();
                break;
            }catch (IOException e){
                writeMessage("Произошла ошибка при попытке ввода текста. Попробуйте еще раз.");
            }
        }
        return text;
    }

    public static int readInt(){
        int number=0;
        while(true){
            try{
                number = Integer.parseInt(readString());
                break;
            }catch (NumberFormatException e){
                writeMessage("Произошла ошибка\n" +
                        "при попытке ввода числа. Попробуйте еще раз.");
            }
        }

        return number;
    }
}
