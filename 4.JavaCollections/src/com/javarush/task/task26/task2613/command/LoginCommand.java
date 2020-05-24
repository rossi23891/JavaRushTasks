package com.javarush.task.task26.task2613.command;

import com.javarush.task.task26.task2613.CashMachine;
import com.javarush.task.task26.task2613.ConsoleHelper;
import com.javarush.task.task26.task2613.exception.InterruptOperationException;

import java.util.ResourceBundle;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class LoginCommand implements Command {
    private ResourceBundle validCreditCards = ResourceBundle.getBundle(CashMachine.RESOURCE_PATH + "verifiedCards");
    private ResourceBundle res = ResourceBundle.getBundle(CashMachine.RESOURCE_PATH + "login_en");

    static Pattern cardPattern = Pattern.compile("\\d{12}");
    static Pattern pinPattern = Pattern.compile("\\d{4}");

    @Override
    public void execute() throws InterruptOperationException {
        ConsoleHelper.writeMessage(res.getString("before"));
        String card;
        String pin;
        while (true) {
            ConsoleHelper.writeMessage(res.getString("specify.data"));
            card = ConsoleHelper.readString();
            pin = ConsoleHelper.readString();
            Matcher cardMartcher = cardPattern.matcher(card);
            Matcher pinMartcher = pinPattern.matcher(pin);
            if (cardMartcher.matches() && pinMartcher.matches()) {
                if (validCreditCards.containsKey(card)) {
                    if (validCreditCards.getString(card).equals(pin)) {
                        ConsoleHelper.writeMessage(res.getString("success.format"));
                        break;
                    }
                    ConsoleHelper.writeMessage(res.getString("not.verified.format"));
                }
                ConsoleHelper.writeMessage(res.getString("try.again.with.details"));
            } else {
                ConsoleHelper.writeMessage(res.getString("try.again.or.exit"));
            }
        }
    }
}
