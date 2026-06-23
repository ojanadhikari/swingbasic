package com.bo.event;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ActionListenerImplementation implements ActionListener {

    private JButton button;
    private JTextField num1;
    private JTextField num2;
    private JTextField num3;

    public ActionListenerImplementation(JButton button, JTextField num1, JTextField num2, JTextField num3) {
        this.button = button;
        this.num1 = num1;
        this.num2 = num2;
        this.num3 = num3;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        try {
            String number1 = num1.getText();
            String number2 = num2.getText();

            Double first = Double.parseDouble(number1);
            Double second = Double.parseDouble(number2);


            Double sum = first + second;

            num3.setText(Double.toString(sum));
        }catch (NumberFormatException e1) {
            JOptionPane.showMessageDialog(null, "Please enter a number");
        }
    }
}
