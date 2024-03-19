/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package admin;

import admin.Controller.AdminController;
import admin.views.DashboardView;

/**
 *
 * @author wb2c0
 */
public class Main {

    public static void main(String[] args) {

        DashboardView dashboard = new DashboardView();
        AdminController controller = new AdminController(dashboard);

    }

}
