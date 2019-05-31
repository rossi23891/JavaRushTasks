package com.javarush.task.task30.task3008;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public class Server {

    private static Map<String, Connection> connectionMap = new ConcurrentHashMap<>();//key - client name, val - connection with this client

    private static class Handler extends Thread {
        Socket socket;

        public Handler(Socket socket) {
            this.socket = socket;
        }

        private String serverHandshake(Connection connection) throws IOException, ClassNotFoundException {
            String username;
            connection.send(new Message(MessageType.NAME_REQUEST, "Hi, who are you?"));
            while (true){
                Message message = connection.receive();
                username=message.getData();
                if (message.getType()==MessageType.USER_NAME && !username.equals("")&& !connectionMap.containsKey(username)) {
                    connectionMap.put(username, connection);
                    connection.send(new Message(MessageType.NAME_ACCEPTED,"You're welcome!"));
                    return username;
                }else{
                    connection.send(new Message(MessageType.NAME_REQUEST, "Hi, who are you? Please, enter your name again"));
                }
            }
        }

        private void notifyUsers(Connection connection, String userName) throws IOException{
            for(String user: connectionMap.keySet()){
                if(!user.equals(userName)){
                    connection.send(new Message(MessageType.USER_ADDED,user));
                }
            }
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

    public static void sendBroadcastMessage(Message message) {
        for (Connection connection : connectionMap.values()) {
            try {
                connection.send(message);
            } catch (IOException e) {
                System.out.println("Сообщение не отправлено");
            }
        }
    }
}

