/*
 * Project: university-human-resource
 * Version: 0.1.0
 * File: Secretary.java
 * ------
 * Author: Ashish Yadav (contact@ashiish.me)
 * GitHub: https://github.com/ashiishme
 */

package View;

import javax.swing.*;
import javax.swing.border.Border;
import javax.swing.border.TitledBorder;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionListener;

@SuppressWarnings("serial")
public class Secretary extends JPanel {

    private JToolBar searchBar;
    private JLabel searchLabel;
    private JTextField searchField;
    private JButton searchButton;
    private JButton logout;

    private static String staffDepartment;

    private JTable lecturerTable;
    private JScrollPane lecturerTableScroll;

    private Object[] lecturerTableRow = new Object[10];
    private String[] lecturerTableColumn = { "Staff ID", "Name", "Address", "Number", "Email", "Start Date", "Type",
            "Department", "Salary", "Hourly Rate", "Contact End Time" };

    public Secretary() {
        // Border with title
        Border titledBorder = BorderFactory.createTitledBorder("Department Secretary");
        ((TitledBorder) titledBorder).setTitleJustification(TitledBorder.CENTER);
        ((TitledBorder) titledBorder).setTitleFont(new Font("Arial", Font.BOLD, 30));

        // Transparent border
        Border transBorder = BorderFactory.createEmptyBorder(30, 30, 30, 30);
        setBorder(BorderFactory.createCompoundBorder(transBorder, titledBorder));

        searchBar = new JToolBar();
        searchLabel = new JLabel("Search Lecturer By ID: ");
        searchField = new JTextField(50);
        searchButton = new JButton("Search Lecturer");

        logout = new JButton("Logout");

        setLayout(new BoxLayout(this, BoxLayout.PAGE_AXIS));

        lecturerTable = new JTable();

        lecturerTableScroll = new JScrollPane(lecturerTable, JScrollPane.VERTICAL_SCROLLBAR_ALWAYS,
                JScrollPane.HORIZONTAL_SCROLLBAR_ALWAYS);

        add(searchBar);
        searchBar.add(searchLabel);
        searchBar.add(searchField);
        searchBar.add(searchButton);
        searchBar.addSeparator();
        searchBar.add(logout);
        searchBar.setMaximumSize(new Dimension(Integer.MAX_VALUE, searchBar.getMinimumSize().height));

        add(lecturerTableScroll);
        lecturerTableScroll.setPreferredSize(new Dimension(getWidth(), 230));

    }

    // get lecturers
    public void getLecturers(Object[] objects) {
        lecturerTableRow = objects;
        lecturerToTable();
    }

    // load lecturers to table
    public void lecturerToTable() {
        DefaultTableModel defaultTableModel = (DefaultTableModel) lecturerTable.getModel();
        defaultTableModel.setColumnIdentifiers(lecturerTableColumn);
        int i = 0;
        while (i < lecturerTableRow.length) {
            String row = lecturerTableRow[i].toString().trim();
            String[] dataRow = row.split(",");
            defaultTableModel.addRow(dataRow);
            i++;
        }
    }

    public String getLecturerId() {
        return searchField.getText();
    }

    public void setLecturerDepartment(String department) {
        staffDepartment = department;
    }

    public String getLecturerDepartment() {
        return staffDepartment;
    }

    public void searchLecturer(ActionListener actionListener) {
        searchButton.addActionListener(actionListener);
    }

    public void logout(ActionListener actionListener) {
        logout.addActionListener(actionListener);
    }

}
