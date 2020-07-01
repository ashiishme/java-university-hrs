/*
 * Project: university-human-resource
 * Version: 0.1.0
 * File: LoginController.java
 * ------
 * Author: Ashish Yadav (contact@ashiish.me)
 * GitHub: https://github.com/ashiishme
 */

package Controller;

import Model.Database;
import Model.LoginModel;
import View.Login;
import View.Secretary;

import javax.swing.*;
import java.io.File;

public class LoginController extends Controller {

    private Login login;
    private LoginModel loginModel;
    private Secretary secretary;

    public LoginController(Database database, String loginFile, Login login, LoginModel loginModel,
            Secretary secretary) {
        super(database);
        this.login = login;
        this.loginModel = loginModel;
        this.secretary = secretary;
        this.login.login(e -> {
            String username;
            String password;
            try {
                username = login.getUsername();
                password = login.getPassword();
                if (username.isEmpty()) {
                    JOptionPane.showMessageDialog(login, "Username required.", "Error", JOptionPane.ERROR_MESSAGE);
                    return;
                } else if (password.isEmpty()) {
                    JOptionPane.showMessageDialog(login, "Password required.", "Error", JOptionPane.ERROR_MESSAGE);
                    return;
                }

                this.loginModel.setUsername(username);
                this.loginModel.setPassword(password);

                boolean ifLoggedIn = this.loginModel.loginCheck(new File(loginFile));

                if (ifLoggedIn) {
                    login.ifLoggedIn(this.loginModel.getType());
                    if (this.loginModel.getType().equals("Department Secretary")) {
                        this.secretary.setLecturerDepartment(this.loginModel.getDepartment().trim());
                        this.secretary.getLecturers(
                                this.getLecturersAccordingToDepartment(this.loginModel.getDepartment().trim()));
                    }
                } else {
                    JOptionPane.showMessageDialog(login, "Invalid Username or Password", "Error",
                            JOptionPane.ERROR_MESSAGE);
                }
            } catch (IllegalArgumentException ex) {
                System.out.println("Error: " + ex);
            }
        });
    }
}
