package com.bo.event;

import javax.swing.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

public class MouseListenerImplementation implements MouseListener {

    private JLabel label;


    public MouseListenerImplementation(JLabel label) {
        this.label = label;
    }


    @Override
    public void mouseClicked(MouseEvent e) {
        label.setText("Mouse Clicked");
    }

    @Override
    public void mousePressed(MouseEvent e) {
        label.setText("Mouse Pressed");
    }

    @Override
    public void mouseReleased(MouseEvent e) {
        label.setText("Mouse Released");
    }

    @Override
    public void mouseEntered(MouseEvent e) {
        label.setText("Mouse Entered");
    }

    @Override
    public void mouseExited(MouseEvent e) {
        label.setText("Mouse Exited");
    }
}
