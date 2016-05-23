package com.Kiyivinski.graphical;

import com.Kiyivinski.models.Student;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;

public class StudentTable extends JTable {
    private DefaultTableModel model;
    StudentTable() {
        this.model = new DefaultTableModel();
        this.model.addColumn("Name");
        this.model.addColumn("Student ID");
        this.model.addColumn("Course");

        this.setModel(this.model);
    }

    public void addRow(Student student) {
        Object [] row = new Object[]{
                student.getName(),
                student.getIdentification(),
                student.getCourse().getName()
        };
        this.model.addRow(row);
    }
}
