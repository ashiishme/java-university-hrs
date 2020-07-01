/*
 * Project: university-human-resource
 * Version: 0.1.0
 * File: Login.java
 * ------
 * Author: Ashish Yadav (contact@ashiish.me)
 * GitHub: https://github.com/ashiishme
 */

package View;

import javax.swing.*;
import javax.swing.border.Border;
import javax.swing.border.TitledBorder;
import java.awt.*;
import java.awt.event.ActionListener;

@SuppressWarnings("serial")
public class Login extends JPanel {
    private String uPlaceHolder = "Username: ";
    private String pPlaceHolder = "Password: ";
    private String username;
    private String password;

    private JLabel signupLabel;
    private JLabel uLabel;
    private JLabel pLabel;

    private JTextField uField;
    private JPasswordField pField;

    private JButton loginButton;
    private JButton signupButton;

    private EventListener eventListener;

    public Login() {
        // Border with title
        Border titledBorder = BorderFactory.createTitledBorder("Login");
        ((TitledBorder) titledBorder).setTitleJustification(TitledBorder.CENTER);
        ((TitledBorder) titledBorder).setTitleFont(new Font("Arial", Font.BOLD, 30));

        // Transparent border
        Border transBorder = BorderFactory.createEmptyBorder(30, 30, 30, 30);
        setBorder(BorderFactory.createCompoundBorder(transBorder, titledBorder));

        uLabel = new JLabel("<html><span style=''>" + uPlaceHolder + "</span></html>");
        uField = new JTextField(20);

        pLabel = new JLabel("<html><span style=''>" + pPlaceHolder + "</span></html>");
        pField = new JPasswordField(20);

        signupLabel = new JLabel("Not a member yet?");

        loginButton = new JButton("Login");
        loginButton.setPreferredSize(new Dimension(223, 30));
        signupButton = new JButton("Sign up");
        signupButton.setPreferredSize(new Dimension(223, 30));

        Insets layoutInset = new Insets(0, 0, 5, 0);
        Insets innerInset = new Insets(20, 0, 0, 0);
        setLayout(new GridBagLayout());
        GridBagConstraints gridBagConstraints = new GridBagConstraints();
        gridBagConstraints.insets = layoutInset;
        gridBagConstraints.fill = GridBagConstraints.NONE;

        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.anchor = GridBagConstraints.WEST;
        // Username Text
        add(uLabel, gridBagConstraints);

        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 1;

        // Username Field
        add(uField, gridBagConstraints);

        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 2;
        gridBagConstraints.anchor = GridBagConstraints.WEST;
        // Password Text
        add(pLabel, gridBagConstraints);

        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 3;
        // Password Field
        add(pField, gridBagConstraints);

        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 4;
        gridBagConstraints.insets = innerInset;
        // Login Button
        add(loginButton, gridBagConstraints);

        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 5;
        gridBagConstraints.insets = innerInset;
        // Login Button
        add(signupLabel, gridBagConstraints);

        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 6;
        gridBagConstraints.insets = innerInset;
        // Login Button
        add(signupButton, gridBagConstraints);
    }

    // get username
    public String getUsername() {
        username = uField.getText();
        return username;
    }

    public String getPassword() {
        password = String.valueOf(pField.getPassword());
        return password;
    }

    // login fields reset
    public void reset(boolean status) {
        if (status) {
            uField.setText("");
            pField.setText("");
        }
    }

    public void login(ActionListener actionListener) {
        loginButton.addActionListener(actionListener);
    }

    public void afterLogin(EventListener eventListener) {
        this.eventListener = eventListener;
    }

    public void ifLoggedIn(String key) {
        if (eventListener != null) {
            eventListener.clickEvent(key);
        }
    }

    public void singUpView(ActionListener actionListener) {
        signupButton.addActionListener(actionListener);
    }

}
