/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package student.Interface.v2;

/**
 *
 * @author hello
 */
public interface studentInterface {
    void onLogin(String username, String password);
    
    void netSettings();
    
    void setNetwork(String host, int port);
    
    void startQuiz();
}
