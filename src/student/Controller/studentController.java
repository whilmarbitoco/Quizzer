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
import student.Views.loginStudentView;
import student.Views.v2.DashboardView;
import student.Interface.StudentInterface;
import student.Views.v2.editView;
import student.Views.v2.DisplayScore;
import student.Views.v2.formEnumeration;
import student.Views.v2.formMultipleChoice;
import student.Views.v2.networkSettingsView;
import student.socket.Client;

/**
 *
 * @author wb2c0
 */
public class studentController implements StudentInterface {

    private boolean isLoggedIn = false;
    private boolean answered = false;
    private studentModel model;
    private DashboardView dashView;
    private loginStudentView loginView;
    private Client client;
    private networkSettingsView networksettings;
    Thread thread;

    public studentController() {
        System.out.println("Controller");
        this.model = new studentModel();
        this.dashView = new DashboardView();
        this.loginView = new loginStudentView();
        this.dashView.setInterface(this);
        this.loginView.setLoginListener(this);

        this.networksettings = new networkSettingsView(dashView, true, this);

        this.client = new Client("127.0.0.1", 9901, this);
        thread = new Thread(this.client);
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
            this.dashView.alreadyAnswer();
            return;
        }

        if (model.getQuizes() == null) {
            this.dashView.showErrorMessage();
            return;
        }
        answered = true;
        this.dashView.setVisible(false);
        ArrayList<Quiz> quiz = this.model.getQuizes();

        for (int i = 0; i < quiz.size(); i++) {
            if (quiz.get(i).type.equals("Enumeration")) {
                formEnumeraFtion enumeration = new formEnumeration(dashView, true, quiz.get(i).answer, quiz.get(i).question, this);
                enumeration.setVisible(true);
            } else if (quiz.get(i).type.equals("Multiple Choice")) {
                formMultipleChoice multiple = new formMultipleChoice(dashView, true, quiz.get(i).answer, quiz.get(i).question, quiz.get(i).choices, this);
                multiple.setVisible(true);
            }

        }
        DisplayScore totalScore = new DisplayScore(dashView, true, this, String.valueOf(model.getScore()));
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
        editView editstudent = new editView(dashView, true, this, this.model.getStudent());
        editstudent.setVisible(true);
    }

    @Override
    public void showedScore() {
        Packet packet = new Packet(null, "Score", "Server", "Client");
        packet.student = model.getStudent();
        packet.student.score = model.getScore();
        client.sendMessage(packet);
        this.dashView.setVisible(true);
    }

    @Override
    public void editStudent(String name, String password) {
        this.model.editStudent(name, password);
        dashView.setName(model.getStudent().name);
    }

    @Override
    public void authorize(boolean bol, Student student) {
        if (bol) {
            model.setCurrStudent(student);
            System.out.println("controller " + student.name);
            dashView.setName(student.name);
            dashView.setVisible(true);
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

    @Override
    public void setIns(String ins) {
        dashView.setInstruction(ins);
    }

    @Override
    public void netSettings() {
        networksettings.setVisible(true);
    }

    @Override
    public void setNetwork(String ip, int port) {
        thread.interrupt();
        client.setNetwork(ip, port);

       thread.start();
    }
}
