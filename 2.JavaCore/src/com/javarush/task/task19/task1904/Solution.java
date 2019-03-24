package com.javarush.task.task19.task1904;

import java.io.IOException;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

/* 
И еще один адаптер
*/

public class Solution {

    public static void main(String[] args) throws IOException {
        PersonScannerAdapter personScannerAdapter = new
                PersonScannerAdapter(new  Scanner(System.in));
        Person person = personScannerAdapter.read();
        System.out.println(person);
  }

    public static class PersonScannerAdapter implements PersonScanner {
         private final Scanner fileScanner;

        public PersonScannerAdapter(Scanner fileScanner) {
            this.fileScanner = fileScanner;
        }

        @Override
        public Person read() throws IOException{
            String[] persData = fileScanner.nextLine().split(" ");
            String date = persData[3]+" " + persData[4]+ " " +persData[5];
            DateFormat format = new SimpleDateFormat("dd MM yyyy");
            Date birthDate = null;
            try {
                birthDate = format.parse(date);
            } catch (ParseException e) {
                e.printStackTrace();
            }
            return new Person(persData[1],persData[2],persData[0],birthDate);
        }

        @Override
        public void close() throws IOException {
            fileScanner.close();
        }
    }
}
