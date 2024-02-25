/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Core;

import java.io.Serializable;
import java.util.UUID;

/**
 *
 * @author wb2c0
 */
public class Student implements Serializable{
    public UUID id;
    public String name;
    public String email;
    public String password;
    public int score;

    public Student(UUID id, String name, String email, String password) {
        this.id = id;
        this.name = name;
        this.email = email;
        this.password = password;
    }
    
    
    
    
}
