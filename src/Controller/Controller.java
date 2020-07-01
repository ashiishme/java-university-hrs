/*
 * Project: university-human-resource
 * Version: 0.1.0
 * File: Controller.java
 * ------
 * Author: Ashish Yadav (contact@ashiish.me)
 * GitHub: https://github.com/ashiishme
 */

package Controller;

import Model.Database;

import java.io.File;

public class Controller {

    private String departmentFile = "src\\database\\department.txt";
    private String lecturerFile = "src\\database\\lecturer.txt";
    private Database database;

    public Controller() {
        // left empty;
    }

    public Controller(Database database) {
        this.database = database;
    }

    public Object[] getDepartments() {
        return database.loadDepartments(new File(departmentFile));
    }

    public Object[] getLecturers() {
        return database.loadLecturers(new File(lecturerFile));
    }

    public Object[] getLecturersAccordingToDepartment(String department) {
        return database.loadLecturersAccordingToDepartment(new File(lecturerFile), department.trim());
    }

}
