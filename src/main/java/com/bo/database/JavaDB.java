package com.bo.database;


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.sql.PreparedStatement;

public class JavaDB {
    public static void main(String[] args) {
        try {
            //Initialize Driver
            Class.forName("com.mysql.jdbc.Driver");
            //Initialize Connection
            Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/student", "root", "root");
            //Initialize statement
            Statement statement = connection.createStatement();
            //Execute statement
            ResultSet resultSet = statement.executeQuery("select * from student");
                //executeQuery for select and executeUpdate for update insert and delte
                statement.executeUpdate("insert into student(name) values('Ram','Shyam','Gita')");
                statement.executeUpdate("update student set name = 'Sam' where name = 'Shyam'");
                statement.executeUpdate("delete from student where name = 'Gita'");
            //Printing result
            printResult(resultSet);
            //Initialize preparedStatement
            PreparedStatement preparedStatement = connection.prepareStatement("insert into student(name,age) values(?,?)");
            preparedStatement.setString(1, "Ram");
            preparedStatement.setInt(2, 20);
            //Execute preparedStatement for insert
            preparedStatement.executeUpdate();
            //Execute preparedStatement for select
            ResultSet resultSet1 =  connection.prepareStatement("select * from student").executeQuery();
            //Printing result again
            printResult(resultSet1);
        }catch (Exception e) {
            System.out.println("Exception occured: " + e.getMessage());
        }
    }

    private static void printResult(ResultSet resultSet){
        try {
            while (resultSet.next()) {
                int id = resultSet.getInt("id");
                String name = resultSet.getString("name");
                int age = resultSet.getInt("age");
                System.out.println(id + " " + name + " " + age);
            }
        }catch (Exception e) {
            System.out.println("Exception occurred: " + e.getMessage());
        }
    }
}
