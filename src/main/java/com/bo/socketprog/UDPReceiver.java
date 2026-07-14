package com.bo.socketprog;

import java.net.*;

public class UDPReceiver {
 public static void main(String[] args) throws Exception {
  DatagramSocket ds = new DatagramSocket(3000);
  byte[] buf = new byte[1024];
  
  DatagramPacket dp = new DatagramPacket(buf, 1024);
  ds.receive(dp); // Wait for packet
  
  String str = new String(dp.getData(), 0, dp.getLength());
  System.out.println("Received: " + str);
  ds.close();
 }
}