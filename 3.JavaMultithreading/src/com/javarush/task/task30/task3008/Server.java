package com.javarush.task.task30.task3008;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public class Server {

    private static Map<String,Connection> connectionMap = new ConcurrentHashMap<>();//key - client name, val - connection with this client

    private static class Handler extends Thread {
        Socket socket;

        public Handler(Socket socket) {
            this.socket = socket;
        }
    }

    public static void main(String[] args) throws IOException {
        ServerSocket serverSocket = new ServerSocket(ConsoleHelper.readInt());
        ConsoleHelper.writeMessage("Сервер запущен");
        try {
            while (true) {
                Socket clientSocket = serverSocket.accept();
                new Handler(clientSocket).start();
            }
        } catch (IOException e) {
            serverSocket.close();
        }
    }
    public static void sendBroadcastMessage(Message message){
            for(Connection connection: connectionMap.values()){
                try {
                    connection.send(message);
                } catch (IOException e) {
                    System.out.println("Сообщение не отправлено");
                }
            }
    }
}

