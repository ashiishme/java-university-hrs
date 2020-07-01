/*
 * Project: university-human-resource
 * Version: 0.1.0
 * File: AddLecturers.java
 * ------
 * Author: Ashish Yadav (contact@ashiish.me)
 * GitHub: https://github.com/ashiishme
 */

package View.Lecturers;

import Model.Database;
import View.HR;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;
import java.io.File;
import java.text.DateFormat;
import java.text.SimpleDateFormat;

@SuppressWarnings("serial")
public class AddLecturers extends JDialog {

    private JLabel staffIdLabel;
    private JLabel nameLabel;
    private JLabel addressLabel;
    private JLabel phoneLabel;
    private JLabel emailLabel;
    private JLabel dateLabel;
    private JLabel typeLabel;
    private JLabel departmentListLabel;
    private JLabel salaryLabel;
    private JLabel hourRateLabel;
    private JLabel contractTimeLabel;

    private JFormattedTextField staffId;
    private JTextField name;
    private JTextField address;
    private JFormattedTextField phone;
    private JFormattedTextField email;
    private JFormattedTextField date;
    private JComboBox<String> type;
    private JComboBox<String> departmentList;
    private JFormattedTextField salary;
    private JFormattedTextField hourRate;
    private JFormattedTextField contractTime;

    private JButton addLecturerButton;
    private JButton cancelButton;

    public AddLecturers() {
        // left empty
    }

    public AddLecturers(JFrame jFrame, Database database) {
        super(jFrame, "Add Lecturer", false);

        new HR();

        DateFormat dateFormat = new SimpleDateFormat("mm/dd/yyyy");
        String[] lecturer_type = new String[] { "Full-time", "Part-time", "Contract" };
        String[] strArr = database.loadDepartmentNames(new File("src\\database\\department.txt"));
        staffIdLabel = new JLabel("Staff Identification Number: ");
        staffId = new JFormattedTextField();
        staffId.setColumns(20);

        nameLabel = new JLabel("Name: ");
        name = new JTextField(20);

        addressLabel = new JLabel("Address: ");
        address = new JTextField(20);

        phoneLabel = new JLabel("Phone: ");
        phone = new JFormattedTextField();
        phone.setColumns(20);

        emailLabel = new JLabel("Email: ");
        email = new JFormattedTextField();
        email.setColumns(20);

        dateLabel = new JLabel("Date: ");
        date = new JFormattedTextField(dateFormat);
        date.setColumns(20);

        salaryLabel = new JLabel("Salary: ");
        salary = new JFormattedTextField();
        salary.setColumns(20);

        typeLabel = new JLabel("Type: ");
        type = new JComboBox<>(lecturer_type);
        type.setPreferredSize(new Dimension(223, 20));

        departmentListLabel = new JLabel("Department: ");
        departmentList = new JComboBox<>(strArr);
        departmentList.setPreferredSize(new Dimension(223, 20));

        hourRateLabel = new JLabel("Hour Rate: ");
        hourRate = new JFormattedTextField();
        hourRate.setColumns(20);

        contractTimeLabel = new JLabel("Contract Time: ");
        contractTime = new JFormattedTextField();
        contractTime.setColumns(20);

        addLecturerButton = new JButton("Add Lecturer");
        addLecturerButton.setPreferredSize(new Dimension(223, 30));

        cancelButton = new JButton("Cancel");
        cancelButton.setPreferredSize(new Dimension(223, 30));

        Insets layoutInset = new Insets(0, 0, 5, 0);
        Insets innerInset = new Insets(20, 0, 0, 10);

        setLayout(new GridBagLayout());
        GridBagConstraints gridBagConstraints = new GridBagConstraints();
        gridBagConstraints.insets = layoutInset;
        gridBagConstraints.fill = GridBagConstraints.NONE;

        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.anchor = GridBagConstraints.WEST;
        add(staffIdLabel, gridBagConstraints);

        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 1;
        add(staffId, gridBagConstraints);

        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 2;
        gridBagConstraints.anchor = GridBagConstraints.WEST;
        add(nameLabel, gridBagConstraints);

        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 3;
        add(name, gridBagConstraints);

        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 4;
        gridBagConstraints.anchor = GridBagConstraints.WEST;
        add(addressLabel, gridBagConstraints);

        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 5;
        add(address, gridBagConstraints);

        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 6;
        gridBagConstraints.anchor = GridBagConstraints.WEST;
        add(phoneLabel, gridBagConstraints);

        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 7;
        add(phone, gridBagConstraints);

        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 8;
        gridBagConstraints.anchor = GridBagConstraints.WEST;
        add(emailLabel, gridBagConstraints);

        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 9;
        add(email, gridBagConstraints);

        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 10;
        gridBagConstraints.anchor = GridBagConstraints.WEST;
        add(dateLabel, gridBagConstraints);

        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 11;
        add(date, gridBagConstraints);

        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.anchor = GridBagConstraints.WEST;
        add(typeLabel, gridBagConstraints);

        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 1;
        add(type, gridBagConstraints);

        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 2;
        gridBagConstraints.anchor = GridBagConstraints.WEST;
        add(departmentListLabel, gridBagConstraints);

        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 3;
        add(departmentList, gridBagConstraints);

        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 4;
        gridBagConstraints.anchor = GridBagConstraints.WEST;
        add(salaryLabel, gridBagConstraints);

        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 5;
        add(salary, gridBagConstraints);

        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 6;
        gridBagConstraints.anchor = GridBagConstraints.WEST;
        add(hourRateLabel, gridBagConstraints);

        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 7;
        add(hourRate, gridBagConstraints);

        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 8;
        gridBagConstraints.anchor = GridBagConstraints.WEST;
        add(contractTimeLabel, gridBagConstraints);

        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 9;
        add(contractTime, gridBagConstraints);

        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 12;
        gridBagConstraints.insets = innerInset;
        add(addLecturerButton, gridBagConstraints);

        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 12;
        gridBagConstraints.insets = innerInset;
        add(cancelButton, gridBagConstraints);

        hourRateLabel.setVisible(false);
        hourRate.setVisible(false);
        contractTimeLabel.setVisible(false);
        contractTime.setVisible(false);

        type.addActionListener(e -> switchViewAccordingToType());

        setSize(700, 400);
        setLocationRelativeTo(jFrame);

        cancelButton.addActionListener(e -> setVisible(false));
    }

    public String getStaffId() {
        return staffId.getText();
    }

    public String getStaffName() {
        return name.getText();
    }

    public String getStaffAddress() {
        return address.getText();
    }

    public String getStaffNumber() {
        return phone.getText();
    }

    public String getStaffEmail() {
        return email.getText();
    }

    public String getStaffDate() {
        return date.getText();
    }

    public String getStaffSalary() {
        return salary.getText();
    }

    public String getStaffType() {
        return String.valueOf(type.getSelectedItem());
    }

    public String getDepartment() {
        if (departmentList.getItemCount() > 0) {
            return String.valueOf(departmentList.getSelectedItem());
        }
        return "null";
    }

    public String getStaffHourlyRate() {
        return hourRate.getText();
    }

    public String getStaffContractTime() {
        return contractTime.getText();
    }

    public void switchViewAccordingToType() {
        String accountType = String.valueOf(type.getSelectedItem());

        switch (accountType) {
            case "Full-time":
                hourRateLabel.setVisible(false);
                hourRate.setVisible(false);
                contractTimeLabel.setVisible(false);
                contractTime.setVisible(false);
                salaryLabel.setVisible(true);
                salary.setVisible(true);
                break;

            case "Part-time":
                hourRateLabel.setVisible(true);
                hourRate.setVisible(true);
                salaryLabel.setVisible(false);
                salary.setVisible(false);
                contractTimeLabel.setVisible(false);
                contractTime.setVisible(false);
                break;

            case "Contract":
                contractTimeLabel.setVisible(true);
                contractTime.setVisible(true);
                salaryLabel.setVisible(true);
                salary.setVisible(true);
                hourRateLabel.setVisible(false);
                hourRate.setVisible(false);
                break;

        }

    }

    public void saveLecturer(ActionListener actionListener) {
        addLecturerButton.addActionListener(actionListener);
    }

    public void resetLecturerFields() {
        staffId.setText("");
        name.setText("");
        address.setText("");
        phone.setText("");
        email.setText("");
        date.setText("");
        type.setSelectedIndex(0);
        if (departmentList.getItemCount() > 0) {
            departmentList.setSelectedIndex(0);
        }
        salary.setText("");
        hourRate.setText("");
        contractTime.setText("");
    }

}
