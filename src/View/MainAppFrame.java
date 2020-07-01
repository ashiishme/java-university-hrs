/*
 * Project: university-human-resource
 * Version: 0.1.0
 * File: MainAppFrame.java
 * ------
 * Author: Ashish Yadav (contact@ashiish.me)
 * GitHub: https://github.com/ashiishme
 */

package View;

import Controller.Controller;
import Controller.LoginController;
import Controller.SignupController;
import Controller.HrController;
import Controller.SecretaryController;
import Model.Database;
import Model.LoginModel;
import View.Departments.AddDepartments;
import View.Departments.EditDepartments;
import View.Lecturers.AddLecturers;
import View.Lecturers.EditLecturers;
import View.Lecturers.ViewLecturer;

import javax.swing.*;
import java.awt.*;

@SuppressWarnings("serial")
public class MainAppFrame extends JFrame {

    // Controllers
    private Controller controller;
    // Models
    private Database database;
    private LoginModel loginModel;
    // Card Layout
    private CardLayout cardLayout;
    // Views
    private Login login;
    private Signup signup;
    private HR hr;
    private Secretary secretary;
    // Views > Departments
    private AddDepartments addDepartments;
    private EditDepartments editDepartments;
    // Views > Lecturers
    private AddLecturers addLecturers;
    private EditLecturers editLecturers;
    private ViewLecturer viewLecturer;

    public MainAppFrame() {
        super("University HRS");

        cardLayout = new CardLayout();
        setLayout(cardLayout);
        database = new Database();
        login = new Login();
        signup = new Signup(database);
        hr = new HR();
        secretary = new Secretary();
        loginModel = new LoginModel();
        addDepartments = new AddDepartments(this);
        editDepartments = new EditDepartments(this);
        addLecturers = new AddLecturers(this, database);
        editLecturers = new EditLecturers(this, database);
        viewLecturer = new ViewLecturer(this);
        // File Paths
        String databaseFile = "src\\database\\database.txt";
        String loginFile = "src\\database\\login.txt";
        String departmentFile = "src\\database\\department.txt";
        String lecturerFile = "src\\database\\lecturer.txt";

        controller = new Controller(database);
        new SignupController(database, databaseFile, loginFile, signup, secretary);
        new LoginController(database, loginFile, login, loginModel, secretary);
        new HrController(database, hr, addDepartments, editDepartments, addLecturers, editLecturers, departmentFile,
                lecturerFile);
        new SecretaryController(database, secretary, viewLecturer, lecturerFile);

        add(login, "login");
        add(signup, "signup");
        add(hr, "Human Resource");
        add(secretary, "Department Secretary");

        hr.getDepartments(controller.getDepartments());
        hr.getLecturers(controller.getLecturers());

        hr.addDepartment(e -> addDepartments.setVisible(true));

        hr.editDepartment(e -> editDepartments.setVisible(true));
        hr.addLecturer(e -> addLecturers.setVisible(true));
        hr.editLecturer(e -> editLecturers.setVisible(true));
        secretary.searchLecturer(e -> viewLecturer.setVisible(true));

        // Switch layouts
        login.singUpView(e -> cardLayout.show(MainAppFrame.this.getContentPane(), "signup"));
        signup.backToLogin(e -> cardLayout.show(MainAppFrame.this.getContentPane(), "login"));

        // switch layout according to account type

        login.afterLogin(new EventListener() {
            @Override
            public void clickEvent(String key) {
                cardLayout.show(MainAppFrame.this.getContentPane(), key);
            }

            @Override
            public void selectEvent(String key) {
                // left empty
            }
        });
        signup.afterCreateAccount(new EventListener() {
            @Override
            public void clickEvent(String key) {
                // left empty
            }

            @Override
            public void selectEvent(String key) {
                cardLayout.show(MainAppFrame.this.getContentPane(), key);
            }
        });

        hr.logout(e -> {
            JOptionPane.showMessageDialog(MainAppFrame.this.getContentPane(),
                    "Do you want to logout and exit the system?", "Notice", JOptionPane.INFORMATION_MESSAGE);
            MainAppFrame.this.dispose();
        });

        secretary.logout(e -> {
            JOptionPane.showMessageDialog(MainAppFrame.this.getContentPane(),
                    "Do you want to logout and exit the system?", "Notice", JOptionPane.INFORMATION_MESSAGE);
            MainAppFrame.this.dispose();
        });

        setSize(1200, 600);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);
    }
}
