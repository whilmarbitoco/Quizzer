/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package admin.model;

import Core.Student;
import java.util.ArrayList;
import java.util.UUID;

/**
 *
 * @author wb2c0
 */
public class studentAdminModel {

    private ArrayList<Student> students;

    public studentAdminModel() {
        this.students = new ArrayList<>();

        students.add(new Student(UUID.randomUUID(), "Jerson Dio", "dio@gmail.com", "dio123"));
        students.add(new Student(UUID.randomUUID(), "Aleah Jalawig", "aleah@gmail.com", "aleah123"));
        students.add(new Student(UUID.randomUUID(), "John Alim", "alim@gmail.com", "alim123"));

        students.add(new Student(UUID.randomUUID(), "Whilmar Bitoco", "whlmrbitoco@gmail.com", "letmein"));
    }

    public ArrayList<Student> getAllStudents() {
        return this.students;
    }

    public int getTotal() {
        return this.students.size();
    }

    public Student getByUUID(UUID uuid) {
        Student found = null;
        for (int i = 0; i < this.students.size(); i++) {
            if (this.students.get(i).id.equals(uuid)) {
                found = this.students.get(i);
                System.out.println("sss");
            }
        }
        return found;
    }

    public void editStudent(UUID uuid, String name, String email, String password) {
        for (int i = 0; i < this.students.size(); i++) {
            if (this.students.get(i).id.equals(uuid)) {
                this.students.set(i, new Student(uuid, name, email, password));
            }
        }
    }

    public ArrayList<Student> searchByChar(String chars) {
        ArrayList<Student> searchResult = new ArrayList<>();

        for (Student student : this.students) {
            if (student.name.toLowerCase().contains(chars.toLowerCase()) || student.email.toLowerCase().contains(chars.toLowerCase())) {
                searchResult.add(student);
            }
        }

        return searchResult;
    }

    public void delteByUUID(UUID uuid) {
        Student found = null;
        for (int i = 0; i < this.students.size(); i++) {
            if (this.students.get(i).id.equals(uuid)) {
                this.students.remove(i);
            }
        }

    }

    public void addStudent(String name, String email, String password) {
        UUID uuid = UUID.randomUUID();
        students.add(new Student(uuid, name, email, password));

    }

    public Student auth(String email, String password) {

        for (int i = 0; i < students.size(); i++) {
            if (students.get(i).email.equalsIgnoreCase(email) && students.get(i).password.equalsIgnoreCase(password)) {
                return students.get(i);
            }
        }

        return null;
    }

}
