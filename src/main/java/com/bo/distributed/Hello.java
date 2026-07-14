package com.bo.distributed;

import java.rmi.*;
public interface Hello extends Remote {
  // Must throw RemoteException
  String sayHello() throws RemoteException;
}