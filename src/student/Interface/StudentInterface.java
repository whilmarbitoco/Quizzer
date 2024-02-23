/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package student.Interface;

/**
 *
 * @author wb2c0
 */
public interface StudentInterface {

    void onLogin(String email, String password);

    void startQuiz();

    void answer(String studentAnswer, String correctAnswer);

    void logout();

    void settings();
    
    void showedScore();
    
    void editStudent(String name, String password);
}
