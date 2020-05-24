package com.javarush.task.task26.task2613.command;

import com.javarush.task.task26.task2613.CashMachine;
import com.javarush.task.task26.task2613.ConsoleHelper;
import com.javarush.task.task26.task2613.CurrencyManipulator;
import com.javarush.task.task26.task2613.CurrencyManipulatorFactory;
import com.javarush.task.task26.task2613.exception.InterruptOperationException;
import com.javarush.task.task26.task2613.exception.NotEnoughMoneyException;

import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

class WithdrawCommand implements Command {
    private ResourceBundle res = ResourceBundle.getBundle(CashMachine.RESOURCE_PATH + "withdraw_en");

    @Override
    public void execute() throws InterruptOperationException {
        ConsoleHelper.writeMessage(res.getString("before"));
        String currencyCode = ConsoleHelper.askCurrencyCode();
        Pattern pattern = Pattern.compile("\\d+");
        CurrencyManipulator currencyManipulator = CurrencyManipulatorFactory.getManipulatorByCurrencyCode(currencyCode);
        while (true) {
            ConsoleHelper.writeMessage(res.getString("specify.amount"));
            String amount = ConsoleHelper.readString();
            Matcher matcher = pattern.matcher(amount);
            if (!matcher.matches()) {
                ConsoleHelper.writeMessage(res.getString("specify.not.empty.amount"));
            } else {
                int neededAmount = Integer.parseInt(amount);
                if (!currencyManipulator.isAmountAvailable(neededAmount)) {
                    ConsoleHelper.writeMessage(res.getString("not.enough.money"));
                } else {
                    Map<Integer, Integer> withdrawAmount = null;
                    try {
                        withdrawAmount = currencyManipulator.withdrawAmount(neededAmount);
                        ConsoleHelper.writeMessage(String.format(res.getString("success.format"),amount,currencyCode));
                    } catch (NotEnoughMoneyException e) {
                        ConsoleHelper.writeMessage(res.getString("exact.amount.not.available"));
                    }
                    break;
                }
            }
        }
    }
}
