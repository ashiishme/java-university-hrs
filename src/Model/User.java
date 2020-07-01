/*
 * Project: university-human-resource
 * Version: 0.1.0
 * File: User.java
 * ------
 * Author: Ashish Yadav (contact@ashiish.me)
 * GitHub: https://github.com/ashiishme
 */

package Model;

public class User {
    private int id;
    private String firstname;
    private String lastname;
    private String username;
    private String password;
    private String type;
    private String department;

    public User() {
        // Empty constructor
    }

    public User(int id, String firstname, String lastname, String username, String password, String type,
            String department) {
        this.id = ++id;
        this.firstname = firstname;
        this.lastname = lastname;
        this.username = username;
        this.password = password;
        this.type = type;
        this.department = department;
    }

    public int getId() {
        return id;
    }

    public String getFirstname() {
        return firstname;
    }

    public String getLastname() {
        return lastname;
    }

    public String getUsername() {
        return username;
    }

    public String getPassword() {
        return password;
    }

    public String getType() {
        return type;
    }

    public String getDepartment() {
        return department;
    }
}
