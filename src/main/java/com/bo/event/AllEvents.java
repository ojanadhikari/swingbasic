package com.bo.event;

import javax.swing.*;

public class AllEvents {

    public static void main(String[] args) {

        JFrame frame = new JFrame("Event Tester");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(500, 500);
        frame.setLocationRelativeTo(null);

        JTabbedPane tabbedPane = new JTabbedPane();


        JPanel mousePanel = new JPanel();

        JLabel label = new JLabel("Interact With your mouse");
        mousePanel.add(label);
        mousePanel.addMouseListener(new MouseListenerImplementation(label));

        tabbedPane.addTab("Mouse Listener Event", mousePanel);

        JPanel advancedMousePanel = new JPanel();

        JLabel label2 = new JLabel("Interact With your mouse");
        advancedMousePanel.add(label2);
        advancedMousePanel.addMouseMotionListener(new MouseMotionListenerImplementation(label2));

        tabbedPane.addTab("Mouse Motion Listener Event", advancedMousePanel);

        JPanel keyPanel = new JPanel();

        JTextField textField = new JTextField(15);
        JLabel label3 = new JLabel("Interact With your keyboard, Type in the box ");

        keyPanel.add(textField);
        keyPanel.add(label3);
        textField.addKeyListener(new KeyListenerImplementation(label3));

        tabbedPane.addTab("Key Listener Event", keyPanel);

        JPanel buttonPanel = new JPanel();
        JLabel label4 = new JLabel("Num1");
        JLabel label5 = new JLabel("Num2");
        JTextField num1 = new JTextField(15);
        JTextField num2 = new JTextField(15);
        JTextField num3 = new JTextField(15);
        JButton button = new JButton("ADD");
        buttonPanel.add(label4);
        buttonPanel.add(num1);
        buttonPanel.add(label5);
        buttonPanel.add(num2);
        buttonPanel.add(button);
        buttonPanel.add(num3);
        button.addActionListener(new ActionListenerImplementation(button,num1,num2,num3));
        tabbedPane.addTab("Button Listener Event", buttonPanel);

        frame.add(tabbedPane);
        frame.setVisible(true);

        frame.addWindowListener(new WindowListenerImplementation());


    }
}
