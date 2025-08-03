
package org.example;

import javax.swing.*;
import javax.swing.border.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.*;

public class StudentManagerUI extends JFrame {
    private JTextField nameField, banglaField, englishField, mathField;
    private JTextArea outputArea;
    private JTable studentTable;
    private DefaultTableModel tableModel;
    private StudentManager manager = new StudentManager();
    private final String FILE_NAME = "students.json";

    public StudentManagerUI() {
        setTitle("📚 Student Manager");
        setSize(1000, 600);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        setSystemLookAndFeel();

        // Use tabs to separate Add and Records
        JTabbedPane tabbedPane = new JTabbedPane();

        // Add Student Tab
        JPanel addStudentPanel = createAddStudentPanel();

        // Student Records Tab (Table + Output log)
        JPanel recordsPanel = createRecordsPanel();

        tabbedPane.addTab("➕ Add Student", addStudentPanel);
        tabbedPane.addTab("📋 Student Records", recordsPanel);

        add(tabbedPane);
    }

    private JPanel createAddStudentPanel() {
        JPanel panel = new GradientPanel(new Color(240, 248, 255), new Color(200, 230, 255));
        panel.setBorder(new EmptyBorder(20, 30, 20, 30));

        GroupLayout layout = new GroupLayout(panel);
        panel.setLayout(layout);
        layout.setAutoCreateGaps(true);
        layout.setAutoCreateContainerGaps(true);

        Font labelFont = new Font("Segoe UI Semibold", Font.PLAIN, 15);

        JLabel nameLabel = createLabel("Name:", labelFont);
        JLabel banglaLabel = createLabel("Bangla:", labelFont);
        JLabel englishLabel = createLabel("English:", labelFont);
        JLabel mathLabel = createLabel("Math:", labelFont);

        nameField = new JTextField();
        banglaField = new JTextField();
        englishField = new JTextField();
        mathField = new JTextField();

        // Increase input fields size
        Dimension inputSize = new Dimension(400, 35);
        nameField.setPreferredSize(inputSize);
        banglaField.setPreferredSize(inputSize);
        englishField.setPreferredSize(inputSize);
        mathField.setPreferredSize(inputSize);

        addPlaceholder(nameField, "Enter name");
        addPlaceholder(banglaField, "Bangla marks");
        addPlaceholder(englishField, "English marks");
        addPlaceholder(mathField, "Math marks");

        JButton addButton = createFancyButton("➕ Add Student", new Color(72, 201, 176));
        addButton.addActionListener(this::addStudent);

        // Horizontal layout: labels and inputs aligned left, button centered
        layout.setHorizontalGroup(
                layout.createParallelGroup(GroupLayout.Alignment.CENTER)
                        .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.TRAILING)
                                        .addComponent(nameLabel)
                                        .addComponent(banglaLabel)
                                        .addComponent(englishLabel)
                                        .addComponent(mathLabel))
                                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                                        .addComponent(nameField)
                                        .addComponent(banglaField)
                                        .addComponent(englishField)
                                        .addComponent(mathField)))
                        .addComponent(addButton, GroupLayout.Alignment.CENTER) // center button
        );

        // Vertical layout: labels and inputs stacked, then button below centered
        layout.setVerticalGroup(
                layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                                .addComponent(nameLabel)
                                .addComponent(nameField))
                        .addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                                .addComponent(banglaLabel)
                                .addComponent(banglaField))
                        .addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                                .addComponent(englishLabel)
                                .addComponent(englishField))
                        .addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                                .addComponent(mathLabel)
                                .addComponent(mathField))
                        .addGap(25)
                        .addComponent(addButton)
        );

        return panel;
    }

    private JPanel createRecordsPanel() {
        JPanel panel = new JPanel(new BorderLayout(10, 10));
        panel.setBorder(new EmptyBorder(10, 10, 10, 10));

        // Table setup
        String[] columns = {"Name", "Bangla", "English", "Math", "Total", "Average", "Grade"};
        tableModel = new DefaultTableModel(columns, 0);
        studentTable = new JTable(tableModel);
        studentTable.setRowHeight(28);
        studentTable.setFont(new Font("Segoe UI", Font.PLAIN, 14));
        studentTable.getTableHeader().setFont(new Font("Segoe UI", Font.BOLD, 15));

        JScrollPane tableScroll = new JScrollPane(studentTable);
        tableScroll.setBorder(createRoundedTitledBorder("📋 Student Records"));

        // Buttons Panel with hover effects
        JPanel buttonPanel = new JPanel(new FlowLayout(FlowLayout.CENTER, 20, 15));
        buttonPanel.setBackground(new Color(225, 235, 250));

        JButton highestButton = createFancyButton(" Highest Marks", new Color(100, 149, 237));
        JButton topperButton = createFancyButton(" Show Topper", new Color(100, 149, 237));
        JButton saveButton = createFancyButton("Save", new Color(100, 149, 237));
        JButton loadButton = createFancyButton(" Load", new Color(100, 149, 237));

        highestButton.addActionListener(this::showHighest);
        topperButton.addActionListener(this::showTopper);
        saveButton.addActionListener(e -> saveStudents());
        loadButton.addActionListener(e -> loadStudents());

        buttonPanel.add(highestButton);
        buttonPanel.add(topperButton);
        buttonPanel.add(saveButton);
        buttonPanel.add(loadButton);

        // Output area with rounded border
        outputArea = new JTextArea(5, 50);
        outputArea.setEditable(false);
        outputArea.setFont(new Font("Consolas", Font.PLAIN, 14));
        outputArea.setBorder(createRoundedTitledBorder(" Output Log"));

        JScrollPane outputScroll = new JScrollPane(outputArea);
        outputScroll.setPreferredSize(new Dimension(950, 130));

        panel.add(buttonPanel, BorderLayout.NORTH);
        panel.add(tableScroll, BorderLayout.CENTER);
        panel.add(outputScroll, BorderLayout.SOUTH);

        return panel;
    }
}