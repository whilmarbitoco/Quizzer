/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package admin.Controller;

import Core.Packet;
import Core.Quiz;
import Core.Student;
import admin.Interface.AdminInterface;
import admin.adminAddStudent;
import admin.adminDashboard;
import admin.adminLogin;
import admin.model.adminModel;
import admin.model.quizAdminModel;
import admin.model.studentAdminModel;
import admin.socket.Server;
import admin.socket.ServerHandler;
import java.util.UUID;

/**
 *
 * @author wb2c0
 */
public class adminController implements AdminInterface {
    private adminDashboard views;
    private studentAdminModel model;
    private quizAdminModel quizModel;
    private boolean isLoggedIn = false;
    private adminModel adminmodel;
    private adminLogin adminlogin;
    private Server server;
    
    
    public adminController(adminDashboard views, studentAdminModel model, quizAdminModel quizModel) {
        this.views = views;
        this.model = model;
        this.quizModel = quizModel;
        adminmodel = new adminModel();
        adminlogin = new adminLogin(views, true, this);
               
        this.views.setListener(this);
        this.views.setStats(String.valueOf(model.getTotal()), "4", String.valueOf(quizModel.getTotal()));
        this.views.setStudentTable(model.getAllStudents());

           
        authLogin();
        
        this.server = new Server(this);
        Thread thread = new Thread(server);
        thread.start();
    }
    
    
    
    public void refreshTable() {
        this.views.setStudentTable(model.getAllStudents());
    }
    

    @Override
    public void addStudent() {
        adminAddStudent addStud = new adminAddStudent(views, true, this);
        addStud.setVisible(true);
    }

    @Override
    public void addedStudent(String name, String email, String password) {
        model.addStudent(name, email, password);
//        System.out.println(name + email + password);
        this.views.setStats(String.valueOf(model.getTotal()), "4", "10");
        refreshTable();
    }

    @Override
    public void searchStudent(UUID uuid) {
        Student student = model.getByUUID(uuid);
        views.setDetails(student.name, student.email, student.password);
    }

    @Override
    public void deleteStudent(UUID uuid) {
        model.delteByUUID(uuid);
        refreshTable();
    }



    @Override
    public void triggerEdit(UUID uuid) {
        Student student = model.getByUUID(uuid);
        adminAddStudent editStu = new adminAddStudent(views, true, this);
        editStu.setDetails(student.id, "Edit Student", student.name, student.email, student.password);
        editStu.setVisible(true);
        
       
    } 
    

    @Override
    public void editStudent(UUID uuid, String name, String email, String password) {
        model.editStudent(uuid, name, email, password);
        refreshTable();
    }

    @Override
    public void searchByChar(String chars) {
        this.views.setStudentTable(model.seachByChar(chars));
    }
    
    @Override
    public void refresh() {
        refreshTable();
    }

    @Override
    public void addMultiQuiz(Object[] choices, String type, String question, String answer) {
        Quiz quiz = new Quiz(0, question, answer, type, choices);
        quizModel.addQuiz(quiz);
        views.setNoQuiz(String.valueOf(quizModel.getTotal()));
        views.addQuizList(quizModel.getQuizes());
    }
    
    public void authLogin() {
        if (!isLoggedIn) {
            adminlogin.setVisible(true);
            return;
        }
        this.views.setVisible(true);
    }

    @Override
    public void adminLogin(String email, String password) {
       boolean auth = adminmodel.auth(email, password);
        if (auth) {
            views.setVisible(true);
            adminlogin.close();
            return;
        }
        adminlogin.showError("Failed to login");
    }

    @Override
    public void addEnumQuiz(String type, String question, String answer) {
        Quiz quiz = new Quiz(0, question, answer, type);
        quizModel.addQuiz(quiz);
        views.setNoQuiz(String.valueOf(quizModel.getTotal()));
        views.addQuizList(quizModel.getQuizes());
        
    }

    @Override
    public void broadcastQuiz() {
        Packet packet = new Packet(quizModel.getQuizes(), "Quiz2Ans", "Client", "Server");
        server.broadcast(packet);
    }

    @Override
    public void studentLogin(ServerHandler server, String email, String password) {
       Student auth = model.auth(email, password);
       Packet packet = new Packet(null, "Login Authorize", null, "Server");
       
        if (auth != null) {
           packet.auth = true;
           packet.student = auth;
           this.server.sendOneMessage(server, packet);
        } else {
            packet.auth = false;
           this.server.sendOneMessage(server, packet);
        }
    }

    @Override
    public void addScore(Student student) {
        views.addStudentScore(student.name, student.email, String.valueOf(student.score));
    }


            
    
}
