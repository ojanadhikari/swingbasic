package com.bo.projectguidb;

import java.sql.*;

public class DbConn {
    private static String host = "localhost";
    private static String port = "3306";
    private static String user = "root";
    private static String pass = "root";
    private static String db = "college";


    public static Connection connectDb(){
        try{
            Class.forName("com.mysql.cj.jdbc.Driver");
            String jdbcUrl = "jdbc:mysql://" + host + ":" + port + "/" + db;
            Connection conn = DriverManager.getConnection(jdbcUrl, user, pass);
            System.out.println("Connected to database");
            return conn;
        }catch(Exception e){
            throw new RuntimeException(e);
        }
    }



}
