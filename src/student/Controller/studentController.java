/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package student.Controller;

import Core.Quiz;
import java.util.ArrayList;
import student.Model.studentModel;
import student.loginStudent;
import student.studentDashboard;
import student.Interface.StudentInterface;
import student.editStudentDetails;
import student.forms.DisplayScore;
import student.forms.formEnumeration;
import student.forms.formMultipleChoice;

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

    public studentController(studentModel model, studentDashboard view, loginStudent loginVIew) {
        System.out.println("Controller");
        this.model = model;
        this.view = view;
        this.loginView = loginVIew;
        this.view.setInterface(this);
        this.loginView.setLoginListener(this);

        if (!isLoggedIn) {
            this.loginView.setVisible(true);
        }

    }

    @Override
    public void onLogin(String email, String password) {
        if (model.authenticate(email, password)) {
            view.setName(model.getStudent().name);
            view.setVisible(true);
            loginView.setVisible(false);
            isLoggedIn = true;
        } else {

            loginView.showErrorMessage();
        }
    }

    @Override
    public void startQuiz() {
        if (answered) {
            this.view.alreadyAnswer();
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
        this.view.setVisible(true);
    }

    @Override
    public void editStudent(String name, String password) {
        this.model.editStudent(name, password);
         view.setName(model.getStudent().name);
    }

}
