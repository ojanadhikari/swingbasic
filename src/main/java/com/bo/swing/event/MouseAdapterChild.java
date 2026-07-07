package com.bo.swing.event;

import javax.swing.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class MouseAdapterChild extends MouseAdapter {
    private JLabel label;

    public MouseAdapterChild(JLabel label) {
        this.label = label;
    }

    @Override
    public void mousePressed(MouseEvent e) {
        label.setText("Mouse Pressed");
    }
}



