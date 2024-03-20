/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package admin.Interface;

import Core.Quiz;
import Core.Student;
import admin.socket.ServerHandler;
import java.util.ArrayList;
import java.util.UUID;

/**
 *
 * @author wb2c0
 */
public interface AdminInterface {
    
    void openDashboard();
    
    void openStudents();
    
    void openQuizzes();
    
    void adminLogin(String email, String password);
    
    void exit();
    
    void close();
    
    void openAddStudent();
    
    void addStudent(String name, String email, String password);
    
    void infoStudent(String id);
    
    void editStudent(UUID uuid, String header, String name, String email, String password);
    
    void saveEditStudent(UUID uuid, String name, String email, String password);
    
    void searchStudent(String chars);

    void clearSearch();
    
    void addQuiz();
    
    void deleteQuiz(int id);
    
    void openAddQuiz();
    
    void addEnumeration(String question, String answer, int time, String type);
    
    void addMultipleChoice(String question, String answer, int time, String type, Object[] choices);
    
    void submitQList(String title, UUID parentUIID);
    
    void displaySelectedQuiz(String qName);
    
    void dispayMessage(String text);
    
    void clickSendQuiz(String name);
    
    
    void adminCallTo(int choice);
    
    void adminSignUp(String email, String name, String password);
    
    void studentLogin(ServerHandler handler, String email, String password);
    
    void addScore(Student student);
    
    void broadcast(String qName);
    
    void editAdmin(String email, String name, String password);
    
   
}
