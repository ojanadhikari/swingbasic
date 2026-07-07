package com.bo.swing;

import javax.swing.*;

public class Location {
    public static void main(String[] args) {
        JFrame frame = new JFrame();
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setTitle("Location");
        frame.setSize(500, 500);
        frame.setLocationRelativeTo(null);
        frame.setLayout(null);

        JLabel num1Label = new JLabel("Num 1");
        num1Label.setBounds(0, 0, 100, 30);
        frame.add(num1Label);

        JTextField num1Field = new JTextField();
        num1Field.setBounds(0, 35, 100, 30);
        frame.add(num1Field);

        JLabel num2Label = new JLabel("Num 2");
        num2Label.setBounds(110, 0, 100, 30);
        frame.add(num2Label);

        JTextField num2Field = new JTextField();
        num2Field.setBounds(110, 35, 100, 30);
        frame.add(num2Field);

        JButton addButton = new JButton("Add");
        addButton.setBounds(55, 70, 100, 30);
        frame.add(addButton);

        JLabel resultLabel = new JLabel("Result");
        resultLabel.setBounds(0, 105, 100, 30);
        frame.add(resultLabel);

        JTextField resultField = new JTextField();
        resultField.setBounds(0, 135, 210, 30);
        frame.add(resultField);

        frame.setVisible(true);
    }
}