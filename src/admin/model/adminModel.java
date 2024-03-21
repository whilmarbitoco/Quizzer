/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package admin.model;

import Core.Admin;
import java.util.ArrayList;
import java.util.UUID;

/**
 *
 * @author wb2c0
 */
public class adminModel {
    private ArrayList<Admin> admins;

    public adminModel() {
        this.admins = new ArrayList<>();
        
        admins.add(new Admin(UUID.randomUUID(), "Alo", "alo@alo.com", "omp"));
    }
    
    
    public boolean auth(String email, String password) {
        
        for (Admin admin : this.admins) {
            if (admin.email.equalsIgnoreCase(email) && admin.password.equalsIgnoreCase(password)) {
                return true;
            }
        }
        return false;
    }
    
    public Admin getByEmail(String email) {
        for (Admin ad : this.admins) {
            if (ad.email.equals(email)) {
                return ad;
            }
   
        }
        return null;
    }
    
        public boolean checkEmail(String email) {
        for (Admin ad : this.admins) {
            if (ad.email.equals(email)) {
                return true;
            }
   
        }
        return false;
    }
    
    public void addAdmin(String email, String name, String password) {
        admins.add(new Admin(UUID.randomUUID(), name, email, password));
    }
    
    
        public void editAdmin(String email, String name, String password) {
        for (Admin ad : this.admins) {
            if (ad.email.equals(email)) {
                ad.email = email;
                ad.name = name;
                ad.password = password;
            }
   
        }
    }
}
