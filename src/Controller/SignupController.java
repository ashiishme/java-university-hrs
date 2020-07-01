/*
 * Project: university-human-resource
 * Version: 0.1.0
 * File: SignupController.java
 * ------
 * Author: Ashish Yadav (contact@ashiish.me)
 * GitHub: https://github.com/ashiishme
 */

package Controller;

import Model.Database;
import Model.User;
import View.Secretary;
import View.Signup;

import javax.swing.*;
import java.io.File;

public class SignupController extends Controller {

    private Signup signup;

    private Secretary secretary;

    public SignupController(Database database, String databaseFile, String loginFile, Signup signup,
            Secretary secretary) {
        super(database);
        this.signup = signup;
        this.secretary = secretary;
        this.signup.createAccount(e -> {
            int id;
            String firstname;
            String lastname;
            String username;
            String password;
            String retypePassword;
            String type;
            String department;
            id = Integer.parseInt(String.valueOf((database.getMaximumId(new File(databaseFile)))));
            firstname = signup.getFirstName();
            lastname = signup.getLastName();
            username = signup.getUserName();
            password = signup.getPassword();
            retypePassword = signup.getReTypePassword();
            type = signup.getType();
            department = signup.getDepartmentList();

            if (firstname.isEmpty()) {
                JOptionPane.showMessageDialog(signup, "First Name Required.", "Error", JOptionPane.ERROR_MESSAGE);
                return;
            } else if (lastname.isEmpty()) {
                JOptionPane.showMessageDialog(signup, "Last Name Required.", "Error", JOptionPane.ERROR_MESSAGE);
                return;
            } else if (username.isEmpty()) {
                JOptionPane.showMessageDialog(signup, "Username Required.", "Error", JOptionPane.ERROR_MESSAGE);
                return;
            } else if (database.ifUsernameExists(new File(databaseFile), username)) {
                JOptionPane.showMessageDialog(signup, "Username Already Exists.", "Error", JOptionPane.ERROR_MESSAGE);
                return;
            } else if (password.isEmpty()) {
                JOptionPane.showMessageDialog(signup, "Password Required.", "Error", JOptionPane.ERROR_MESSAGE);
                return;
            } else if (retypePassword.isEmpty()) {
                JOptionPane.showMessageDialog(signup, "Please Re-type your password.", "Error",
                        JOptionPane.ERROR_MESSAGE);
                return;
            } else if (!password.equals(retypePassword)) {
                JOptionPane.showMessageDialog(signup, "Password does not match.", "Error", JOptionPane.ERROR_MESSAGE);
                return;
            } else if (type.isEmpty()) {
                JOptionPane.showMessageDialog(signup, "Select account type.", "Error", JOptionPane.ERROR_MESSAGE);
                return;
            } else if (type.equals("Department Secretary") && department.equals("null")) {
                JOptionPane.showMessageDialog(signup, "Sorry, there is no department "
                        + "available to create department secretary account. Please contact human " + "resource staff.",
                        "Error", JOptionPane.ERROR_MESSAGE);
                return;
            }

            switch (type) {
                case "Human Resource":
                    department = "N/A";
                    break;
            }

            database.addUser(new User(id, firstname, lastname, username, password, type, department));
            database.saveToDatabase(new File(databaseFile));
            database.saveLogin(new File(loginFile));
            signup.accountType();
            if (signup.getType().equals("Department Secretary")) {
                this.secretary.setLecturerDepartment(signup.getDepartmentList().trim());
                this.secretary.getLecturers(this.getLecturersAccordingToDepartment(signup.getDepartmentList().trim()));
            }
            signup.resetFields(true);
        });

    }

}
