package com.Kiyivinski.graphical;

import com.Kiyivinski.graphical.listeners.LoginInterface;

import javax.swing.*;

public class MainFrame extends JFrame implements LoginInterface {
    private JTabbedPane layout;
    private String database;
    private String user;
    private String password;

    public MainFrame() {
        this.setTitle("Java Assignment 2 - 4316886 Timothy Kiyui");
        this.setSize(800, 600);
        this.setLocationRelativeTo(null);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        this.layout = new JTabbedPane();
        this.add(layout);

        this.createLoginLayout();
        this.setVisible(true);
    }

    private void createLoginLayout() {

        JPanel databasePanel = new DatabasePanel(this);
        this.layout.addTab("Database", databasePanel);
        this.layout.setTabPlacement(SwingConstants.LEFT);

    }

    private void createMainLayout() {
        StudentPanel studentPanel = new StudentPanel();
        studentPanel.connect(this.database, this.user, this.password);

        JPanel assessmentPanel = new AssessmentPanel();
        JPanel unitPanel = new UnitPanel();
        JPanel semesterPanel = new SemesterPanel();
        JPanel coursePanel = new CoursePanel();

        this.layout.addTab("Student", studentPanel);
        this.layout.addTab("Assessment", assessmentPanel);
        this.layout.addTab("Units", unitPanel);
        this.layout.addTab("Semesters", semesterPanel);
        this.layout.addTab("Courses", coursePanel);
    }

    public void login(String database, String user, String password) {
        this.database = database;
        this.user = user;
        this.password = password;

        this.layout.removeTabAt(0);
        this.createMainLayout();
    }
}
