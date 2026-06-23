package com.bo.event;

import javax.swing.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionListener;

public class MouseMotionListenerImplementation implements MouseMotionListener {

    private JLabel label;

    public MouseMotionListenerImplementation(JLabel label) {
        this.label = label;
    }

    @Override
    public void mouseDragged(MouseEvent e) {
        label.setText("Mouse Dragged");
    }

    @Override
    public void mouseMoved(MouseEvent e) {
        label.setText("Mouse Moved");
    }
}
