package com.bo.socketprog.chat;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;

public class Server {

    public static void main(String[] args) {
        int port = 8888;
        String exitMessage = "exit";
        try(ServerSocket ss = new ServerSocket(port)) {
            System.out.println("Server started on port " + port);

            Socket s = ss.accept();
            System.out.println("Client connected, Please type 'exit' to exit");

            BufferedReader in = new BufferedReader(new InputStreamReader(s.getInputStream()));
            PrintWriter out = new PrintWriter(s.getOutputStream(), true);
            BufferedReader consoleInput = new BufferedReader(new InputStreamReader(System.in));

            String clientMessage, serverMessage;

            while(true) {

                //read from client
                clientMessage = in.readLine();

                if(clientMessage == null || exitMessage.equals(clientMessage)) {
                    System.out.println("Client disconnected");
                    break;
                }

                System.out.println("Client: " + clientMessage);

                //send reply
                System.out.print("Server: ");
                serverMessage = consoleInput.readLine();
                out.println(serverMessage);

                if(serverMessage.equals(exitMessage)) {
                    System.out.println("Server exited");
                    break;
                }

                s.close();
            }

        }catch(Exception e) {
            System.out.println("Error occurred"+e.getMessage());
        }
    }
}
