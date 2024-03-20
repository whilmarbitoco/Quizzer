/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package admin.model;

import Core.Quiz;
import Core.Quizes;
import java.util.ArrayList;
import java.util.UUID;

/**
 *
 * @author wb2c0
 */
public class quizListModel {
    
   private ArrayList<Quizes> quizes;

    public quizListModel() {
        this.quizes = new ArrayList<>();
        
    }
    
    
    public ArrayList<Quizes> getList() {
        return this.quizes;
    }
    
    public void addQuiz(ArrayList<Quiz> quiz, UUID parentUUID,String name) {
        UUID uuid = UUID.randomUUID();
        Quizes tmp = new Quizes(quiz, uuid, name, parentUUID);
        this.quizes.add(tmp);
    }
    
    public ArrayList<Quiz> getQuizByName(String qName) {
        for (Quizes q : this.quizes) {
            if (q.name.equalsIgnoreCase(qName)) {
                return q.quiz;
            }
        }
        
        
        return null;
    }
    
    
        public void setAnswered(String qName) {
        for (Quizes q : this.quizes) {
            if (q.name.equalsIgnoreCase(qName)) {
               q.isSubmitted = true;
            }
        }
    }
    
       public boolean getStatus(String qName) {
        for (Quizes q : this.quizes) {
            if (q.name.equalsIgnoreCase(qName)) {
                return q.isSubmitted;
            }
        }
     return false;   
    }
    
       public int getSize() {
           return this.quizes.size();
       }
    
    
    
    
}
