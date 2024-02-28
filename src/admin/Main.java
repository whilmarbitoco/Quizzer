/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package admin;

import admin.Controller.v2.adminController;
import admin.views.Dashboard;

/**
 *
 * @author wb2c0
 */
public class Main {
    public static void main(String[] args) {

        Dashboard dashboard = new Dashboard();
        adminController controller = new adminController(dashboard);

         
          
    }
    
}
