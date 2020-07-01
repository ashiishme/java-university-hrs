/*
 * Project: university-human-resource
 * Version: 0.1.0
 * File: LoginModel.java
 * ------
 * Author: Ashish Yadav (contact@ashiish.me)
 * GitHub: https://github.com/ashiishme
 */

package Model;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class LoginModel {

    private int id;
    private String username;
    private String password;
    private String type;
    private String department;

    public LoginModel() {
        // Left Empty
    }

    public LoginModel(String username, String password) {
        this.username = username;
        this.password = password;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public boolean loginCheck(File file) {
        boolean login_status = false;
        try {
            File login_file = new File(String.valueOf(file));
            Scanner scanner = new Scanner(login_file);
            while (scanner.hasNextLine()) {
                String data = scanner.nextLine();
                String[] datas = data.split(", ");
                if (this.username.equals(datas[1]) && this.password.equals(datas[2])) {
                    login_status = true;
                    type = datas[3];
                    department = datas[4];
                    id = Integer.parseInt(datas[0]);
                    break;
                }
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        return login_status;
    }

    public String getType() {
        return type;
    }

    public String getDepartment() {
        return department;
    }

    public int getId() {
        return id;
    }
}
