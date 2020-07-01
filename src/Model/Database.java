/*
 * Project: university-human-resource
 * Version: 0.1.0
 * File: Database.java
 * ------
 * Author: Ashish Yadav (contact@ashiish.me)
 * GitHub: https://github.com/ashiishme
 */

package Model;

import java.io.*;
import java.util.ArrayList;
import java.util.Scanner;

public class Database {

    private ArrayList<User> userList;
    private ArrayList<Department> departmentList;
    private ArrayList<Lecturer> lecturerList;
    private Department department;
    private Lecturer lecturer;

    public Database() {
        userList = new ArrayList<>();
        departmentList = new ArrayList<>();
        lecturerList = new ArrayList<>();
        department = new Department();
        lecturer = new Lecturer();
    }

    /**
     * Users
     */

    public void addUser(User user) {
        userList.add(user);
    }

    public ArrayList<User> getUserList() {
        return userList;
    }

    public void saveToDatabase(File file) {
        try {
            User user;
            String data = "";
            BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(file, true));
            int i = 0;
            while (i < userList.size()) {
                user = userList.get(i);
                data = user.getId() + ", " + user.getFirstname() + ", " + user.getLastname() + ", " + user.getUsername()
                        + ", " + user.getPassword() + ", " + user.getType() + ", " + user.getDepartment();
                i++;
            }
            bufferedWriter.write(data);
            bufferedWriter.newLine();
            bufferedWriter.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void saveLogin(File file) {
        try {
            User user;
            String data = "";
            BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(file, true));
            int i = 0;
            while (i < userList.size()) {
                user = userList.get(i);
                data = user.getId() + ", " + user.getUsername() + ", " + user.getPassword() + ", " + user.getType()
                        + ", " + user.getDepartment();
                i++;
            }
            bufferedWriter.write(data);
            bufferedWriter.newLine();
            bufferedWriter.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public boolean ifUsernameExists(File file, String string) {
        Scanner scanner = null;
        try {
            File file1 = new File(String.valueOf(file));
            scanner = new Scanner(file1);
            while (scanner.hasNextLine()) {
                String data = scanner.nextLine();
                String[] datas = data.split(", ");
                if (datas[3].equals(string)) {
                    scanner.close();
                    return true;
                }
            }

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }

        return false;
    }

    public int getMaximumId(File file) {
        int maximum = 0;
        try {
            File databaseFile = new File(String.valueOf(file));
            Scanner scanner = new Scanner(databaseFile);
            while (scanner.hasNextLine()) {
                String data = scanner.nextLine();
                String[] datas = data.split(", ");
                int id = Integer.parseInt(datas[0]);
                if (id > maximum) {
                    maximum = id;
                }
            }
            scanner.close();
            return maximum;
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        return maximum;
    }

    /**
     * Departments
     */

    public void addDepartment(Department department) {
        departmentList.add(department);
    }

    public void saveDepartments(File file) {
        try {
            String data = "";
            BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(file, true));
            for (Department d : departmentList) {
                department = d;
                data = department.getDepartmentId() + ", " + department.getDepartmentName() + ", "
                        + department.getDepartmentType() + ", " + department.getDepartmentWebAddress();
            }
            bufferedWriter.write(data);
            bufferedWriter.newLine();
            bufferedWriter.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public String[] loadDepartmentNames(File file) {
        try {
            BufferedReader bufferedReader = new BufferedReader(new FileReader(file));
            ArrayList<String> list = new ArrayList<>();
            String s;
            while ((s = bufferedReader.readLine()) != null) {
                String[] str = s.split(",");
                list.add(str[1]);
            }
            bufferedReader.close();
            return list.toArray(new String[] {});
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }

    public Object[] loadDepartments(File file) {
        Object[] objects;
        try {
            BufferedReader bufferedReader = new BufferedReader(new FileReader(file));
            objects = bufferedReader.lines().toArray();
            bufferedReader.close();
            return objects;
        } catch (IOException e) {
            e.printStackTrace();
        }

        return null;
    }

    public void updateDepartment() {
        File oldFile = new File("src/database/department.txt");
        File tempFile = new File("src/database/departmentTemp.txt");
        boolean success = false;
        String[] objects = new String[4];
        for (Department department : departmentList) {
            objects[0] = String.valueOf(department.getDepartmentId()).trim();
            objects[1] = department.getDepartmentName().trim();
            objects[2] = department.getDepartmentType().trim();
            objects[3] = department.getDepartmentWebAddress().trim();
        }
        ArrayList<String> tempList = new ArrayList<>();
        try {
            if (!tempFile.exists()) {
                tempFile.createNewFile();
            }
            Scanner scanner = new Scanner(new File(String.valueOf(oldFile)));
            while (scanner.hasNextLine()) {
                tempList.add(scanner.nextLine());
            }
            String id = objects[0];
            for (String str : tempList) {
                if (str.contains(id + ",")) {
                    int index = tempList.indexOf(str);
                    String data = objects[0] + ", " + objects[1] + ", " + objects[2] + ", " + objects[3];
                    tempList.set(index, data);
                }
            }
            BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(tempFile));
            for (String str : tempList) {
                bufferedWriter.write(str);
                bufferedWriter.newLine();
            }
            scanner.close();
            bufferedWriter.close();
            success = true;
        } catch (IOException e) {
            e.printStackTrace();
        }
        if (success) {
            renameFile(oldFile, tempFile);
        }
    }

    public void deleteDepartment(String id) {
        File oldFile = new File("src/database/department.txt");
        File tempFile = new File("src/database/departmentTemp.txt");
        boolean success = false;
        ArrayList<String> tempList = new ArrayList<>();
        try {
            if (!tempFile.exists()) {
                tempFile.createNewFile();
            }
            Scanner scanner = new Scanner(new File(String.valueOf(oldFile)));
            while (scanner.hasNextLine()) {
                tempList.add(scanner.nextLine());
            }
            tempList.removeIf(string -> string.contains(id));
            BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(tempFile));
            for (String string : tempList) {
                bufferedWriter.write(string);
                bufferedWriter.newLine();
            }
            scanner.close();
            bufferedWriter.close();
            success = true;
        } catch (IOException e) {
            e.printStackTrace();
        }
        if (success) {
            renameFile(oldFile, tempFile);
        }
    }

    public boolean ifDepartmentIdExists(File file, String string) {
        Scanner scanner = null;
        try {
            File file1 = new File(String.valueOf(file));
            scanner = new Scanner(file1);
            while (scanner.hasNextLine()) {
                String data = scanner.nextLine();
                String[] datas = data.split(", ");
                if (datas[0].equals(string)) {
                    scanner.close();
                    return true;
                }
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        return false;
    }

    /**
     * Lecturers
     */

    public void addLecturer(Lecturer lecturer) {
        lecturerList.add(lecturer);
    }

    public void saveLecturers(File file) {
        try {
            String data = "";
            BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(file, true));
            for (Lecturer l : lecturerList) {
                lecturer = l;
                data = lecturer.getStaffId() + ", " + lecturer.getName() + ", " + lecturer.getAddress() + ", "
                        + lecturer.getPhone() + ", " + lecturer.getEmail() + ", " + lecturer.getDate() + ", "
                        + lecturer.getStaffType() + ", " + lecturer.getDepartment() + ", " + lecturer.getSalary() + ", "
                        + lecturer.getHourRate() + ", " + lecturer.getContractTime();
            }
            bufferedWriter.write(data);
            bufferedWriter.newLine();
            bufferedWriter.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public Object[] loadLecturers(File file) {
        Object[] objects;
        try {
            BufferedReader bufferedReader = new BufferedReader(new FileReader(file));
            objects = bufferedReader.lines().toArray();
            bufferedReader.close();
            return objects;
        } catch (IOException e) {
            e.printStackTrace();
        }

        return null;
    }

    public Object[] loadLecturersAccordingToDepartment(File file, String department) {
        try {
            BufferedReader bufferedReader = new BufferedReader(new FileReader(file));
            ArrayList<String> lecturersList = new ArrayList<>();
            String s;
            while ((s = bufferedReader.readLine()) != null) {
                String[] str = s.split(",");
                if (str[7].trim().equals(department.trim())) {
                    String data = str[0] + ", " + str[1] + ", " + str[2] + ", " + str[3] + ", " + str[4] + ", " + str[5]
                            + ", " + str[6] + ", " + str[7] + ", " + str[8] + ", " + str[9] + ", " + str[10];
                    lecturersList.add(data);
                }
            }
            bufferedReader.close();
            return lecturersList.toArray(new Object[] {});
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }

    public void updateLecturer() {
        File oldFile = new File("src/database/lecturer.txt");
        File tempFile = new File("src/database/lecturerTemp.txt");
        boolean success = false;
        String[] objects = new String[11];
        for (Lecturer lecturer : lecturerList) {
            objects[0] = lecturer.getStaffId().trim();
            objects[1] = lecturer.getName().trim();
            objects[2] = lecturer.getAddress().trim();
            objects[3] = lecturer.getPhone().trim();
            objects[4] = lecturer.getEmail().trim();
            objects[5] = lecturer.getDate().trim();
            objects[6] = lecturer.getStaffType().trim();
            objects[7] = lecturer.getDepartment().trim();
            objects[8] = lecturer.getSalary().trim();
            objects[9] = lecturer.getHourRate().trim();
            objects[10] = lecturer.getContractTime().trim();
        }
        ArrayList<String> tempList = new ArrayList<>();
        try {
            if (!tempFile.exists()) {
                tempFile.createNewFile();
            }
            Scanner scanner = new Scanner(new File(String.valueOf(oldFile)));
            while (scanner.hasNextLine()) {
                tempList.add(scanner.nextLine());
            }
            String id = objects[0];
            System.out.println("ID: " + id);
            for (String str : tempList) {
                if (str.contains(id + ",")) {
                    int index = tempList.indexOf(str);
                    String data = objects[0] + ", " + objects[1] + ", " + objects[2] + ", " + objects[3] + ", "
                            + objects[4] + ", " + objects[5] + ", " + objects[6] + ", " + objects[7] + ", " + objects[8]
                            + ", " + objects[9] + ", " + objects[10];
                    tempList.set(index, data);
                }
            }
            BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(tempFile));
            for (String str : tempList) {
                bufferedWriter.write(str);
                bufferedWriter.newLine();
            }
            scanner.close();
            bufferedWriter.close();
            success = true;
        } catch (IOException e) {
            e.printStackTrace();
        }
        if (success) {
            renameFile(oldFile, tempFile);
        }
    }

    public void deleteLecturer(String id) {
        File oldFile = new File("src/database/lecturer.txt");
        File tempFile = new File("src/database/lecturerTemp.txt");
        boolean success = false;
        ArrayList<String> tempList = new ArrayList<>();
        try {
            if (!tempFile.exists()) {
                tempFile.createNewFile();
            }
            Scanner scanner = new Scanner(new File(String.valueOf(oldFile)));
            while (scanner.hasNextLine()) {
                tempList.add(scanner.nextLine());
            }
            tempList.removeIf(string -> string.contains(id));
            BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(tempFile));
            for (String string : tempList) {
                bufferedWriter.write(string);
                bufferedWriter.newLine();
            }
            scanner.close();
            bufferedWriter.close();
            success = true;
        } catch (IOException e) {
            e.printStackTrace();
        }
        if (success) {
            renameFile(oldFile, tempFile);
        }
    }

    public boolean ifLecturerIdExists(File file, String string) {
        Scanner scanner = null;
        try {
            File file1 = new File(String.valueOf(file));
            scanner = new Scanner(file1);
            while (scanner.hasNextLine()) {
                String data = scanner.nextLine();
                String[] datas = data.split(", ");
                if (datas[0].equals(string)) {
                    scanner.close();
                    return true;
                }
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        return false;
    }

    public String[] queryLecturerById(File file, String department, String id) {
        try {
            BufferedReader bufferedReader = new BufferedReader(new FileReader(file));
            String[] strings = new String[11];
            String s;
            while ((s = bufferedReader.readLine()) != null) {
                String[] str = s.split(",");
                if (str[0].trim().equals(id) && str[7].trim().equals(department.trim())) {
                    // String data = str[0] + ", " + str[1] + ", " + str[2] + ", " + str[3] + ", " +
                    // str[4] + ", " + str[5] + ", " + str[6] + ", " + str[7] + ", " + str[8] + ", "
                    // +
                    // str[9] + ", " + str[10];
                    strings = str;
                }
            }
            bufferedReader.close();
            return strings;
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }

    // Rename File

    private void renameFile(File old, File temp) {
        boolean delete = old.delete();
        boolean rename = temp.renameTo(old);
        System.out.println(String.valueOf(old));
        if (delete) {
            System.out.println("Deleted");
        } else {
            System.out.println("Failed");
        }
        if (rename) {
            System.out.println("Renamed");
        } else {
            System.out.println("Rename Failed");
        }
    }
}
