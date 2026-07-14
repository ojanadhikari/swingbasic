package com.bo.distributed;

import java.rmi.RemoteException;
import java.rmi.server.*;

public class HelloImpl extends UnicastRemoteObject implements Hello {
  protected HelloImpl() throws RemoteException {
    super(); 
  }
  public String sayHello() { 
    return "Welcome to RMI!"; 
  }
}