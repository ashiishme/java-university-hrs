/*
 * Project: university-human-resource
 * Version: 0.1.0
 * File: HrController.java
 * ------
 * Author: Ashish Yadav (contact@ashiish.me)
 * GitHub: https://github.com/ashiishme
 */

package Controller;

import Model.Database;
import Model.Department;
import Model.Lecturer;
import View.Departments.AddDepartments;
import View.Departments.EditDepartments;
import View.HR;
import View.Lecturers.AddLecturers;
import View.Lecturers.EditLecturers;

import javax.swing.*;
import java.io.File;

public class HrController extends Controller {

    private AddDepartments addDepartments;
    private EditDepartments editDepartments;
    private AddLecturers addLecturers;
    private EditLecturers editLecturers;
    private HR hr;

    public HrController(Database database, HR hr, AddDepartments addDepartments, EditDepartments editDepartments,
            AddLecturers addLecturers, EditLecturers editLecturers, String departmentFile, String lecturerFile) {
        super(database);
        this.addDepartments = addDepartments;
        this.editDepartments = editDepartments;
        this.addLecturers = addLecturers;
        this.editLecturers = editLecturers;
        this.hr = hr;

        /**
         * Department
         */

        this.addDepartments.saveDepartment(e -> {
            String departmentId;
            String departmentName;
            String departmentType;
            String departmentWebAddress;

            departmentId = addDepartments.getDepartmentId();
            departmentName = addDepartments.getDepartmentName();
            departmentType = addDepartments.getDepartmentType();
            departmentWebAddress = addDepartments.getDepartmentWebAddress();

            if (departmentId.isEmpty()) {
                JOptionPane.showMessageDialog(addDepartments, "Department id is required.", "Error",
                        JOptionPane.ERROR_MESSAGE);
                return;
            } else if (database.ifDepartmentIdExists(new File(departmentFile), departmentId)) {
                JOptionPane.showMessageDialog(addDepartments, "Department id exists.", "Error",
                        JOptionPane.ERROR_MESSAGE);
                return;
            } else if (departmentName.isEmpty()) {
                JOptionPane.showMessageDialog(addDepartments, "Department name is required.", "Error",
                        JOptionPane.ERROR_MESSAGE);
                return;
            } else if (departmentType.isEmpty()) {
                JOptionPane.showMessageDialog(addDepartments, "Department type is required.", "Error",
                        JOptionPane.ERROR_MESSAGE);
                return;
            } else if (departmentWebAddress.isEmpty()) {
                JOptionPane.showMessageDialog(addDepartments, "Department web address is required.", "Error",
                        JOptionPane.ERROR_MESSAGE);
                return;
            }

            database.addDepartment(new Department(departmentId, departmentName, departmentType, departmentWebAddress));
            Object[] newObj = new Object[] { departmentId, departmentName, departmentType, departmentWebAddress };
            hr.addDepartmentToRow(newObj);
            database.saveDepartments(new File(departmentFile));
            this.addDepartments.resetDepartmentFields();
            this.addDepartments.setVisible(false);
        });

        this.hr.editDepartment(e -> {
            String departmentName;
            String departmentType;
            String departmentWebAddress;
            hr.updateDepartment();
            departmentName = hr.getDepartmentName();
            departmentType = hr.getDepartmentType();
            departmentWebAddress = hr.getDepartmentWebAddress();
            this.editDepartments.setDepartmentName(departmentName);
            this.editDepartments.setDepartmentType(departmentType);
            this.editDepartments.setDepartmentWebAddress(departmentWebAddress);
        });

        this.editDepartments.updateDepartment(e -> {
            String departmentName, departmentType, departmentWebAddress;
            departmentName = editDepartments.getDepartmentName();
            departmentType = editDepartments.getDepartmentType();
            departmentWebAddress = editDepartments.getDepartmentWebAddress();
            if (hr.getDepartmentId() != null) {
                String tempName = (departmentName.isEmpty()) ? hr.getDepartmentName() : departmentName;
                String tempType = (departmentType.isEmpty()) ? hr.getDepartmentType() : departmentType;
                String tempWebAddress = (departmentWebAddress.isEmpty()) ? hr.getDepartmentWebAddress()
                        : departmentWebAddress;
                database.addDepartment(new Department(hr.getDepartmentId(), tempName, tempType, tempWebAddress));
                database.updateDepartment();
                editDepartments.resetFields();
                editDepartments.setVisible(false);
            } else {
                JOptionPane.showMessageDialog(addDepartments, "Please select department.", "Error",
                        JOptionPane.ERROR_MESSAGE);
                return;
            }
        });

        this.hr.deleteDepartment(e -> {
            hr.removeDepartment();
            String id = hr.getDepartmentId();
            if (id != null) {
                database.deleteDepartment(id);
            }
        });

        /**
         * Lecturer
         */
        this.addLecturers.saveLecturer(e -> {
            String staffId, staffName, staffAddress, staffPhone, staffEmail, staffStartDate, staffType, staffDepartment,
                    staffSalary, staffHourlyRate, staffContractTime;

            staffId = addLecturers.getStaffId();
            staffName = addLecturers.getStaffName();
            staffAddress = addLecturers.getStaffAddress();
            staffPhone = addLecturers.getStaffNumber();
            staffEmail = addLecturers.getStaffEmail();
            staffStartDate = addLecturers.getStaffDate();
            staffType = addLecturers.getStaffType();
            staffDepartment = addLecturers.getDepartment();
            staffSalary = addLecturers.getStaffSalary();
            staffHourlyRate = addLecturers.getStaffHourlyRate();
            staffContractTime = addLecturers.getStaffContractTime();

            if (staffId.isEmpty()) {
                JOptionPane.showMessageDialog(addLecturers, "Staff id is required.", "Error",
                        JOptionPane.ERROR_MESSAGE);
                return;
            } else if (database.ifLecturerIdExists(new File(lecturerFile), staffId)) {
                JOptionPane.showMessageDialog(addLecturers, "Staff id exists.", "Error", JOptionPane.ERROR_MESSAGE);
                return;
            } else if (staffName.isEmpty()) {
                JOptionPane.showMessageDialog(addLecturers, "Staff name is required.", "Error",
                        JOptionPane.ERROR_MESSAGE);
                return;
            } else if (staffAddress.isEmpty()) {
                JOptionPane.showMessageDialog(addLecturers, "Staff address is required.", "Error",
                        JOptionPane.ERROR_MESSAGE);
                return;
            } else if (staffPhone.isEmpty()) {
                JOptionPane.showMessageDialog(addLecturers, "Staff number is required.", "Error",
                        JOptionPane.ERROR_MESSAGE);
                return;
            } else if (staffEmail.isEmpty()) {
                JOptionPane.showMessageDialog(addLecturers, "Staff email is required.", "Error",
                        JOptionPane.ERROR_MESSAGE);
                return;
            } else if (staffStartDate.isEmpty()) {
                JOptionPane.showMessageDialog(addLecturers, "Staff start date is required.", "Error",
                        JOptionPane.ERROR_MESSAGE);
                return;
            } else if ((staffType.equals("Full-time") || staffType.equals("Contract")) && staffSalary.isEmpty()) {
                JOptionPane.showMessageDialog(addLecturers, "Staff salary is required.", "Error",
                        JOptionPane.ERROR_MESSAGE);
                return;
            } else if (staffType.equals("Part-time") && staffHourlyRate.isEmpty()) {
                JOptionPane.showMessageDialog(addLecturers, "Staff hourly rate is required.", "Error",
                        JOptionPane.ERROR_MESSAGE);
                return;
            } else if (staffType.equals("Contract") && staffContractTime.isEmpty()) {
                JOptionPane.showMessageDialog(addLecturers, "Staff contract time is required.", "Error",
                        JOptionPane.ERROR_MESSAGE);
                return;
            } else if (staffDepartment.equals("null")) {
                JOptionPane.showMessageDialog(addLecturers,
                        "Sorry, you must create department before " + "adding & allocating lecturer staff.", "Error",
                        JOptionPane.ERROR_MESSAGE);
                return;
            }

            switch (staffType) {
                case "Full-time":
                    staffHourlyRate = "N/A";
                    staffContractTime = "N/A";
                    break;
                case "Part-time":
                    staffSalary = "N/A";
                    staffContractTime = "N/A";
                    break;
                case "Contract":
                    staffHourlyRate = "N/A";
                    break;
            }

            database.addLecturer(new Lecturer(staffId, staffName, staffAddress, staffPhone, staffEmail, staffStartDate,
                    staffType, staffDepartment, staffSalary, staffHourlyRate, staffContractTime));
            Object[] newObj = new Object[] { staffId, staffName, staffAddress, staffPhone, staffEmail, staffStartDate,
                    staffType, staffDepartment, staffSalary, staffHourlyRate, staffContractTime };
            hr.addLecturerToRow(newObj);
            database.saveLecturers(new File(lecturerFile));
            this.addLecturers.resetLecturerFields();
            this.addLecturers.setVisible(false);
        });

        this.hr.editLecturer(e -> {
            String staffName, staffAddress, staffPhone, staffEmail, staffStartDate, staffType, staffSalary,
                    staffHourlyRate, staffContractTime;
            hr.updateLecturer();
            staffName = hr.getStaffName();
            staffAddress = hr.getStaffAddr();
            staffPhone = hr.getStaffNum();
            staffEmail = hr.getStaffEmail();
            staffStartDate = hr.getStaffStartDate();
            staffType = hr.getStaffType();
            staffSalary = hr.getStaffSalary();
            staffHourlyRate = hr.getStaffHourlyRate();
            staffContractTime = hr.getStaffContractTime();

            this.editLecturers.setName(staffName);
            this.editLecturers.setAddress(staffAddress);
            this.editLecturers.setPhone(staffPhone);
            this.editLecturers.setEmail(staffEmail);
            this.editLecturers.setDate(staffStartDate);
            this.editLecturers.setType(staffType);
            this.editLecturers.setSalary(staffSalary);
            this.editLecturers.setHourRate(staffHourlyRate);
            this.editLecturers.setContractTime(staffContractTime);
        });

        this.editLecturers.updateLecturer(e -> {
            String staffName, staffAddress, staffPhone, staffEmail, staffStartDate, staffType, staffDepartment,
                    staffSalary, staffHourlyRate, staffContractTime;
            staffName = editLecturers.getName();
            staffAddress = editLecturers.getAddress();
            staffPhone = editLecturers.getPhone();
            staffEmail = editLecturers.getEmail();
            staffStartDate = editLecturers.getDate();
            staffType = editLecturers.getLecturerType();
            staffDepartment = editLecturers.getDepartmentList();
            staffSalary = editLecturers.getSalary();
            staffHourlyRate = editLecturers.getHourlyRate();
            staffContractTime = editLecturers.getContractTIme();
            if (hr.getStaffId() != null) {
                String tempName = (staffName.isEmpty()) ? hr.getStaffName() : staffName;
                String tempAddress = (staffAddress.isEmpty()) ? hr.getStaffAddr() : staffAddress;
                String tempPhone = (staffPhone.isEmpty()) ? hr.getStaffNum() : staffPhone;
                String tempEmail = (staffEmail.isEmpty()) ? hr.getStaffEmail() : staffEmail;
                String tempStartDate = (staffStartDate.isEmpty()) ? hr.getStaffStartDate() : staffStartDate;
                String tempType = (staffType.isEmpty()) ? hr.getStaffType() : staffType;
                String tempDepartment = (staffDepartment.isEmpty()) ? hr.getStaffDepartment() : staffDepartment;
                String tempSalary = (staffSalary.isEmpty()) ? hr.getStaffSalary() : staffSalary;
                String tempHourlyRate = (staffHourlyRate.isEmpty()) ? hr.getStaffHourlyRate() : staffHourlyRate;
                String tempContractTime = (staffContractTime.isEmpty()) ? hr.getStaffContractTime() : staffContractTime;

                database.addLecturer(new Lecturer(hr.getStaffId(), tempName, tempAddress, tempPhone, tempEmail,
                        tempStartDate, tempType, tempDepartment, tempSalary, tempHourlyRate, tempContractTime));
                database.updateLecturer();
                editLecturers.resetFields();
                editLecturers.setVisible(false);
            } else {
                JOptionPane.showMessageDialog(addLecturers, "Please select staff.", "Error", JOptionPane.ERROR_MESSAGE);
                return;
            }
        });

        this.hr.deleteLecturer(e -> {
            hr.removeLecturer();
            String id = hr.getStaffId();
            if (id != null) {
                database.deleteLecturer(id);
            }
        });
    }
}
