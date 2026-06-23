package com.bo;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import javax.swing.tree.DefaultMutableTreeNode;
import java.awt.*;

public class SwingDemo {

    public static void main(String[] args) {
        // --- 1. Top-Level Container: JFrame ---
        JFrame frame = new JFrame("SwingDemo - All Components");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(800, 600);
        frame.setLocationRelativeTo(null);

        // --- 2. Menu Components Setup ---
        JMenuBar menuBar = new JMenuBar();
        JMenu menu = new JMenu("File");
        JMenuItem menuItem = new JMenuItem("Open");
        JCheckBoxMenuItem checkBoxMenuItem = new JCheckBoxMenuItem("Toggle Feature", true);
        JRadioButtonMenuItem radioButtonMenuItem = new JRadioButtonMenuItem("Select Option", true);

        menu.add(menuItem);
        menu.add(checkBoxMenuItem);
        menu.add(radioButtonMenuItem);
        menuBar.add(menu);
        frame.setJMenuBar(menuBar);

        // --- 3. Creating Tabs to separate large and small elements ---
        JTabbedPane tabbedPane = new JTabbedPane();

        // ================= TAB 1: BASIC WIDGETS =================
        JPanel basicWidgetsPanel = new JPanel(new GridLayout(0, 2, 10, 10));
        basicWidgetsPanel.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));

        basicWidgetsPanel.add(new JLabel("JButton:"));
        basicWidgetsPanel.add(new JButton("Click Me"));

        basicWidgetsPanel.add(new JLabel("JCheckBox:"));
        basicWidgetsPanel.add(new JCheckBox("Check Box Option", true));

        basicWidgetsPanel.add(new JLabel("JRadioButton:"));
        basicWidgetsPanel.add(new JRadioButton("Radio Button Option", true));

        basicWidgetsPanel.add(new JLabel("JToggleButton:"));
        basicWidgetsPanel.add(new JToggleButton("Toggle State Switch Button", true));

        basicWidgetsPanel.add(new JLabel("JTextField:"));
        basicWidgetsPanel.add(new JTextField("Standard text field"));

        basicWidgetsPanel.add(new JLabel("JPasswordField:"));
        basicWidgetsPanel.add(new JPasswordField("password123"));

        basicWidgetsPanel.add(new JLabel("JFormattedTextField:"));
        basicWidgetsPanel.add(new JFormattedTextField(new java.util.Date()));

        basicWidgetsPanel.add(new JLabel("JComboBox:"));
        String[] languages = {"Java", "Python", "C++"};
        basicWidgetsPanel.add(new JComboBox<>(languages));

        basicWidgetsPanel.add(new JLabel("JSpinner:"));
        basicWidgetsPanel.add(new JSpinner(new SpinnerNumberModel(10, 0, 100, 1)));

        basicWidgetsPanel.add(new JLabel("JSlider:"));
        JSlider slider = new JSlider(0, 100, 50);
        slider.setPaintTicks(true);
        basicWidgetsPanel.add(slider);

        basicWidgetsPanel.add(new JLabel("JProgressBar:"));
        JProgressBar progressBar = new JProgressBar(0, 100);
        progressBar.setValue(75);
        progressBar.setStringPainted(true);
        basicWidgetsPanel.add(progressBar);

        basicWidgetsPanel.add(new JLabel("JScrollBar:"));
        basicWidgetsPanel.add(new JScrollBar(JScrollBar.HORIZONTAL, 30, 10, 0, 100));

        basicWidgetsPanel.add(new JLabel("JToolTip (Hover below):"));
        JButton tooltipButton = new JButton("Hover mouse over me");
        tooltipButton.setToolTipText("This text is rendered using JToolTip!");
        basicWidgetsPanel.add(tooltipButton);

        basicWidgetsPanel.add(new JLabel("JLabel & JLayer Wrapper:"));
        JLabel plainLabel = new JLabel("Hello World");
        JLayer<JLabel> layer = new JLayer<>(plainLabel);
        basicWidgetsPanel.add(layer);

        basicWidgetsPanel.add(new JLabel("JComponent (Custom Border Box):"));
        JComponent genericComponent = new JPanel();
        genericComponent.setBorder(BorderFactory.createLineBorder(Color.GRAY));
        basicWidgetsPanel.add(genericComponent);

        tabbedPane.addTab("Basic Controls", new JScrollPane(basicWidgetsPanel));

        // ================= TAB 2: TEXT PANES & ADVANCED =================
        JPanel advancedPanel = new JPanel(new GridLayout(0, 1, 10, 10));
        advancedPanel.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));

        advancedPanel.add(new JLabel("JTextArea:"));
        advancedPanel.add(new JScrollPane(new JTextArea("Multi-line text area content.", 3, 20)));

        advancedPanel.add(new JLabel("JTextPane:"));
        JTextPane textPane = new JTextPane();
        textPane.setText("Styled text document object content model.");
        advancedPanel.add(new JScrollPane(textPane));

        advancedPanel.add(new JLabel("JEditorPane (HTML support):"));
        JEditorPane editorPane = new JEditorPane("text/html", "<b>Hello</b> <i>World</i>");
        advancedPanel.add(new JScrollPane(editorPane));

        advancedPanel.add(new JLabel("JSeparator & JPopupMenu (Right-click inside box):"));
        JPanel menuDemoPanel = new JPanel(new BorderLayout());
        menuDemoPanel.setBorder(BorderFactory.createLineBorder(Color.LIGHT_GRAY));
        menuDemoPanel.add(new JSeparator(), BorderLayout.CENTER);
        JPopupMenu popupMenu = new JPopupMenu();
        popupMenu.add(new JMenuItem("Cut"));
        popupMenu.add(new JMenuItem("Copy"));
        menuDemoPanel.setComponentPopupMenu(popupMenu);
        advancedPanel.add(menuDemoPanel);

        advancedPanel.add(new JLabel("JList:"));
        String[] listItems = {"Item 1", "Item 2", "Item 3"};
        advancedPanel.add(new JScrollPane(new JList<>(listItems)));

        tabbedPane.addTab("Text & Complex", new JScrollPane(advancedPanel));

        // ================= TAB 3: DATA VIEWS (TABLE, TREE, SPLIT) =================
        JPanel dataPanel = new JPanel(new BorderLayout(10, 10));

        // JTable
        String[] columns = {"ID", "Name"};
        Object[][] data = {{1, "Alice"}, {2, "Bob"}};
        JTable table = new JTable(new DefaultTableModel(data, columns));

        // JTree
        DefaultMutableTreeNode rootNode = new DefaultMutableTreeNode("Root");
        rootNode.add(new DefaultMutableTreeNode("Leaf A"));
        rootNode.add(new DefaultMutableTreeNode("Leaf B"));
        JTree tree = new JTree(rootNode);

        // JSplitPane mixing Table and Tree
        JSplitPane splitPane = new JSplitPane(JSplitPane.HORIZONTAL_SPLIT, new JScrollPane(tree), new JScrollPane(table));
        splitPane.setDividerLocation(150);
        dataPanel.add(splitPane, BorderLayout.CENTER);

        tabbedPane.addTab("Data (Table, Tree, Split)", dataPanel);

        // ================= TAB 4: LARGE DIALOGS / CHOOSERS =================
        tabbedPane.addTab("JColorChooser", new JColorChooser());
        tabbedPane.addTab("JFileChooser", new JFileChooser());

        // ================= TAB 5: PANES & SYSTEM CONTAINERS =================
        JPanel containerPanel = new JPanel(new GridLayout(1, 2, 10, 10));

        // JDesktopPane & JInternalFrame
        JDesktopPane desktopPane = new JDesktopPane();
        JInternalFrame internalFrame = new JInternalFrame("Internal Frame", true, true, true, true);
        internalFrame.setBounds(10, 10, 180, 120);
        internalFrame.setVisible(true);
        desktopPane.add(internalFrame);
        containerPanel.add(desktopPane);

        // JLayeredPane
        JLayeredPane layeredPane = new JLayeredPane();
        JButton bottomBtn = new JButton("Bottom");
        bottomBtn.setBounds(20, 20, 90, 30);
        JButton topBtn = new JButton("Top Layer");
        topBtn.setBounds(50, 40, 100, 30);
        layeredPane.add(bottomBtn, JLayeredPane.DEFAULT_LAYER);
        layeredPane.add(topBtn, JLayeredPane.PALETTE_LAYER);
        containerPanel.add(layeredPane);

        tabbedPane.addTab("Panes (Internal, Layered)", containerPanel);

        // ================= OTHER MISC STRUCTURAL COMPONENTS =================
        // JToolBar (Added at the very top of the layout)
        JToolBar toolBar = new JToolBar();
        toolBar.add(new JButton("New"));
        toolBar.add(new JButton("Save"));
        frame.add(toolBar, BorderLayout.NORTH);

        // JRootPane demonstration container
        JRootPane rootPane = new JRootPane();

        // JViewport
        JViewport viewport = new JViewport();
        viewport.setView(new JLabel("Hosted inside a JViewport context"));

        // JPanel wrapper container
        JPanel wrapperPanel = new JPanel(new FlowLayout());
        wrapperPanel.add(new JLabel("JPanel Content"));

        // Add the primary TabbedPane into the JFrame
        frame.add(tabbedPane, BorderLayout.CENTER);
        frame.setVisible(true);

        // --- 4. Separate Secondary Top-Level Windows ---
        // JDialog
        JDialog dialog = new JDialog(frame, "JDialog Window Instance", false);
        dialog.setSize(250, 120);
        dialog.setLocation(frame.getX() - 260, frame.getY());
        dialog.add(new JLabel("This is a standalone JDialog.", SwingConstants.CENTER));
        dialog.setVisible(true);

        // JWindow
        JWindow window = new JWindow(frame);
        window.setSize(250, 120);
        window.setLocation(frame.getX() - 260, frame.getY() + 150);
        JPanel windowContent = new JPanel(new BorderLayout());
        windowContent.setBorder(BorderFactory.createLineBorder(Color.BLACK));
        windowContent.add(new JLabel("This is an unbordered JWindow.", SwingConstants.CENTER));
        window.add(windowContent);
        window.setVisible(true);

        // JOptionPane
        JOptionPane.showMessageDialog(frame, "Sample JOptionPane Message Dialog", "Info", JOptionPane.INFORMATION_MESSAGE);

        // JApplet (Deprecated/Removed object validation stub)
        @SuppressWarnings("removal")
        JApplet appletInstance = new JApplet() { public void init() { super.init(); } };
        System.out.println("Instantiated JApplet successfully: " + appletInstance.getClass().getName());
    }
}