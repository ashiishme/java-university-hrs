/*
 * Project: university-human-resource
 * Version: 0.1.0
 * File: Lecturer.java
 * ------
 * Author: Ashish Yadav (contact@ashiish.me)
 * GitHub: https://github.com/ashiishme
 */

package Model;

public class Lecturer {

    private String staffId;
    private String name;
    private String address;
    private String phone;
    private String email;
    private String date;
    private String type;
    private String department;
    private String salary;
    private String hourRate;
    private String contractTime;

    public Lecturer() {
        // left empty
    }

    public Lecturer(String staffId, String name, String address, String phone, String email, String date, String type,
            String department, String salary, String hourRate, String contractTime) {
        this.staffId = staffId;
        this.name = name;
        this.address = address;
        this.phone = phone;
        this.email = email;
        this.date = date;
        this.type = type;
        this.department = department;
        this.salary = salary;
        this.hourRate = hourRate;
        this.contractTime = contractTime;
    }

    public String getStaffId() {
        return staffId;
    }

    public String getName() {
        return name;
    }

    public String getAddress() {
        return address;
    }

    public String getPhone() {
        return phone;
    }

    public String getEmail() {
        return email;
    }

    public String getDate() {
        return date;
    }

    public String getStaffType() {
        return type;
    }

    public String getDepartment() {
        return department;
    }

    public String getSalary() {
        return salary;
    }

    public String getHourRate() {
        return hourRate;
    }

    public String getContractTime() {
        return contractTime;
    }

}
