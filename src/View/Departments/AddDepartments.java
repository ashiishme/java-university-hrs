/*
 * Project: university-human-resource
 * Version: 0.1.0
 * File: AddDepartments.java
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
public class AddDepartments extends JDialog {

    private JLabel departmentIdLabel;
    private JTextField departmentId;
    private JLabel departmentLabel;
    private JTextField departmentName;
    private JLabel departmentTypeLabel;
    private JTextField departmentType;
    private JLabel departmentWebAddressLabel;
    private JTextField departmentWebAddress;
    private JButton addDepartmentButton;
    private JButton cancelButton;

    public AddDepartments() {
        // left empty
    }

    public AddDepartments(JFrame jFrame) {
        super(jFrame, "Add Department", false);
        departmentIdLabel = new JLabel("Department ID: ");
        departmentId = new JTextField(20);
        departmentLabel = new JLabel("Department Name: ");
        departmentName = new JTextField(20);
        departmentTypeLabel = new JLabel("Department Type: ");
        departmentType = new JTextField(20);
        departmentWebAddressLabel = new JLabel("Department Web Address: ");
        departmentWebAddress = new JTextField(20);
        addDepartmentButton = new JButton("Add Department");
        addDepartmentButton.setPreferredSize(new Dimension(223, 30));
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
        add(departmentIdLabel, gridBagConstraints);

        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 1;
        add(departmentId, gridBagConstraints);

        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 2;
        gridBagConstraints.anchor = GridBagConstraints.WEST;
        add(departmentLabel, gridBagConstraints);

        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 3;
        add(departmentName, gridBagConstraints);

        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 4;
        gridBagConstraints.anchor = GridBagConstraints.WEST;
        add(departmentTypeLabel, gridBagConstraints);

        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 5;
        add(departmentType, gridBagConstraints);

        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 6;
        gridBagConstraints.anchor = GridBagConstraints.WEST;
        add(departmentWebAddressLabel, gridBagConstraints);

        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 7;
        add(departmentWebAddress, gridBagConstraints);

        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 8;
        gridBagConstraints.insets = innerInset;
        add(addDepartmentButton, gridBagConstraints);

        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 9;
        gridBagConstraints.insets = innerInset;
        add(cancelButton, gridBagConstraints);

        setSize(500, 400);
        setLocationRelativeTo(jFrame);

        cancelButton.addActionListener(e -> setVisible(false));

    }

    public String getDepartmentId() {
        return departmentId.getText();
    }

    public String getDepartmentName() {
        return departmentName.getText();
    }

    public String getDepartmentType() {
        return departmentType.getText();
    }

    public String getDepartmentWebAddress() {
        return departmentWebAddress.getText();
    }

    public void saveDepartment(ActionListener actionListener) {
        addDepartmentButton.addActionListener(actionListener);
    }

    public void resetDepartmentFields() {
        departmentId.setText("");
        departmentName.setText("");
        departmentType.setText("");
        departmentWebAddress.setText("");
    }
}
