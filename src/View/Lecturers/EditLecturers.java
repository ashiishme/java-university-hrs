/*
 * Project: university-human-resource
 * Version: 0.1.0
 * File: EditLecturers.java
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
public class EditLecturers extends JDialog {

    private JLabel nameLabel;
    private JLabel addressLabel;
    private JLabel phoneLabel;
    private JLabel emailLabel;
    private JLabel dateLabel;
    private JLabel typeLabel;
    private JLabel departmentLabel;
    private JLabel salaryLabel;
    private JLabel hourRateLabel;
    private JLabel contractTimeLabel;

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

    private JButton editLecturerButton;
    private JButton cancelButton;

    public EditLecturers() {
        // left empty
    }

    public EditLecturers(JFrame jFrame, Database database) {
        super(jFrame, "Edit Lecturers", false);

        DateFormat dateFormat = new SimpleDateFormat("mm/dd/yyyy");
        String[] lecturer_type = new String[] { "Full-time", "Part-time", "Contract" };
        String[] strArr = database.loadDepartmentNames(new File("src\\database\\department.txt"));

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

        typeLabel = new JLabel("Type: ");
        type = new JComboBox<>(lecturer_type);
        type.setPreferredSize(new Dimension(223, 20));

        departmentLabel = new JLabel("Department: ");
        departmentList = new JComboBox<>(strArr);
        departmentList.setPreferredSize(new Dimension(223, 20));

        salaryLabel = new JLabel("Salary: ");
        salary = new JFormattedTextField();
        salary.setColumns(20);

        hourRateLabel = new JLabel("Hour Rate: ");
        hourRate = new JFormattedTextField();
        hourRate.setColumns(20);

        contractTimeLabel = new JLabel("Contract Time: ");
        contractTime = new JFormattedTextField();
        contractTime.setColumns(20);

        editLecturerButton = new JButton("Update Lecturer");
        editLecturerButton.setPreferredSize(new Dimension(223, 30));

        cancelButton = new JButton("Cancel");
        cancelButton.setPreferredSize(new Dimension(223, 30));

        new HR();

        Insets layoutInset = new Insets(0, 0, 5, 0);
        Insets innerInset = new Insets(20, 0, 0, 10);

        setLayout(new GridBagLayout());
        GridBagConstraints gridBagConstraints = new GridBagConstraints();
        gridBagConstraints.insets = layoutInset;
        gridBagConstraints.fill = GridBagConstraints.NONE;

        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.anchor = GridBagConstraints.WEST;
        add(nameLabel, gridBagConstraints);

        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 1;
        add(name, gridBagConstraints);

        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 2;
        gridBagConstraints.anchor = GridBagConstraints.WEST;
        add(addressLabel, gridBagConstraints);

        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 3;
        add(address, gridBagConstraints);

        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 4;
        gridBagConstraints.anchor = GridBagConstraints.WEST;
        add(phoneLabel, gridBagConstraints);

        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 5;
        add(phone, gridBagConstraints);

        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 6;
        gridBagConstraints.anchor = GridBagConstraints.WEST;
        add(emailLabel, gridBagConstraints);

        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 7;
        add(email, gridBagConstraints);

        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 8;
        gridBagConstraints.anchor = GridBagConstraints.WEST;
        add(dateLabel, gridBagConstraints);

        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 9;
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
        add(departmentLabel, gridBagConstraints);

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
        gridBagConstraints.gridy = 10;
        gridBagConstraints.insets = innerInset;
        add(editLecturerButton, gridBagConstraints);

        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 10;
        gridBagConstraints.insets = innerInset;
        add(cancelButton, gridBagConstraints);

        setSize(700, 400);
        setLocationRelativeTo(jFrame);

        cancelButton.addActionListener(e -> setVisible(false));

    }

    // Getters & Setters
    public String getName() {
        return name.getText();
    }

    public void setName(String str) {
        name.setText(str);
    }

    public String getAddress() {
        return address.getText();
    }

    public void setAddress(String str) {
        address.setText(str);
    }

    public String getPhone() {
        return phone.getText();
    }

    public void setPhone(String str) {
        phone.setText(str);
    }

    public String getEmail() {
        return email.getText();
    }

    public void setEmail(String str) {
        email.setText(str);
    }

    public String getDate() {
        return date.getText();
    }

    public void setDate(String str) {
        date.setText(str);
    }

    public String getLecturerType() {
        return String.valueOf(type.getSelectedItem());
    }

    public void setType(String str) {
        type.setSelectedItem(str);
    }

    public String getDepartmentList() {
        return String.valueOf(departmentList.getSelectedItem());
    }

    public void setDepartmentList(String str) {
        departmentList.setSelectedItem(str);
    }

    public String getSalary() {
        return salary.getText();
    }

    public void setSalary(String str) {
        salary.setText(str);
    }

    public String getHourlyRate() {
        return hourRate.getText();
    }

    public void setHourRate(String str) {
        hourRate.setText(str);
    }

    public String getContractTIme() {
        return contractTime.getText();
    }

    public void setContractTime(String str) {
        contractTime.setText(str);
    }

    // Listeners
    public void updateLecturer(ActionListener actionListener) {
        editLecturerButton.addActionListener(actionListener);
    }

    public void resetFields() {
        name.setText("");
        address.setText("");
        phone.setText("");
        email.setText("");
        date.setText("");
        type.setSelectedIndex(0);
        departmentList.setSelectedIndex(0);
        salary.setText("");
        hourRate.setText("");
        contractTime.setText("");
    }

}
