package Aut.Ap.Workshop10.src;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.Scanner;

public class Client implements Runnable {

    private Socket client;
    private BufferedReader input;
    private PrintWriter output;

    @Override
    public void run() {
        try {
            client = new Socket("localhost", 7500);
            output = new PrintWriter(client.getOutputStream(), true);
            input = new BufferedReader(new InputStreamReader(client.getInputStream()));

            InputHandler inputHandler = new InputHandler();
            Thread once = new Thread(inputHandler);
            once.start();

            String inputMessage;
            while ((inputMessage = input.readLine()) != null)
                System.out.println(inputMessage);

        } catch (IOException e) {
            System.out.println("Something went wrong!");
            shutdown();
        }
    }

    public void shutdown() {
        try {
            input.close();
            output.close();
            if (!client.isClosed())
                client.close();
        } catch (IOException ignore) {
        }
        System.exit(0);
    }

    class InputHandler implements Runnable {

        @Override
        public void run() {
            try {
                Scanner scanner = new Scanner(System.in);

                while (true) {
                    String message = null;
                    while (message == null || message.trim().isEmpty())
                        message = scanner.nextLine();

                    output.println(message);
                    if (message.equals("$quit"))
                        break;
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
            shutdown();
        }
    }

    public static void main(String[] args) {
        Client client = new Client();
        client.run();
    }
}
