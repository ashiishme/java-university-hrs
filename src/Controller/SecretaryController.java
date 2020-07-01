/*
 * Project: university-human-resource
 * Version: 0.1.0
 * File: SecretaryController.java
 * ------
 * Author: Ashish Yadav (contact@ashiish.me)
 * GitHub: https://github.com/ashiishme
 */

package Controller;

import Model.Database;
import View.Lecturers.ViewLecturer;
import View.Secretary;

import javax.swing.*;
import java.io.File;

public class SecretaryController extends Controller {
    private Secretary secretary;
    private ViewLecturer viewLecturer;

    public SecretaryController(Database database, Secretary secretary, ViewLecturer viewLecturer, String lecturerFile) {
        super(database);
        this.secretary = secretary;
        this.viewLecturer = viewLecturer;
        this.secretary.searchLecturer(e -> {
            String id, department;
            id = secretary.getLecturerId();
            department = secretary.getLecturerDepartment();
            if (id.isEmpty()) {
                JOptionPane.showMessageDialog(secretary, "Please enter lecturer staff id.", "Error",
                        JOptionPane.ERROR_MESSAGE);
                this.viewLecturer.setVisible(false);
                return;
            }
            String[] datas = database.queryLecturerById(new File(lecturerFile), department, id);
            if (datas[0] != null) {
                this.viewLecturer.setStaffId(datas[0].trim());
                this.viewLecturer.setName(datas[1].trim());
                this.viewLecturer.setAddress(datas[2].trim());
                this.viewLecturer.setPhone(datas[3].trim());
                this.viewLecturer.setEmail(datas[4].trim());
                this.viewLecturer.setDate(datas[5].trim());
                this.viewLecturer.setAccountType(datas[6].trim());
                this.viewLecturer.setDepartmentList(datas[7].trim());
                this.viewLecturer.setSalary(datas[8].trim());
                this.viewLecturer.setHourRate(datas[9].trim());
                this.viewLecturer.setContractTime(datas[10].trim());
            } else {
                JOptionPane.showMessageDialog(secretary, "No leturer found.", "Error", JOptionPane.ERROR_MESSAGE);
                this.viewLecturer.setVisible(false);
                return;
            }
        });
    }
}
