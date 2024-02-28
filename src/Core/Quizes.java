/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Core;

import java.util.ArrayList;
import java.util.UUID;

/**
 *
 * @author wb2c0
 */
public class Quizes {
    ArrayList<Quiz> quiz;
    String name;
    UUID uuid;
    

    public Quizes(ArrayList<Quiz> quiz, UUID uuid, String name) {
        this.quiz = quiz;
        this.uuid = uuid;
        this.name = name;
    }
    
    
    
}
