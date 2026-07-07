package com.bo.swing.event;

import javax.swing.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class KeyListenerImplementation implements KeyListener {
    private JLabel label;

    public KeyListenerImplementation(JLabel label) {
        this.label = label;
    }

    @Override
    public void keyTyped(KeyEvent e) {
        JTextField textField = (JTextField) e.getSource();
        String currentText = textField.getText();

        if (currentText.isEmpty()) {
            label.setText("Start typing in the text box...");
        } else {
            label.setText("Live Preview: " + currentText);
        }
    }

    @Override
    public void keyPressed(KeyEvent e) {
//        label.setText(label.getText() + e.getKeyChar());
    }

    @Override
    public void keyReleased(KeyEvent e) {
//        label.setText(label.getText() + e.getKeyChar());
    }
}
