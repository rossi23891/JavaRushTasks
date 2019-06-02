package com.javarush.task.task30.task3008;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public class Server {

    private static Map<String, Connection> connectionMap = new ConcurrentHashMap<>();//key - client name, val - connection with this client

    private static class Handler extends Thread {
        Socket socket;

        public Handler(Socket socket) {
            this.socket = socket;
        }

        private String serverHandshake(Connection connection) throws IOException, ClassNotFoundException { // подключиться к чату
            String username;
            connection.send(new Message(MessageType.NAME_REQUEST, "Hi, who are you?"));
            while (true) {
                Message message = connection.receive();
                username = message.getData();
                if (message.getType() == MessageType.USER_NAME && !username.equals("") && !connectionMap.containsKey(username)) {
                    connectionMap.put(username, connection);
                    connection.send(new Message(MessageType.NAME_ACCEPTED, "You're welcome!"));
                    return username;
                } else {
                    connection.send(new Message(MessageType.NAME_REQUEST, "Hi, who are you? Please, enter your name again"));
                }
            }
        }

        private void notifyUsers(Connection connection, String userName) throws IOException {// оповещать нового участника об остальных участниках чата
            for (String user : connectionMap.keySet()) {
                if (!user.equals(userName)) {
                    connection.send(new Message(MessageType.USER_ADDED, user));
                }
            }
        }

        private void serverMainLoop(Connection connection, String userName) throws IOException, ClassNotFoundException {// обработка сообщений сервером
            while (true) {
                Message message = connection.receive();
                if (message.getType() == MessageType.TEXT) {
                    sendBroadcastMessage(new Message(MessageType.TEXT, userName + ": " + message.getData()));
                } else {
                    ConsoleHelper.writeMessage("Error");
                }
            }
        }

        @Override
        public void run() {

            String userName = null;
            ConsoleHelper.writeMessage("New address was connected" + socket.getRemoteSocketAddress());
            try (Connection connection = new Connection(socket)){
                userName = serverHandshake(connection);
                sendBroadcastMessage(new Message(MessageType.USER_ADDED, userName));
                notifyUsers(connection, userName);
                serverMainLoop(connection, userName);
            } catch (IOException |ClassNotFoundException e) {
                ConsoleHelper.writeMessage("Data exchange error");
                e.printStackTrace();
            }
            if(userName!=null){
                connectionMap.remove(userName);
                sendBroadcastMessage(new Message(MessageType.USER_REMOVED, userName));
            }

            ConsoleHelper.writeMessage("Remote address was connected" + socket.getRemoteSocketAddress()+ "закрыто");
        }
    }

    public static void main(String[] args) throws IOException {
        ServerSocket serverSocket = new ServerSocket(ConsoleHelper.readInt());
        ConsoleHelper.writeMessage("Server has been started");
        try {
            while (true) {
                Socket clientSocket = serverSocket.accept();
                new Handler(clientSocket).start();
            }
        } catch (IOException e) {
            serverSocket.close();
        }
    }

    public static void sendBroadcastMessage(Message message) {// оповещать всех участников, отправлять сообщения
        for (Connection connection : connectionMap.values()) {
            try {
                connection.send(message);
            } catch (IOException e) {
                System.out.println("Message is not sent");
            }
        }
    }
}

