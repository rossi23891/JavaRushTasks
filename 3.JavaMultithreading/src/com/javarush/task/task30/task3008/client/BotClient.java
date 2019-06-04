package com.javarush.task.task30.task3008.client;

import com.javarush.task.task30.task3008.ConsoleHelper;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.GregorianCalendar;


public class BotClient extends Client {
    public class BotSocketThread extends SocketThread{
        @Override
        protected void processIncomingMessage(String message) {
            ConsoleHelper.writeMessage(message);
            if(message.contains(":")){
                String username = message.split(":")[0].trim();
                String text = message.split(":")[1].trim();
                Date currentDate = new GregorianCalendar().getTime();
                SimpleDateFormat simpleDateFormat=null;
                if(text.equals("дата")){
                    simpleDateFormat = new SimpleDateFormat("d.MM.YYYY");
                } else if(text.equals("день")){
                    simpleDateFormat = new SimpleDateFormat("d");
                }else if(text.equals("месяц")){
                    simpleDateFormat = new SimpleDateFormat("MMMM");
                }else if(text.equals("год")){
                    simpleDateFormat = new SimpleDateFormat("YYYY");
                }else if(text.equals("время")){
                    simpleDateFormat = new SimpleDateFormat("H:mm:ss");
                }else if(text.equals("час")){
                    simpleDateFormat = new SimpleDateFormat("H");
                }else if(text.equals("минуты")){
                    simpleDateFormat = new SimpleDateFormat("m");
                }else if(text.equals("секунды")){
                    simpleDateFormat = new SimpleDateFormat("s");
                }else{
                    return;
                }
                sendTextMessage("Информация для " + username + ": " + simpleDateFormat.format(currentDate));
            }else{
                return;
            }
        }

        @Override
        protected void clientMainLoop() throws IOException, ClassNotFoundException {
            sendTextMessage("Привет чатику. Я бот. Понимаю команды: дата, день, месяц, год, время, час, минуты, секунды.");
            super.clientMainLoop();
        }
    }

    @Override
    protected SocketThread getSocketThread() {
        return new BotSocketThread();
    }

    @Override
    protected String getUserName() {
        return "date_bot_" + (int)(Math.random()*100);
    }

    @Override
    protected boolean shouldSendTextFromConsole() {
        return false;
    }

    public static void main(String[] args) {
        new BotClient().run();
    }
}
