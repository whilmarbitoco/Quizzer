/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package admin.Interface.v2;

import java.util.UUID;

/**
 *
 * @author wb2c0
 */
public interface adminInterface {
    
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
}
