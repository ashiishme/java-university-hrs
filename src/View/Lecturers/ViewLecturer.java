/*
 * Project: university-human-resource
 * Version: 0.1.0
 * File: ViewLecturer.java
 * ------
 * Author: Ashish Yadav (contact@ashiish.me)
 * GitHub: https://github.com/ashiishme
 */

package View.Lecturers;

import javax.swing.*;
import java.awt.*;

@SuppressWarnings("serial")
public class ViewLecturer extends JDialog {

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

    private JTextField staffId;
    private JTextField name;
    private JTextField address;
    private JTextField phone;
    private JTextField email;
    private JTextField date;
    private JTextField type;
    private JTextField departmentList;
    private JTextField salary;
    private JTextField hourRate;
    private JTextField contractTime;

    private JButton closeButton;

    public ViewLecturer(JFrame jFrame) {
        super(jFrame, "View Lecturer", false);

        staffIdLabel = new JLabel("Identification Number: ");
        staffId = new JTextField(20);
        nameLabel = new JLabel("Lecturer Name: ");
        name = new JTextField(20);
        addressLabel = new JLabel("Lecturer Address: ");
        address = new JTextField(20);
        phoneLabel = new JLabel("Lecturer Phone: ");
        phone = new JTextField(20);
        emailLabel = new JLabel("Lecturer Email: ");
        email = new JTextField(20);
        dateLabel = new JLabel("Lecturer Date: ");
        date = new JTextField(20);
        typeLabel = new JLabel("Lecturer Type: ");
        type = new JTextField(20);
        departmentListLabel = new JLabel("Lecturer Department: ");
        departmentList = new JTextField(20);
        salaryLabel = new JLabel("Lecturer Salary: ");
        salary = new JTextField(20);
        hourRateLabel = new JLabel("Lecturer Hour Rate: ");
        hourRate = new JTextField(20);
        contractTimeLabel = new JLabel("Lecturer Contract Time: ");
        contractTime = new JTextField(20);
        closeButton = new JButton("Close");

        Insets layoutInset = new Insets(0, 0, 5, 10);
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
        add(closeButton, gridBagConstraints);

        setSize(700, 400);
        setLocationRelativeTo(jFrame);

        staffId.setEditable(false);
        name.setEditable(false);
        address.setEditable(false);
        phone.setEditable(false);
        email.setEditable(false);
        date.setEditable(false);
        type.setEditable(false);
        departmentList.setEditable(false);
        salary.setEditable(false);
        hourRate.setEditable(false);
        contractTime.setEditable(false);

        closeButton.addActionListener(e -> setVisible(false));

    }

    // setters
    public void setStaffId(String id) {
        staffId.setText(id);
    }

    public void setName(String str) {
        name.setText(str);
    }

    public void setAddress(String str) {
        address.setText(str);
    }

    public void setPhone(String str) {
        phone.setText(str);
    }

    public void setEmail(String str) {
        email.setText(str);
    }

    public void setDate(String str) {
        date.setText(str);
    }

    public void setAccountType(String str) {
        type.setText(str);
    }

    public void setDepartmentList(String str) {
        departmentList.setText(str);
    }

    public void setSalary(String str) {
        salary.setText(str);
    }

    public void setHourRate(String str) {
        hourRate.setText(str);
    }

    public void setContractTime(String str) {
        contractTime.setText(str);
    }

}
