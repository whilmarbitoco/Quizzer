/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package admin.Controller.v2;

import Core.Student;
import admin.Interface.v2.adminInterface;
import admin.adminAddStudent;
import admin.model.adminModel;
import admin.model.quizAdminModel;
import admin.model.studentAdminModel;
import admin.views.AddStudent;
import admin.views.Dashboard;
import admin.views.Information;
import admin.views.Login;
import admin.views.Students;
import admin.views.confirmDialog;
import java.util.ArrayList;
import java.util.UUID;

/**
 *
 * @author wb2c0
 */
public class adminController implements adminInterface {
//    Model
    adminModel adModel;
    quizAdminModel quizModel;
    studentAdminModel studAdModel;

//    Views
    Login login;
    Dashboard dashView;
    Students studentView;
    confirmDialog exit;
    AddStudent addStuView;
    Information infoView;

//    Variables
    boolean isLoggedIn = true;

    public adminController(Dashboard dashView) {
//        Initialize
        this.adModel = new adminModel();
        this.quizModel = new quizAdminModel();
        this.studAdModel = new studentAdminModel();

//        Initialize views
        this.dashView = dashView;
        this.dashView.setListener(this);
        this.dashView.setLocationRelativeTo(null);
        
        
        this.exit = new confirmDialog(null, true, this);
        
        this.studentView = new Students();
        this.studentView.setLocationRelativeTo(null);
        this.studentView.setListener(this);
        
        this.addStuView = new AddStudent(dashView, true, this);
        this.addStuView.setLocationRelativeTo(null);
        
        this.infoView = new Information(dashView, true, this);
        this.infoView.setLocationRelativeTo(null);
        
        auth();

        initialize();

    }

    public void initialize() {
        this.dashView.setStats(String.valueOf(this.studAdModel.getTotal()), "0", String.valueOf(this.quizModel.getTotal()));
        this.studentView.setTable(studAdModel.getAllStudents());
    }

    public void auth() {
        this.login = new Login(dashView, true, this);

        if (!isLoggedIn) {
            this.login.setLocationRelativeTo(null);
            this.login.setVisible(true);
            return;
        }

        this.dashView.setLocationRelativeTo(null);
        this.dashView.setVisible(true);

    }
    

    @Override
    public void openDashboard() {

    }

    @Override
    public void openStudents() {
        this.studentView.setVisible(true);
        this.dashView.setVisible(false);

    }

    @Override
    public void openQuizzes() {

    }

    @Override
    public void adminLogin(String email, String password) {
        boolean auth = adModel.auth(email, password);

        if (auth) {
            this.dashView.setVisible(true);
            this.login.close();
            return;
        }

        this.login.showError("Invalid username or password");

    }

    @Override
    public void exit() {
        exit.setLocationRelativeTo(null);
        exit.setText("Do you actually want to exit?");
        exit.setVisible(true);

    }

    @Override
    public void close() {
        System.out.println(exit.value);
        if (!exit.value) {
            exit.close();
            return;
        }
        System.exit(0);

    }

    @Override
    public void openAddStudent() {
        addStuView.setVisible(true);
    }
       

    @Override
    public void addStudent(String name, String email, String password) {
       studAdModel.addStudent(name, email, password);
       initialize();
    }

    @Override
    public void infoStudent(String id) {
        System.out.println(id);
        
        Student student = studAdModel.getByUUID(UUID.fromString(id));
        infoView.setInfo(student);
        infoView.setVisible(true);
    }

    @Override
    public void editStudent(UUID uuid, String header, String name, String email, String password) {
        addStuView.setDetails(uuid, header, name, email, password);
        addStuView.setVisible(true);
    }

    @Override
    public void saveEditStudent(UUID uuid, String name, String email, String password) {
        studAdModel.editStudent(uuid, name, email, password);
        initialize();
    }

    @Override
    public void searchStudent(String chars) {
        ArrayList<Student> student = studAdModel.searchByChar(chars);
        studentView.setTable(student);
    }

    @Override
    public void clearSearch() {
        initialize();
    }
        
}
