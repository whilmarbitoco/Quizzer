/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Core;

/**
 *
 * @author wb2c0
 */
import javax.swing.*;
import java.awt.event.*;

public class CountdownTimer {
    private int time;
    private JLabel label;


    public CountdownTimer(int initialTime, JLabel label) {
        this.time = initialTime;
        this.label = label;
    }

    public void start() {
        Timer timer = new Timer(1000, new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (time > 0) {
                    label.setText(String.valueOf(time--));
                } else {
                    ((Timer) e.getSource()).stop();
                }
            }
        });
        timer.start();
    }
}
