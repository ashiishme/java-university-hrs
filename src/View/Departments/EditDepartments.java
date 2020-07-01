/*
 * Project: university-human-resource
 * Version: 0.1.0
 * File: EditDepartments.java
 * ------
 * Author: Ashish Yadav (contact@ashiish.me)
 * GitHub: https://github.com/ashiishme
 */

package View.Departments;

import View.HR;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;

@SuppressWarnings("serial")
public class EditDepartments extends JDialog {

    private JLabel departmentLabel;
    private JTextField departmentName;
    private JLabel departmentTypeLabel;
    private JTextField departmentType;
    private JLabel departmentWebAddressLabel;
    private JTextField departmentWebAddress;
    private JButton updateDepartmentButton;
    private JButton cancelButton;

    public EditDepartments() {
        // left empty
    }

    public EditDepartments(JFrame jFrame) {
        super(jFrame, "Edit Department", false);
        departmentLabel = new JLabel("Department Name: ");
        departmentName = new JTextField(20);
        departmentTypeLabel = new JLabel("Department Type: ");
        departmentType = new JTextField(20);
        departmentWebAddressLabel = new JLabel("Department Web Address: ");
        departmentWebAddress = new JTextField(20);
        updateDepartmentButton = new JButton("Update Department");
        updateDepartmentButton.setPreferredSize(new Dimension(223, 30));
        cancelButton = new JButton("Cancel");
        cancelButton.setPreferredSize(new Dimension(223, 30));
        new HR();

        Insets layoutInset = new Insets(0, 0, 5, 0);
        Insets innerInset = new Insets(20, 0, 0, 0);

        setLayout(new GridBagLayout());
        GridBagConstraints gridBagConstraints = new GridBagConstraints();
        gridBagConstraints.insets = layoutInset;
        gridBagConstraints.fill = GridBagConstraints.NONE;

        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.anchor = GridBagConstraints.WEST;
        add(departmentLabel, gridBagConstraints);

        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 1;
        add(departmentName, gridBagConstraints);

        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 2;
        gridBagConstraints.anchor = GridBagConstraints.WEST;
        add(departmentTypeLabel, gridBagConstraints);

        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 3;
        add(departmentType, gridBagConstraints);

        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 4;
        gridBagConstraints.anchor = GridBagConstraints.WEST;
        add(departmentWebAddressLabel, gridBagConstraints);

        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 5;
        add(departmentWebAddress, gridBagConstraints);

        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 6;
        gridBagConstraints.insets = innerInset;
        add(updateDepartmentButton, gridBagConstraints);

        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 7;
        gridBagConstraints.insets = innerInset;
        add(cancelButton, gridBagConstraints);

        setSize(500, 400);
        setLocationRelativeTo(jFrame);

        cancelButton.addActionListener(e -> setVisible(false));

    }

    // Getters & Setters
    public void setDepartmentName(String name) {
        departmentName.setText(name);
    }

    public String getDepartmentName() {
        return departmentName.getText();
    }

    public void setDepartmentType(String type) {
        departmentType.setText(type);
    }

    public String getDepartmentType() {
        return departmentType.getText();
    }

    public void setDepartmentWebAddress(String web) {
        departmentWebAddress.setText(web);
    }

    public String getDepartmentWebAddress() {
        return departmentWebAddress.getText();
    }

    // Listeners
    public void updateDepartment(ActionListener actionListener) {
        updateDepartmentButton.addActionListener(actionListener);
    }

    public void resetFields() {
        departmentName.setText("");
        departmentType.setText("");
        departmentWebAddress.setText("");
    }
}
