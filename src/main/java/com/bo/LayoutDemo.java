package com.bo;

import javax.swing.*;
import java.awt.*;

public class LayoutDemo {

    public static void main(String[] args) {
        JFrame frame = new JFrame("Java Swing Layout Managers Demo");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(600, 450);
        frame.setLocationRelativeTo(null);

        JTabbedPane tabbedPane = new JTabbedPane();

        // 1. FLOW LAYOUT (Arranges components in a row, wraps like text)
        JPanel flowPanel = new JPanel(new FlowLayout(FlowLayout.CENTER, 10, 10));
        flowPanel.add(new JButton("Button 1"));
        flowPanel.add(new JButton("Button 2"));
        flowPanel.add(new JButton("Button 3"));
        flowPanel.add(new JButton("Longer Button 4"));
        flowPanel.add(new JButton("5"));
        tabbedPane.addTab("FlowLayout", flowPanel);

        // 2. BORDER LAYOUT (Divides container into 5 strategic regions)
        JPanel borderPanel = new JPanel(new BorderLayout(5, 5));
        borderPanel.add(new JButton("NORTH (Top)"), BorderLayout.NORTH);
        borderPanel.add(new JButton("SOUTH (Bottom)"), BorderLayout.SOUTH);
        borderPanel.add(new JButton("EAST (Right)"), BorderLayout.EAST);
        borderPanel.add(new JButton("WEST (Left)"), BorderLayout.WEST);
        borderPanel.add(new JButton("CENTER (Stretches to fill space)"), BorderLayout.CENTER);
        tabbedPane.addTab("BorderLayout", borderPanel);

        // 3. GRID LAYOUT (Equal sized rows and columns)
        // 3 rows, 2 columns, 10px horizontal/vertical gaps
        JPanel gridPanel = new JPanel(new GridLayout(3, 2, 10, 10));
        gridPanel.add(new JButton("Row 1, Col 1"));
        gridPanel.add(new JButton("Row 1, Col 2"));
        gridPanel.add(new JButton("Row 2, Col 1"));
        gridPanel.add(new JButton("Row 2, Col 2"));
        gridPanel.add(new JButton("Row 3, Col 1"));
        gridPanel.add(new JButton("Row 3, Col 2"));
        tabbedPane.addTab("GridLayout", gridPanel);

        // 4. BOX LAYOUT (Lines up components in a single row or column)
        JPanel boxPanel = new JPanel();
        boxPanel.setLayout(new BoxLayout(boxPanel, BoxLayout.Y_AXIS)); // Stack vertically
        boxPanel.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));
        
        boxPanel.add(new JButton("Component 1"));
        boxPanel.add(Box.createVerticalStrut(15)); // Visual invisible spacing spacer
        boxPanel.add(new JButton("Component 2 (After Space Gap)"));
        boxPanel.add(Box.createVerticalGlue());    // Absorbs remaining extra window space
        boxPanel.add(new JButton("Component 3 (Pushed to Bottom)"));
        tabbedPane.addTab("BoxLayout (Y_AXIS)", boxPanel);


        JPanel boxPanel2 = new JPanel();
        boxPanel2.setLayout(new BoxLayout(boxPanel2, BoxLayout.X_AXIS)); // Stack vertically
        boxPanel2.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));

        boxPanel2.add(new JButton("Component 1"));
        boxPanel2.add(Box.createHorizontalStrut(15)); // Visual invisible spacing spacer
        boxPanel2.add(new JButton("Component 2 (After Space Gap)"));
        boxPanel2.add(Box.createHorizontalGlue());    // Absorbs remaining extra window space
        boxPanel2.add(new JButton("Component 3 (Pushed to Right)"));
        tabbedPane.addTab("BoxLayout (X_AXIS)", boxPanel2);

        // 5. GRIDBAG LAYOUT (The most flexible, precise grid system layout)
        JPanel gridBagPanel = new JPanel(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(5, 5, 5, 5); // Cell padding
        gbc.fill = GridBagConstraints.BOTH;  // Stretch components to fill cells

        // Cell (0,0)
        gbc.gridx = 0; gbc.gridy = 0;
        gridBagPanel.add(new JButton("Cell 0,0"), gbc);

        // Cell (1,0)
        gbc.gridx = 1; gbc.gridy = 0;
        gridBagPanel.add(new JButton("Cell 1,0"), gbc);

        // Cell (0,1) spanning 2 columns wide
        gbc.gridx = 0; gbc.gridy = 1;
        gbc.gridwidth = 2; // Span across two columns
        gridBagPanel.add(new JButton("Spanning 2 Columns (Row 1)"), gbc);

        // Cell (0,2) spanning 2 columns wide n 2 rows high
        gbc.gridx = 0; gbc.gridy = 2;
        gbc.gridwidth = 2; // Span across two columns
        gbc.gridheight = 2; // Span across two rows
        gridBagPanel.add(new JButton("Spanning 2 rows and columns "), gbc);


        // Reset width and height back to 1 for standard cells
        gbc.gridwidth = 1;
        gbc.gridheight = 1;

        // Cell (2,2) - Sits to the right of the big button's first row
        gbc.gridx = 2; gbc.gridy = 2;
        gridBagPanel.add(new JButton("Cell 2,2"), gbc);

        // Cell (2,3) - Sits to the right of the big button's second row
        gbc.gridx = 2; gbc.gridy = 3;
        gridBagPanel.add(new JButton("Cell 2,3"), gbc);

        tabbedPane.addTab("GridBagLayout", gridBagPanel);

        // Add tabs to frame and make visible
        frame.add(tabbedPane);
        frame.setVisible(true);
    }
}