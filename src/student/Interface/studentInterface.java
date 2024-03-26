/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package student.Interface;

import Core.Quiz;
import Core.Student;
import java.util.ArrayList;

/**
 *
 * @author hello
 */
public interface studentInterface {
    void onLogin(String username, String password);
    
    void loginFailed();
    
    void netSettings();
    
    void setNetwork(String host, int port);
    
    void startQuiz();
    
    void authorize(boolean bol, Student student);
    
    void setQuiz(ArrayList<Quiz> quiz);
    
    void setIns(String instruction);
    
    void serverOffline();
    
    void answer(String studentAnswer, String correctAnswer);
    
    void callTo(int choice);
    
    void editStudent(String name, String password);
    
    void exit();
    
    void closed();
    
    void skipQuiz(Quiz quiz);
    
    void alreadyLogin();
}
