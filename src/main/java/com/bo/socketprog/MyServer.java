package com.bo.socketprog;

import java.io.*;
import java.net.*;

public class MyServer {
 public static void main(String[] args) {
  try {
   ServerSocket ss = new ServerSocket(6666);
   System.out.println("Waiting...");
   Socket s = ss.accept(); // Wait for client
   
   DataInputStream dis = new DataInputStream(s.getInputStream());
   String str = (String)dis.readUTF();
   System.out.println("Client says: " + str);
   
   ss.close();
  } catch(Exception e){ System.out.println(e); }
 }
}