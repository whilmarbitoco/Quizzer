/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package student.Controller.v2;

import student.Interface.v2.studentInterface;
import student.Views.v2.DashboardView;
import student.Views.v2.loginView;
import student.Views.v2.networkSettingsView;

/**
 *
 * @author hello
 */
public class studentController implements studentInterface {

//    Views
    loginView login;
    networkSettingsView networkView;
    DashboardView dashboard;
    
//    Variables
    boolean isLoggedIn = false;
    
    
    public studentController() {
        login = new loginView(this);
        login.setLocationRelativeTo(null);
        
        networkView = new networkSettingsView(login, true, this);
        networkView.setLocationRelativeTo(null);
        
        dashboard = new DashboardView(this);
        dashboard.setLocationRelativeTo(null);
        
        auth();
    }
    
    public void auth(){
        if (isLoggedIn) {
            dashboard.setVisible(true);
            return;
        }
        
       login.setVisible(true);
    }

    @Override
    public void onLogin(String username, String password) {

    }

    @Override
    public void netSettings() {

    }

    @Override
    public void setNetwork(String host, int port) {
        
    }

    @Override
    public void startQuiz() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

}
