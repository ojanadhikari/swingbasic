package com.bo.projectguidb;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class StudentUI extends JFrame {

    private JTable table;
    DefaultTableModel model;
    StudentDAO dao = new StudentDAO();
    JButton add=new JButton("Add Student");

    public StudentUI() {
        setTitle("Students");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(900, 900);
        setLocationRelativeTo(null);

        model = new DefaultTableModel();

        model.setColumnIdentifiers(new String[]{
                "ID", "Name", "Age", "Address", "Action"
        });

        table = new JTable(model);


        JPanel topPanel = new JPanel();
        topPanel.add(add);
        add(topPanel, BorderLayout.NORTH);
        add(new JScrollPane(table));

        loadData();
        add.addActionListener(e->new StudentForm(this));

        setVisible(true);

        table.addMouseListener(new MouseAdapter() {
            public void mouseClicked(MouseEvent e) {
                int row = table.rowAtPoint(e.getPoint());
                int col = table.columnAtPoint(e.getPoint());
                if (col == 4) {

                    String action = table.getValueAt(row, col).toString();
                    int x = e.getX() - table.getCellRect(row, col, false).x;

                    if (x < 60) {
                        updateStudent(row);
                    } else {
                        deleteStudent(row);
                    }
                }

            }
        });

    }


    public void loadData() {
        model.setRowCount(0);
        for (Student s : dao.getAllStudents()) {
            model.addRow(new Object[]{
                    s.getId(),
                    s.getName(),
                    s.getAge(),
                    s.getAddress(),
                    "UPDATE | DELETE"
            });
        }
    }

    public void updateStudent(int row) {
        int id =(Integer) model.getValueAt(row,0);
        Student student = new Student(
                id,
                model.getValueAt(row,1).toString(),
                Integer.parseInt(model.getValueAt(row,2).toString()),
                model.getValueAt(row,3).toString()
        );
        int resp = JOptionPane.showConfirmDialog(null,"Are you sure you want to update data?","CONFIRM",JOptionPane.YES_NO_OPTION);
        if (resp == JOptionPane.YES_OPTION) {
            dao.updateStudent(student);
        }

        loadData();
    }

    public void deleteStudent(int row) {
        int id =(Integer) model.getValueAt(row,0);
        int resp = JOptionPane.showConfirmDialog(null,"Are you sure you want to delete data?","CONFIRM",JOptionPane.YES_NO_OPTION);
        if (resp == JOptionPane.YES_OPTION) {
            dao.deleteStudent(id);
        }
        loadData();
    }



    public static void main(String[] args) {

        new StudentUI();

    }
}
