package com.javarush.task.task26.task2613;

import com.javarush.task.task26.task2613.exception.InterruptOperationException;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ResourceBundle;

public class ConsoleHelper {
    private static BufferedReader bis = new BufferedReader(new InputStreamReader(System.in));
    private static ResourceBundle res = ResourceBundle.getBundle(CashMachine.RESOURCE_PATH + "common_en");

    public static void writeMessage(String message) {
        System.out.println(message);
    }

    public static String readString() throws InterruptOperationException {
        String s = null;
        try {
            s = bis.readLine();
            if(s.equalsIgnoreCase("exit")){
                throw new InterruptOperationException();
            }
        } catch (IOException e) {
        }
        return s;
    }

    public static String askCurrencyCode() throws InterruptOperationException {
        String outputCurrency;
        while (true) {
            writeMessage(res.getString("choose.currency.code"));
            String enteredCurrency = readString();
            if (enteredCurrency.length() == 3) {
                outputCurrency = enteredCurrency.toUpperCase();
                return outputCurrency;
            }
        }
    }

    public static String[] getValidTwoDigits(String currencyCode) throws InterruptOperationException {
        int nominal;
        int quantity;
        while (true) {
            writeMessage(res.getString("choose.denomination.and.count.format"));
            String[] enrty = readString().split(" ");
            if (enrty.length == 2) {
                String nom = enrty[0];
                String number = enrty[1];
                try {
                    nominal = Integer.parseInt(nom);
                    quantity = Integer.parseInt(number);
                    if (nominal > 0 && quantity > 0) {
                        return enrty;
                    }
                } catch (Exception e) {
                    writeMessage(res.getString("invalid.data"));
                }
            }
        }

    }

    public static Operation askOperation() throws InterruptOperationException {
        while (true) {
            writeMessage(res.getString("choose.operation"));
            writeMessage( " 1 - " + res.getString("operation.INFO"));
            writeMessage( " 2 - " + res.getString("operation.DEPOSIT"));
            writeMessage( " 3 - " + res.getString("operation.WITHDRAW"));
            writeMessage( " 4 - " + res.getString("operation.EXIT"));
            int operationNumber;
                operationNumber = Integer.parseInt(readString());
                return Operation.getAllowableOperationByOrdinal(operationNumber);
        }
    }

    public static void printExitMessage() {
        writeMessage(res.getString("the.end"));
    }

}
