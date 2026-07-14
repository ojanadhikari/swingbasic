package com.bo.socketprog.chat;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;

public class Client {
    public static void main(String[] args) {
        String serverHost = "localhost";
        int serverPort = 8888;

        try(Socket s = new Socket(serverHost, serverPort)) {
            System.out.println("Client connected , Please type exit to quit.");

            PrintWriter out = new PrintWriter(s.getOutputStream(), true);
            BufferedReader in = new BufferedReader(new InputStreamReader(s.getInputStream()));
            BufferedReader consoleInput = new BufferedReader(new InputStreamReader(System.in));

            String serverMessage , clientMessage;;

            while (true) {

                System.out.print("Client: ");
                clientMessage = consoleInput.readLine();

                out.println(clientMessage);

                if (clientMessage.equalsIgnoreCase("exit")) {
                    System.out.println("Client disconnected.");
                    break;
                }

                serverMessage = in.readLine();

                if (serverMessage == null || serverMessage.equalsIgnoreCase("exit")) {
                    System.out.println("Server disconnected.");
                    break;
                }

                System.out.println("Server: " + serverMessage);
            }

        }catch(Exception e) {
            System.out.println("Error occurred"+e.getMessage());
        }
    }
}
