package com.bo.socketprog;

import java.net.*;

public class UDPSender {
 public static void main(String[] args) throws Exception {
  DatagramSocket ds = new DatagramSocket();
  String str = "UDP Message";
  InetAddress ip = InetAddress.getByName("127.0.0.1");
  
  DatagramPacket dp = new DatagramPacket(
     str.getBytes(), str.length(), ip, 3000);
  
  ds.send(dp);
  ds.close();
 }
}