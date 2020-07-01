/*
 * Project: university-human-resource
 * Version: 0.1.0
 * File: Department.java
 * ------
 * Author: Ashish Yadav (contact@ashiish.me)
 * GitHub: https://github.com/ashiishme
 */

package Model;

public class Department {

    private String departmentId;
    private String departmentName;
    private String departmentType;
    private String departmentWebAddress;

    public Department() {
        // Left Empty
    }

    public Department(String departmentId, String departmentName, String departmentType, String departmentWebAddress) {
        this.departmentId = departmentId;
        this.departmentName = departmentName;
        this.departmentType = departmentType;
        this.departmentWebAddress = departmentWebAddress;
    }

    public String getDepartmentId() {
        return departmentId;
    }

    public String getDepartmentName() {
        return departmentName;
    }

    public String getDepartmentType() {
        return departmentType;
    }

    public String getDepartmentWebAddress() {
        return departmentWebAddress;
    }
}
