package org.example;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;

public class StudentManagerUI extends JFrame {
    private  JTextField nameField,banglaField,englishField,mathField;
    private JTextArea ouputArea;
    private JTable studenTable;
    private DefaultTableModel tableModel;
    private StudentManager manager=new StudentManager();
    private final String FILE_NAME = "students.json";

    public StudentManagerUI(){
        setTitle("Student Management App");
        setSize(1000,600);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        setSystemLookAndFeel();

        //use tabs to separate Add and Records
        JTabbedPane tabbedPane=new JTabbedPane();

        //add student Tab
        JPanel addStudentPanel=createAddStudentPanel();

        // Student Records Tab (Table + Output log)
        JPanel recordsPanel = createRecordsPanel();

        tabbedPane.addTab("Add Student",addStudentPanel);
        tabbedPane.addTab("Studnet Records" ,recordsPanel);

        add(tabbedPane);

    }

}
