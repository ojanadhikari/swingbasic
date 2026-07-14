package com.bo.distributed;

import java.rmi.*;
import java.rmi.registry.*;

public class Server {
    public static void main(String args[]) {
        try {

            LocateRegistry.createRegistry(1099);

            // 1. Create remote object
            Hello stub = new HelloImpl();
            // 2. Bind the stub in the registry
            Naming.rebind("rmi://localhost/hello", stub);
            System.out.println("Server is ready.");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}