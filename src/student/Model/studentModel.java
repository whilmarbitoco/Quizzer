/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package student.Model;

import Core.Quiz;
import Core.Student;
import java.util.ArrayList;

/**
 *
 * @author wb2c0
 */
public class studentModel {
    private ArrayList<Quiz> quizes;
    private Student currentStudent;
    private int score = 0;

    public studentModel() {
         System.out.println("model");
        this.quizes = new ArrayList<>();
        
        this.currentStudent = new Student("Whilmar Bitoco", "whlmrbitoco@gmail.com", "letmein");
        
        quizes.add(new Quiz(10, "What is 1+1?", "2","Enumeration"));
        quizes.add(new Quiz(10, "What is 2+2", "4","Enumeration"));
        
        Object[] test = {"Laguna", "Davao", "Cavite", "Manila"};
        quizes.add(new Quiz(10, "What is the capital of the Philippines PhilippinesPhilippinesPhilippinesPhilippines", "Manila","Multiple Choice", test));
    }
    
    
       
    public void setScore(int score) {
        this.score += score;
    }
    
      public int getScore() {
       return this.score;
    }
    
    
    public ArrayList<Quiz> getQuizes(){
         return this.quizes;
    }
    
    public Student getStudent() {
        return this.currentStudent;
    }
    
    public void editStudent(String name, String password) {
        this.currentStudent.name = name;
        this.currentStudent.password = password;
    }
    
    public boolean authenticate(String email, String password) {
        if (email.equalsIgnoreCase(currentStudent.email) && password.equalsIgnoreCase(currentStudent.password)) {
            return true;
        }
        return false;
    }
    
}
