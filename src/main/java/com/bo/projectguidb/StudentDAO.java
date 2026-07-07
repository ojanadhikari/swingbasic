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
            conn.close();

        }catch (Exception e){
            System.out.println(e.getMessage());
        }
    }
}
