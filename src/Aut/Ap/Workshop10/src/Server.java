package Aut.Ap.Workshop10.src;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;

public class Server implements Runnable {

    ServerSocket serverSocket;
    private boolean accept;
    private final String chatroomName;
    private final ArrayList<ControlHandler> connectedClients;

    public Server(String name) {
        accept = true;
        chatroomName = name;
        connectedClients = new ArrayList<>();
    }

    public void broadCast(String message, ControlHandler exception) {
        for (ControlHandler x : connectedClients) {
            if (x != null && x != exception)
                x.pWriter.println(message);
        }
    }

    public void shutdown() {
        accept = false;
        try {
            serverSocket.close();
            for (ControlHandler x :
                    connectedClients) {
                x.shutdown();
            }
        } catch (Exception ignore) {
        }
    }

    @Override
    public void run() {
        try {
            serverSocket = new ServerSocket(7500);
            System.out.println(chatroomName + " is running...");

            while (accept) {
                Socket client = serverSocket.accept();

                ControlHandler newClient = new ControlHandler(client);
                connectedClients.add(newClient);
                new Thread(newClient).start();
            }
        } catch (IOException e) {
            e.printStackTrace();
            shutdown();
        }
    }


    class ControlHandler implements Runnable {
        private final Socket client;
        private BufferedReader bReader;
        private PrintWriter pWriter;
        private final String color;

        private String nickName;

        ControlHandler(Socket client) {
            this.client = client;
            color = Colors.generateColor();
        }

        public void run() {

            try {
                bReader = new BufferedReader(new InputStreamReader(client.getInputStream()));
                pWriter = new PrintWriter(client.getOutputStream(), true);
                pWriter.println("Hello and Welcome to the " + chatroomName);
                pWriter.println("Please enter your name: ");
                nickName = bReader.readLine();

                if (nickName != null) {
                    pWriter.println(Colors.setColor("Hello " + nickName, color));
                    String join = Colors.setColor(nickName + " connected to " + chatroomName, color);
                    System.out.println(join);
                    broadCast(join, this);

                    //HERE IS WHERE THE CLIENTS START PROCESSING:
                    String chatMessage;
                    while ((chatMessage = bReader.readLine()) != null) {
                        if (chatMessage.equals("$quit")) {
                            break;
                        } else if (chatMessage.startsWith("$Nick ")) {
                            String[] m = chatMessage.split(" ", 2);
                            if (m.length == 2) {
                                broadCast(Colors.setColor(nickName + " changed it's name to: " + m[1], color), this);
                                nickName = m[1];
                            } else
                                pWriter.println("No NickName Provided!");
                        } else {
                            broadCast(Colors.setColor(nickName + ": " + chatMessage, color), this);
                        }
                    }
                }
            } catch (IOException ignore) {
            }
            if (nickName != null) {
                String left = Colors.setColor(nickName + " left the " + chatroomName, color);
                System.out.println(left);
                broadCast(left, this);
            }
            shutdown();
        }

        public void shutdown() {
            try {
                pWriter.close();
                bReader.close();
                client.close();
            } catch (IOException ignore) {
            }

        }
    }

    public static void main(String[] args) {
        Server server = new Server("AUT-CE-ChatRoom");
        server.run();
    }
}
