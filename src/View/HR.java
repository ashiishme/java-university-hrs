/*
 * Project: university-human-resource
 * Version: 0.1.0
 * File: HR.java
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
public class HR extends JPanel {

    public static String staffId;
    public static String staffName;
    public static String staffAddr;
    public static String staffNum;
    public static String staffEmail;
    public static String staffStartDate;
    public static String staffType;
    public static String staffDepartment;
    public static String staffSalary;
    public static String staffHourlyRate;
    public static String staffContractTime;

    public static String departmentId;
    public static String departmentName;
    public static String departmentType;
    public static String departmentWebAddress;

    private JToolBar toolBar;

    private JButton logout;

    private JButton addDepartment;
    private JButton editDepartment;
    private JButton deleteDepartment;

    private JButton addLecturer;
    private JButton editLecturer;
    private JButton deleteLecturer;

    private JTable departmentTable;
    private JTable lecturerTable;

    private JScrollPane departmentTableScroll;
    private JScrollPane lecturerTableScroll;

    private Object[] departmentTableRow = new Object[2];
    private Object[] lecturerTableRow = new Object[10];

    private String[] departmentTableColumn = { "Department ID", "Department Name", "Department Type",
            "Department Web Address" };
    private String[] lecturerTableColumn = { "Staff ID", "Name", "Address", "Number", "Email", "Start Date", "Type",
            "Department", "Salary", "Hourly Rate", "Contact End Time" };

    public HR() {
        // Border with title
        Border titledBorder = BorderFactory.createTitledBorder("Human Resource");
        ((TitledBorder) titledBorder).setTitleJustification(TitledBorder.CENTER);
        ((TitledBorder) titledBorder).setTitleFont(new Font("Arial", Font.BOLD, 30));

        // Transparent border
        Border transBorder = BorderFactory.createEmptyBorder(30, 30, 30, 30);
        setBorder(BorderFactory.createCompoundBorder(transBorder, titledBorder));

        toolBar = new JToolBar();
        addDepartment = new JButton("Add Department");
        editDepartment = new JButton("Edit Department");
        deleteDepartment = new JButton("Delete Department");
        addLecturer = new JButton("Add Lecturers");
        editLecturer = new JButton("Edit Lecturers");
        deleteLecturer = new JButton("Delete Lecturers");

        logout = new JButton("Logout");

        setLayout(new BoxLayout(this, BoxLayout.PAGE_AXIS));

        add(toolBar);
        toolBar.add(addDepartment);
        toolBar.add(editDepartment);
        toolBar.add(deleteDepartment);
        toolBar.addSeparator();
        toolBar.add(addLecturer);
        toolBar.add(editLecturer);
        toolBar.add(deleteLecturer);
        toolBar.addSeparator();
        toolBar.add(logout);
        toolBar.setMaximumSize(new Dimension(Integer.MAX_VALUE, toolBar.getMinimumSize().height));

        departmentTable = new JTable();
        lecturerTable = new JTable();

        departmentTableScroll = new JScrollPane(departmentTable, JScrollPane.VERTICAL_SCROLLBAR_ALWAYS,
                JScrollPane.HORIZONTAL_SCROLLBAR_ALWAYS);
        lecturerTableScroll = new JScrollPane(lecturerTable, JScrollPane.VERTICAL_SCROLLBAR_ALWAYS,
                JScrollPane.HORIZONTAL_SCROLLBAR_ALWAYS);

        add(departmentTableScroll);
        add(lecturerTableScroll);
        departmentTableScroll.setPreferredSize(new Dimension(getWidth(), 230));
        lecturerTableScroll.setPreferredSize(new Dimension(getWidth(), 230));

    }

    /**
     * Department
     */

    // add departments
    public void addDepartment(ActionListener actionListener) {
        addDepartment.addActionListener(actionListener);
    }

    // edit departments
    public void editDepartment(ActionListener actionListener) {
        editDepartment.addActionListener(actionListener);
    }

    // delete departments
    public void deleteDepartment(ActionListener actionListener) {
        deleteDepartment.addActionListener(actionListener);
    }

    // get department data
    public void getDepartments(Object[] objects) {
        departmentTableRow = objects;
        departmentToTable();
    }

    // load department to table
    public void departmentToTable() {
        DefaultTableModel defaultTableModel = (DefaultTableModel) departmentTable.getModel();
        defaultTableModel.setColumnIdentifiers(departmentTableColumn);
        int i = 0;
        while (i < departmentTableRow.length) {
            String row = departmentTableRow[i].toString().trim();
            String[] dataRow = row.split(",");
            defaultTableModel.addRow(dataRow);
            i++;
        }
    }

    // add department to table row
    public void addDepartmentToRow(Object[] objects) {
        DefaultTableModel defaultTableModel = (DefaultTableModel) departmentTable.getModel();
        defaultTableModel.addRow(objects);
    }

    // update department
    public void updateDepartment() {
        DefaultTableModel defaultTableModel = (DefaultTableModel) departmentTable.getModel();
        int department_row = departmentTable.getSelectedRow();
        if (department_row < 0) {
            JOptionPane.showMessageDialog(this, "Select department first", "Error", JOptionPane.ERROR_MESSAGE);
            return;
        }
        departmentId = String.valueOf(defaultTableModel.getValueAt(department_row, 0)).trim();
        departmentName = String.valueOf(defaultTableModel.getValueAt(department_row, 1)).trim();
        departmentType = String.valueOf(defaultTableModel.getValueAt(department_row, 2)).trim();
        departmentWebAddress = String.valueOf(defaultTableModel.getValueAt(department_row, 3)).trim();
    }

    // delete department
    public void removeDepartment() {
        DefaultTableModel defaultTableModel = (DefaultTableModel) departmentTable.getModel();
        int row = departmentTable.getSelectedRow();
        if (row < 0) {
            JOptionPane.showMessageDialog(this, "You must select a row from department table.", "Error",
                    JOptionPane.ERROR_MESSAGE);
            return;
        }
        departmentId = String.valueOf(defaultTableModel.getValueAt(row, 0)).trim();
        defaultTableModel.removeRow(row);
    }

    // department getters
    public String getDepartmentId() {
        return departmentId;
    }

    public String getDepartmentName() {
        return departmentName;
    }

    public String getDepartmentType() {
        return departmentType;
    }

    public String getDepartmentWebAddress() {
        return departmentWebAddress;
    }

    /**
     * Lecturers
     */

    // add lecturer
    public void addLecturer(ActionListener actionListener) {
        addLecturer.addActionListener(actionListener);
    }

    // edit lecturer
    public void editLecturer(ActionListener actionListener) {
        editLecturer.addActionListener(actionListener);
    }

    // delete lecturer
    public void deleteLecturer(ActionListener actionListener) {
        deleteLecturer.addActionListener(actionListener);
    }

    // get lecturer data
    public void getLecturers(Object[] objects) {
        lecturerTableRow = objects;
        lecturerToTable();
    }

    // load lecturer to table
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

    // add lecturer to table row
    public void addLecturerToRow(Object[] objects) {
        DefaultTableModel defaultTableModel = (DefaultTableModel) lecturerTable.getModel();
        defaultTableModel.addRow(objects);
    }

    // update department
    public void updateLecturer() {
        DefaultTableModel defaultTableModel = (DefaultTableModel) lecturerTable.getModel();
        int lecturer_row = lecturerTable.getSelectedRow();
        if (lecturer_row < 0) {
            JOptionPane.showMessageDialog(this, "Select staff row first", "Error", JOptionPane.ERROR_MESSAGE);
            return;
        }
        staffId = String.valueOf(defaultTableModel.getValueAt(lecturer_row, 0)).trim();
        staffName = String.valueOf(defaultTableModel.getValueAt(lecturer_row, 1)).trim();
        staffAddr = String.valueOf(defaultTableModel.getValueAt(lecturer_row, 2)).trim();
        staffNum = String.valueOf(defaultTableModel.getValueAt(lecturer_row, 3)).trim();
        staffEmail = String.valueOf(defaultTableModel.getValueAt(lecturer_row, 4)).trim();
        staffStartDate = String.valueOf(defaultTableModel.getValueAt(lecturer_row, 5)).trim();
        staffType = String.valueOf(defaultTableModel.getValueAt(lecturer_row, 6)).trim();
        staffDepartment = String.valueOf(defaultTableModel.getValueAt(lecturer_row, 7)).trim();
        staffSalary = String.valueOf(defaultTableModel.getValueAt(lecturer_row, 8)).trim();
        staffHourlyRate = String.valueOf(defaultTableModel.getValueAt(lecturer_row, 9)).trim();
        staffContractTime = String.valueOf(defaultTableModel.getValueAt(lecturer_row, 10)).trim();

    }

    // delete department
    public void removeLecturer() {
        DefaultTableModel defaultTableModel = (DefaultTableModel) lecturerTable.getModel();
        int row = lecturerTable.getSelectedRow();
        if (row < 0) {
            JOptionPane.showMessageDialog(this, "You must select a row from staff table.", "Error",
                    JOptionPane.ERROR_MESSAGE);
            return;
        }
        staffId = String.valueOf(defaultTableModel.getValueAt(row, 0)).trim();
        defaultTableModel.removeRow(row);
    }

    // lecturer getters
    public String getStaffId() {
        return staffId;
    }

    public String getStaffName() {
        return staffName;
    }

    public String getStaffAddr() {
        return staffAddr;
    }

    public String getStaffNum() {
        return staffNum;
    }

    public String getStaffEmail() {
        return staffEmail;
    }

    public String getStaffStartDate() {
        return staffStartDate;
    }

    public String getStaffType() {
        return staffType;
    }

    public String getStaffDepartment() {
        return staffDepartment;
    };

    public String getStaffSalary() {
        return staffSalary;
    }

    public String getStaffHourlyRate() {
        return staffHourlyRate;
    }

    public String getStaffContractTime() {
        return staffContractTime;
    }

    public void logout(ActionListener actionListener) {
        logout.addActionListener(actionListener);
    }
}
