/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package student.Controller;

import Core.Packet;
import Core.Quiz;
import Core.Student;
import java.util.ArrayList;
import student.Model.studentModel;
import student.loginStudent;
import student.studentDashboard;
import student.Interface.StudentInterface;
import student.editStudentDetails;
import student.forms.DisplayScore;
import student.forms.formEnumeration;
import student.forms.formMultipleChoice;
import student.socket.Client;

/**
 *
 * @author wb2c0
 */
public class studentController implements StudentInterface {

    private boolean isLoggedIn = false;
    private boolean answered = false;
    private studentModel model;
    private studentDashboard view;
    private loginStudent loginView;
    private Client client;

    public studentController(studentModel model, studentDashboard view, loginStudent loginVIew) {
        System.out.println("Controller");
        this.model = model;
        this.view = view;
        this.loginView = loginVIew;
        this.view.setInterface(this);
        this.loginView.setLoginListener(this);

        this.client = new Client("127.0.0.1", 9901, this);
        Thread thread = new Thread(this.client);
        thread.start();
        
        if (!isLoggedIn) {
            this.loginView.setVisible(true);
        }

    }

    @Override
    public void onLogin(String email, String password) {
        Packet packet = new Packet(null, "Login", "Server", null);
        packet.email = email;
        packet.password = password;
        client.sendMessage(packet);
    }

    @Override
    public void startQuiz() {
        if (answered) {
            this.view.alreadyAnswer();
            return;
        }
        
        if (model.getQuizes() == null) {
            this.view.showErrorMessage();
            return;
        }
        answered = true;
        this.view.setVisible(false);
        ArrayList<Quiz> quiz = this.model.getQuizes();

        for (int i = 0; i < quiz.size(); i++) {
            if (quiz.get(i).type.equals("Enumeration")) {
                formEnumeration enumeration = new formEnumeration(view, true, quiz.get(i).answer, quiz.get(i).question, this);
                enumeration.setVisible(true);
            } else if (quiz.get(i).type.equals("Multiple Choice")){
                formMultipleChoice multiple = new formMultipleChoice(view, true, quiz.get(i).answer,quiz.get(i).question, quiz.get(i).choices, this);
                multiple.setVisible(true);
            }

        }
        DisplayScore totalScore = new DisplayScore(view, true, this, String.valueOf(model.getScore()));
        totalScore.setVisible(true);
    }

    @Override
    public void answer(String studentAnswer, String correctAnswer) {
        if (studentAnswer.equalsIgnoreCase(correctAnswer)) {
            model.setScore(1);
            System.out.println(model.getScore());
        }
    }

    @Override
    public void logout() {
        System.out.println("logout");
        System.exit(0);
    }

    @Override
    public void settings() {
        editStudentDetails editstudent = new editStudentDetails(view, true, this, this.model.getStudent());
        editstudent.setVisible(true);
    }

    @Override
    public void showedScore() {
        Packet packet = new Packet(null, "Score", "Server", "Client");
        packet.student = model.getStudent();
        packet.student.score = model.getScore();
        client.sendMessage(packet);
        this.view.setVisible(true);
    }

    @Override
    public void editStudent(String name, String password) {
        this.model.editStudent(name, password);
         view.setName(model.getStudent().name);
    }

    @Override
    public void authorize(boolean bol, Student student) {
        if (bol) {
            model.setCurrStudent(student);
            System.out.println("controller " + student.name);
            view.setName(student.name);
            view.setVisible(true);
            loginView.close();
        } else {
            loginView.showErrorMessage();
        }
    }

    @Override
    public void setQuiz(ArrayList<Quiz> quiz) {
           System.out.println(quiz);
           model.setQuiz(quiz);
    }

}
