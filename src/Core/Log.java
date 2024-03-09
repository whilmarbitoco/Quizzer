/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Core;

import java.time.LocalDateTime;

/**
 *
 * @author wb2c0
 */
public class Log {
     private LocalDateTime time;
    private String type;

    public Log(LocalDateTime time, String type) {
        this.time = time;
        this.type = type;
    }
}
