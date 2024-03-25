/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package admin.Controller;

import Core.Admin;
import Core.Logger;
import Core.Packet;
import Core.Quiz;
import Core.Student;
import admin.model.adminModel;
import admin.model.quizAdminModel;
import admin.model.quizListModel;
import admin.model.studentAdminModel;
import admin.socket.Server;
import admin.socket.ServerHandler;
import admin.views.AddStudentView;
import admin.views.DashboardView;
import admin.views.InformationView;
import admin.views.LoginView;
import admin.views.QuizesView;
import admin.views.StudentsView;
import admin.views.addQuizView;
import admin.views.adminProfileView;
import Core.confirmDialogView;
import admin.views.createQuizView;
import admin.views.messageView;
import admin.views.sendQuizView;
import java.util.ArrayList;
import java.util.UUID;
import admin.Interface.AdminInterface;
import java.net.Inet4Address;

/**
 *
 * @author wb2c0
 */
public class AdminController implements AdminInterface {
//    Model

    adminModel adModel;
    quizAdminModel quizModel;
    studentAdminModel studAdModel;
    quizListModel quizlistModel;

//    Views
    LoginView login;
    DashboardView dashView;
    StudentsView studentView;
    confirmDialogView exit;
    AddStudentView addStuView;
    InformationView infoView;
    QuizesView quizView;
    createQuizView createquizz;
    addQuizView addquiz;
    messageView mView;
    sendQuizView sendquiz;
    adminProfileView adminProView;

//    Variables
    boolean isLoggedIn = false;
    Admin currentAdmin;
    String qName;

//    tmp_array
    ArrayList<Quiz> quizes;

//    funcs
    Logger logger;

//    Socket
    Server server;
    String ip;
    int port = 9901;

    Thread thread;

    public AdminController() {
        this.quizes = new ArrayList<>();

        this.logger = new Logger("admin.logs");

//        Initialize
        this.adModel = new adminModel();
        this.quizModel = new quizAdminModel();
        this.studAdModel = new studentAdminModel();
        this.quizlistModel = new quizListModel();

//        Initialize views
        this.dashView = new DashboardView();
        this.dashView.setListener(this);
        this.dashView.setLocationRelativeTo(null);

        this.exit = new confirmDialogView(null, true);
        this.exit.setIsAdmin();
        this.exit.adminListener(this);

        this.studentView = new StudentsView();
        this.studentView.setLocationRelativeTo(null);
        this.studentView.setListener(this);

        this.addStuView = new AddStudentView(dashView, true, this);
        this.addStuView.setLocationRelativeTo(null);

        this.infoView = new InformationView(dashView, true, this);
        this.infoView.setLocationRelativeTo(null);

        this.quizView = new QuizesView();
        this.quizView.setListener(this);
        this.quizView.setLocationRelativeTo(null);

        this.createquizz = new createQuizView(quizView, true, this);
        this.createquizz.setLocationRelativeTo(null);

        this.addquiz = new addQuizView(quizView, true, this);
        this.addquiz.setLocationRelativeTo(null);

        this.sendquiz = new sendQuizView(quizView, true, this);
        this.sendquiz.setLocationRelativeTo(null);

        this.mView = new messageView(null, true);

        this.adminProView = new adminProfileView(this);
        this.adminProView.setLocationRelativeTo(null);

        auth();
        logger.log(currentAdmin.name, "Login");
        initialize();

        try {
            Object host = Inet4Address.getLocalHost();
            ip = String.valueOf(host).split("/")[1];
            adminProView.setNetwork(ip, port);

        } catch (Exception e) {
            e.printStackTrace();
        }

        this.server = new Server(port, this);
        thread = new Thread(this.server);
        thread.start();

    }

    public void initialize() {
        Object[] usercombo = {this.currentAdmin.name, "Settings", "Logout"};
        this.dashView.setStats(String.valueOf(this.studAdModel.getTotal()), "0", String.valueOf(this.quizlistModel.getSize()));

        this.dashView.setCombo(usercombo);
        this.studentView.setCombo(usercombo);
        this.quizView.setCombo(usercombo);

        this.studentView.setTable(studAdModel.getAllStudents());
        this.createquizz.populate(this.quizes);
    }

    public void auth() {
        this.login = new LoginView(dashView, true, this);

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
        this.studentView.setVisible(false);
        this.dashView.setVisible(true);
        this.quizView.setVisible(false);
    }

    @Override
    public void openStudents() {
        this.studentView.setVisible(true);
        this.dashView.setVisible(false);
        this.quizView.setVisible(false);

    }

    @Override
    public void openQuizzes() {
        this.quizView.setVisible(true);
        this.studentView.setVisible(false);
        this.dashView.setVisible(false);

    }

    @Override
    public void adminLogin(String email, String password) {
        boolean auth = adModel.auth(email, password);

        if (auth) {
            this.dashView.setVisible(true);
            this.login.close();
            this.currentAdmin = this.adModel.getByEmail(email);
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

        if (!exit.value) {
            exit.close();
            return;
        }
        logger.log(currentAdmin.name, "Logout");
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

    @Override
    public void addQuiz() {
        this.createquizz.setVisible(true);
    }

    @Override
    public void deleteQuiz(int id) {
        for (Quiz q : this.quizes) {
            if (q.id == id) {
                quizes.remove(q);
                break;
            }
        }
        initialize();
    }

    @Override
    public void openAddQuiz() {
        addquiz.setVisible(true);
    }

    @Override
    public void addIdentification(String question, String answer, int time, String type) {

        int id = (int) (Math.random() * Integer.MAX_VALUE);
        Quiz tmp = new Quiz(time, question, answer, type, id);

//        quizModel.addQuiz(tmp);
        this.quizes.add(tmp);
        initialize();

    }

    @Override
    public void submitQList(String title, UUID parentUUID) {

        ArrayList<Quiz> tmp = quizlistModel.getQuizByName(title);

        if (tmp == null) {
            quizlistModel.addQuiz(this.quizes, parentUUID, title);
            quizView.setQuizes(quizlistModel.getList());

            this.quizes = new ArrayList<>();
            this.initialize();
            this.createquizz.successMessage();
            this.createquizz.dispose();
            return;
        }

        this.createquizz.errorMessage();
    }

    @Override
    public void displaySelectedQuiz(String qName) {
        ArrayList<Quiz> quiz = quizlistModel.getQuizByName(qName);

        quizView.setTable(quiz);
        quizView.setStatus(quizlistModel.getStatus(qName));

    }

    @Override
    public void addMultipleChoice(String question, String answer, int time, String type, Object[] choices) {
        int id = (int) (Math.random() * Integer.MAX_VALUE);
        Quiz tmp = new Quiz(time, question, answer, type, id, choices);

        this.quizes.add(tmp);
        initialize();

    }

    @Override
    public void dispayMessage(String text) {
        mView.setVisible(true);
        mView.setMessage(text);
    }

    @Override
    public void clickSendQuiz(String name) {
        this.qName = name;

        boolean status = quizlistModel.getStatus(this.qName);

        if (status) {
            quizView.quizSendedMsg();
            return;
        }
        this.sendquiz.setVisible(true);
    }

    @Override
    public void adminCallTo(int choice) {
        switch (choice) {
            case 0:
                break;

            case 1:
                this.adminProView.setVisible(true);
                this.adminProView.setLogs(logger.readLogs("admin.logs"), currentAdmin.name);
                this.adminProView.setDetails(this.currentAdmin.email, this.currentAdmin.name, this.currentAdmin.password);
                break;
            case 2:
                this.exit();
        }
    }

    @Override
    public void adminSignUp(String email, String name, String password) {
        if (this.adModel.checkEmail(email)) {
            this.login.showError("Email already exist");
            return;
        }

        this.adModel.addAdmin(email, name, password);
        this.login.loginSuccess();
    }

    @Override
    public void studentLogin(ServerHandler handler, String email, String password) {
        Student auth = studAdModel.auth(email, password);
        Packet packet = new Packet(null, "Login Authorize", null, "Server");

        if (auth != null) {
            packet.auth = true;
            packet.student = auth;
            this.server.sendOneMessage(handler, packet);
        } else {
            packet.auth = false;
            packet.message = "x0FailedLogin";
            this.server.sendOneMessage(handler, packet);
        }
    }

    @Override
    public void addScore(Student student) {
        this.dashView.setStudents(student.email, student.name, student.score);
    }

    @Override
    public void broadcast(String name) {
        ArrayList<Quiz> quiz = quizlistModel.getQuizByName(this.qName);

        if (quiz != null) {
            Packet packet = new Packet(quiz, "Quiz2Ans", "Client", "Server");
            packet.instruction = name;

            server.broadcast(packet);
//            server.setQuiz(packet);
            
            quizlistModel.setAnswered(this.qName);
            this.quizView.setStatus(quizlistModel.getStatus(this.qName));
        }
    }

    @Override
    public void editAdmin(String email, String name, String password) {
        this.adModel.editAdmin(email, name, password);
        this.currentAdmin = adModel.getByEmail(email);
        this.adminProView.setDetails(this.currentAdmin.email, this.currentAdmin.name, this.currentAdmin.password);
        this.initialize();
    }

}
