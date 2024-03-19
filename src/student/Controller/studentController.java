/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package student.Controller;

import Core.Packet;
import Core.Quiz;
import Core.Student;
import java.util.ArrayList;
import student.Interface.studentInterface;
import student.Model.studentModel;
import student.Views.DashboardView;
import student.Views.DisplayScore;
import student.Views.editView;
import student.Views.formEnumeration;
import student.Views.formMultipleChoice;
import student.Views.loginView;
import student.Views.networkSettingsView;
import student.socket.Client;

/**
 *
 * @author hello
 */
public class studentController implements studentInterface {

//    Views
    loginView login;
    networkSettingsView networkView;
    DashboardView dashboard;
    editView edit;
    networkSettingsView netView;

//    Model
    studentModel studentmodel;

//    Variables
    boolean isLoggedIn = false;
    boolean answered = false;
//    Socket
    Client client;
    
    public studentController() {
        login = new loginView(this);
        login.setLocationRelativeTo(null);
        
        networkView = new networkSettingsView(login, true, this);
        networkView.setLocationRelativeTo(null);
        
        dashboard = new DashboardView(this);
        dashboard.setLocationRelativeTo(null);
        
        netView = new networkSettingsView(login, true, this);
        netView.setLocationRelativeTo(null);
        
        studentmodel = new studentModel();
        
        this.client = new Client("127.0.0.1", 9901, this);
        Thread thread = new Thread(this.client);
        thread.start();
        
        
        auth();
    }
    
    public void auth() {
        if (isLoggedIn) {
            dashboard.setVisible(true);
            return;
        }
        login.setVisible(true);
    }
    
    public void sendScore() {
        Packet packet = new Packet(null, "Score", "Server", "Client");
        packet.student = studentmodel.getStudent();
        packet.student.score = studentmodel.getScore();
        client.sendMessage(packet);
        
    }
    
    @Override
    public void onLogin(String email, String password) {
        Packet packet = new Packet(null, "Login", "Server", null);
        packet.email = email;
        packet.password = password;
        client.sendMessage(packet);
    }
    
    @Override
    public void authorize(boolean bol, Student student) {
        login.dispose();
        studentmodel.setCurrStudent(student);
        dashboard.setName(student.name);
        dashboard.setVisible(true);
    }
    
    @Override
    public void loginFailed() {
        login.showErrorMessage();
    }
    
    @Override
    public void netSettings() {
        netView.setVisible(true);
    }
    
    @Override
    public void setNetwork(String host, int port) {
        
    }
    
    @Override
    public void startQuiz() {
        if (answered) {
            this.dashboard.alreadyAnswer();
            return;
        }
        answered = true;
        dashboard.setVisible(false);
        
        ArrayList<Quiz> quizes = this.studentmodel.getQuizes();
        
        for (Quiz quiz : quizes) {
            if (quiz.type.equals("Enumeration")) {
                formEnumeration enumeration = new formEnumeration(dashboard, true, quiz.answer, quiz.question, quiz.time, this);
                enumeration.setLocationRelativeTo(null);
                enumeration.setVisible(true);
            } else if (quiz.type.equals("Multiple Choice")) {
                formMultipleChoice multipleChoice = new formMultipleChoice(dashboard, true, quiz.answer, quiz.question, quiz.time, quiz.choices, this);
                multipleChoice.setLocationRelativeTo(null);
                multipleChoice.setVisible(true);
            }
        }
        
        sendScore();
        DisplayScore score = new DisplayScore(dashboard, true, String.valueOf(studentmodel.getScore()));
        score.setLocationRelativeTo(null);
        score.setVisible(true);
        dashboard.setVisible(true);
    }
    
    @Override
    public void setQuiz(ArrayList<Quiz> quiz) {
        studentmodel.setQuiz(quiz);
        dashboard.quizReady();
    }
    
    @Override
    public void setIns(String instruction) {
        dashboard.setInstruction(instruction);
    }
    
    @Override
    public void serverOffline() {
        login.showServerOffline();
    }
    
    @Override
    public void answer(String studentAnswer, String correctAnswer) {
        if (studentAnswer.equalsIgnoreCase(correctAnswer)) {
            studentmodel.setScore(1);
        }
    }
    
    @Override
    public void callTo(int choice) {
        switch (choice) {
            case 1:
                edit = new editView(dashboard, true, this, studentmodel.getStudent());
                edit.setLocationRelativeTo(null);
                edit.setVisible(true);
                break;
            
            case 2:
                System.exit(0);
                break;
            
        }
    }
    
    @Override
    public void editStudent(String name, String password) {
        System.err.println("dsdsd");
        this.studentmodel.editStudent(name, password);
        dashboard.setName(studentmodel.getStudent().name);
        
        Packet packet = new Packet(null, "0xEditStudent", "Server", "Client");
        Student prevStud = studentmodel.getStudent();
        
        Student student = new Student(prevStud.id, prevStud.name, prevStud.email, prevStud.password);
        
        packet.student = student;
        
        client.sendMessage(packet);
        
    }
    
}
