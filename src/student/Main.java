/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package student;

import student.Controller.studentController;
import student.Model.studentModel;

/**
 *
 * @author wb2c0
 */
public class Main {

    public static void main(String[] args) {
        System.out.println("main");
        studentModel model = new studentModel();
        studentDashboard view = new studentDashboard();
        loginStudent loginView = new loginStudent();
        studentController controller = new studentController(model, view, loginView);

    }

}
