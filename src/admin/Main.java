/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package admin;

import admin.Controller.adminController;
import admin.model.quizAdminModel;
import admin.model.studentAdminModel;
import admin.socket.Server;
import student.socket.Client;

/**
 *
 * @author wb2c0
 */
public class Main {
    public static void main(String[] args) {

        adminDashboard view = new adminDashboard();
        studentAdminModel model = new studentAdminModel();
        quizAdminModel quizModel = new quizAdminModel();
        adminController controller = new adminController(view, model, quizModel);

         
          
    }
    
}
