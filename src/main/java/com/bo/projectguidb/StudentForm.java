package com.bo.projectguidb;

import javax.swing.*;
import java.awt.*;

public class StudentForm extends JFrame {
    JTextField id=new JTextField();
    JTextField name=new JTextField();
    JTextField age=new JTextField();
    JTextField address=new JTextField();

    JButton save=new JButton("Save");

    public StudentForm(StudentUI ui){

        setTitle("Student Form");

        setSize(300,250);
        setLocationRelativeTo(null);

        setLayout(new GridLayout(5,2));

        add(new JLabel("ID"));
        add(id);

        add(new JLabel("Name"));
        add(name);

        add(new JLabel("Age"));
        add(age);

        add(new JLabel("Address"));
        add(address);

        add(save);

        save.addActionListener(e->{

            Student s=new Student(
                    Integer.parseInt(id.getText()),
                    name.getText(),
                    Integer.parseInt(age.getText()),
                    address.getText()
            );

            new StudentDAO().addStudent(s);

            ui.loadData();

            dispose();

        });

        setVisible(true);
    }
}
