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
    public ArrayList<Quiz> quiz;
    public String name;
    public UUID uuid;
    public boolean isSubmitted = false;
    public UUID parentUUID;    

    public Quizes(ArrayList<Quiz> quiz, UUID uuid, String name, UUID parentUUID) {
        this.quiz = quiz;
        this.uuid = uuid;
        this.name = name;
        this.parentUUID = parentUUID;
    }
    
    
    
}
