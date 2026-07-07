package com.bo.projectguidb;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class StudentDAO {

    public void addStudent(Student student){
        try {
            Connection conn = DbConn.connectDb();
            PreparedStatement ps = conn.prepareStatement("insert into student values(?,?,?,?)");
            ps.setInt(1, student.getId());
            ps.setString(2, student.getName());
            ps.setInt(3, student.getAge());
            ps.setString(4,student.getAddress());

            ps.executeUpdate();
            System.out.println("Insertion Successful");
            conn.close();

        }catch (Exception e){
            System.out.println(e.getMessage());
        }
    }

    public List<Student> getAllStudents(){
        List<Student> students = new ArrayList<>();
        try {
            Connection conn = DbConn.connectDb();
            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery("select * from student");
            while (rs.next()) {
                students.add(new Student(
                        rs.getInt("id"),
                        rs.getString("name"),
                        rs.getInt("age"),
                        rs.getString("address"))
                );
            }
            System.out.println("Retrieval Successful");
            conn.close();

        }catch (Exception e){
            System.out.println(e.getMessage());
        }
        return students;
    }

    public void deleteStudent(int id) {
        try {
            Connection conn = DbConn.connectDb();
            PreparedStatement ps = conn.prepareStatement("delete from student where id=?");
            ps.setInt(1, id);
            ps.executeUpdate();
            System.out.println("Deletion Successful");
            conn.close();

        }catch (Exception e){
            System.out.println(e.getMessage());
        }
    }

    public void updateStudent(Student student) {
        try {
            Connection conn = DbConn.connectDb();
            PreparedStatement ps = conn.prepareStatement("update student set name=?,age=?,address=? where id=?");

            ps.setString(1, student.getName());
            ps.setInt(2, student.getAge());
            ps.setString(3,student.getAddress());
            ps.setInt(4, student.getId());

            ps.executeUpdate();
            System.out.println("Update Successful");
            conn.close();

        }catch (Exception e){
            System.out.println(e.getMessage());
        }
    }
}
