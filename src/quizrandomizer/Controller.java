/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package quizrandomizer;

import admin.Controller.AdminController;

/**
 *
 * @author hello
 */
public class Controller implements Interface {

    MainView mainView;

    public Controller() {
        mainView = new MainView(null, true, this);
        mainView.setLocationRelativeTo(null);
        mainView.setVisible(true);

    }

    @Override
    public void callToAdmin() {
        mainView.dispose();
        AdminController controller = new AdminController();
        

    }

    @Override
    public void callToUser() {

    }

}
