/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package admin.Interface;

import Core.Student;
import admin.socket.ServerHandler;
import java.util.UUID;

/**
 *
 * @author wb2c0
 */
public interface AdminInterface {
    
    void addStudent();
    
    void addedStudent(String name, String email, String password);
    
    void searchStudent(UUID uuid);
    
    void deleteStudent(UUID uuid);
    
    void triggerEdit(UUID uuid);
    
    void editStudent(UUID uuid, String name, String email, String password);
    
    void searchByChar(String chars);
    
    void refresh();
    
    void addMultiQuiz(Object[] choices, String type, String question, String answer);
    
    void addEnumQuiz(String type, String question, String answer);
    
    void adminLogin(String email, String password);
    
    void broadcastQuiz();
    
    void studentLogin(ServerHandler server, String email, String password);
    
    void addScore(Student student);
}
