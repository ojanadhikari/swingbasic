package com.bo.distributed;

import java.rmi.*;

public class Client {
  public static void main(String args[]) {
    try {
      // 1. Lookup the remote object
      Hello access = (Hello)Naming.lookup("rmi://localhost/hello");
      // 2. Invoke method
      System.out.println(access.sayHello());
    } catch (Exception e) { e.printStackTrace(); }
  }
}