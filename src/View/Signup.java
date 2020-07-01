/*
 * Project: university-human-resource
 * Version: 0.1.0
 * File: Signup.java
 * ------
 * Author: Ashish Yadav (contact@ashiish.me)
 * GitHub: https://github.com/ashiishme
 */

package View;

import Model.Database;

import javax.swing.*;
import javax.swing.border.Border;
import javax.swing.border.TitledBorder;
import java.awt.*;
import java.awt.event.ActionListener;
import java.io.File;

@SuppressWarnings("serial")
public class Signup extends JPanel {
    private JLabel unameLabel;
    private JLabel passLabel;
    private JLabel retypePassLabel;
    private JLabel firstnameLabel;
    private JLabel lastnameLabel;
    private JLabel typeLabel;
    private JLabel departmentLabel;

    private JTextField username;
    private JPasswordField password;
    private JPasswordField retypePassword;
    private JTextField firstname;
    private JTextField lastname;
    private JComboBox<String> type;
    private JComboBox<String> departmentList;

    private JButton signupButton;
    private JButton prevLayoutButton;

    private EventListener eventListener;

    public Signup() {
        // left empty
    }

    public Signup(Database database) {
        // Border with title
        Border titledBorder = BorderFactory.createTitledBorder("Create An Account");
        ((TitledBorder) titledBorder).setTitleJustification(TitledBorder.CENTER);
        ((TitledBorder) titledBorder).setTitleFont(new Font("Arial", Font.BOLD, 30));

        // Transparent border
        Border transBorder = BorderFactory.createEmptyBorder(30, 30, 30, 30);
        setBorder(BorderFactory.createCompoundBorder(transBorder, titledBorder));

        signupButton = new JButton("Signup Now!");
        signupButton.setPreferredSize(new Dimension(223, 30));
        prevLayoutButton = new JButton("Go Back");
        prevLayoutButton.setPreferredSize(new Dimension(223, 30));

        // label strings
        String username_text = "Username: ";
        String password_text = "Password: ";
        String reTypePassword_text = "Retype Password: ";
        String firstname_text = "First Name: ";
        String lastname_text = "Last Name: ";
        String type_text = "Account Type: ";
        String department_list = "Select Department: ";
        String[] type_arr = new String[] { "Human Resource", "Department Secretary" };
        String[] strArr = database.loadDepartmentNames(new File("src\\database\\department.txt"));

        unameLabel = new JLabel("<html><span style=''>" + username_text + "</span></html>");
        username = new JTextField(20);

        passLabel = new JLabel("<html><span style=''>" + password_text + "</span></html>");
        password = new JPasswordField(20);

        retypePassLabel = new JLabel("<html><span style=''>" + reTypePassword_text + "</span></html>");
        retypePassword = new JPasswordField(20);

        firstnameLabel = new JLabel("<html><span style=''>" + firstname_text + "</span></html>");
        firstname = new JTextField(20);

        lastnameLabel = new JLabel("<html><span style=''>" + lastname_text + "</span></html>");
        lastname = new JTextField(20);

        typeLabel = new JLabel("<html><span style=''>" + type_text + "</span></html>");
        type = new JComboBox<>(type_arr);
        type.setPreferredSize(new Dimension(223, 20));

        departmentLabel = new JLabel("<html><span>" + department_list + "</span></html>");
        departmentList = new JComboBox<>(strArr);
        departmentList.setPreferredSize(new Dimension(223, 20));

        Insets layoutInset = new Insets(0, 0, 5, 0);
        Insets innerInset = new Insets(20, 0, 0, 0);

        setLayout(new GridBagLayout());
        GridBagConstraints gridBagConstraints = new GridBagConstraints();
        gridBagConstraints.insets = layoutInset;
        gridBagConstraints.fill = GridBagConstraints.NONE;

        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.anchor = GridBagConstraints.WEST;
        // First Name Text
        add(firstnameLabel, gridBagConstraints);

        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 1;
        // First Name Field
        add(firstname, gridBagConstraints);

        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 2;
        gridBagConstraints.anchor = GridBagConstraints.WEST;
        // Last Name Text
        add(lastnameLabel, gridBagConstraints);

        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 3;
        // Last Name Field
        add(lastname, gridBagConstraints);

        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 4;
        gridBagConstraints.anchor = GridBagConstraints.WEST;
        // Username Text
        add(unameLabel, gridBagConstraints);

        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 5;
        // Username Field
        add(username, gridBagConstraints);

        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 6;
        gridBagConstraints.anchor = GridBagConstraints.WEST;
        // Password Text
        add(passLabel, gridBagConstraints);

        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 7;
        // Password Field
        add(password, gridBagConstraints);

        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 8;
        gridBagConstraints.anchor = GridBagConstraints.WEST;
        // Retype Password Text
        add(retypePassLabel, gridBagConstraints);

        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 9;
        // Retype Password Field
        add(retypePassword, gridBagConstraints);

        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 10;
        gridBagConstraints.anchor = GridBagConstraints.WEST;
        // Type Text
        add(typeLabel, gridBagConstraints);

        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 11;
        // Type Field
        add(type, gridBagConstraints);

        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 12;
        gridBagConstraints.anchor = GridBagConstraints.WEST;
        // Type Text
        add(departmentLabel, gridBagConstraints);

        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 13;
        // Type Field
        add(departmentList, gridBagConstraints);

        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 14;
        gridBagConstraints.insets = innerInset;
        // Signup Button
        add(signupButton, gridBagConstraints);

        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 15;
        gridBagConstraints.insets = innerInset;
        // Back Button
        add(prevLayoutButton, gridBagConstraints);

        departmentLabel.setVisible(false);
        departmentList.setVisible(false);

        type.addActionListener(e -> switchViewAccordingToType());

        type.addActionListener(e -> getType());

    }

    // Getters
    public String getFirstName() {
        return firstname.getText();
    }

    public String getLastName() {
        return lastname.getText();
    }

    public String getUserName() {
        return username.getText();
    }

    public String getPassword() {
        return String.valueOf(password.getPassword());
    }

    public String getReTypePassword() {
        return String.valueOf(retypePassword.getPassword());
    }

    public String getType() {
        return String.valueOf(type.getSelectedItem());
    }

    public String getDepartmentList() {
        if (departmentList.getItemCount() > 0) {
            return String.valueOf(departmentList.getSelectedItem());
        }
        return "null";
    }

    void backToLogin(ActionListener actionListener) {
        prevLayoutButton.addActionListener(actionListener);
    }

    // Create an account
    public void createAccount(ActionListener actionListener) {
        signupButton.addActionListener(actionListener);
    }

    public void afterCreateAccount(EventListener eventListener) {
        this.eventListener = eventListener;
    }

    public void accountType() {
        if (eventListener != null) {
            eventListener.selectEvent(getType());
        }
    }

    // switch view
    public void switchViewAccordingToType() {
        String accountType = String.valueOf(type.getSelectedItem());
        switch (accountType) {
            case "Human Resource":
                departmentLabel.setVisible(false);
                departmentList.setVisible(false);
                break;

            case "Department Secretary":
                departmentLabel.setVisible(true);
                departmentList.setVisible(true);
                break;
        }
    }

    // reset
    public void resetFields(boolean bln) {
        if (bln) {
            for (Component component : this.getComponents()) {
                if (component instanceof JTextField) {
                    JTextField jTextField = (JTextField) component;
                    jTextField.setText("");
                }
            }
            type.setSelectedIndex(0);
            if (departmentList.getItemCount() > 0) {
                departmentList.setSelectedIndex(0);
            }
        }
    }

}
