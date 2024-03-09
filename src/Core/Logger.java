/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Core;

/**
 *
 * @author wb2c0
 */
import java.awt.List;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;

public class Logger {

    private final DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
    String filename;
            
     public Logger(String filename) {
        this.filename = filename;
        
    }

    public void log(String user, String message) {
        LocalDateTime currentTime = LocalDateTime.now();
        String formattedTime = formatter.format(currentTime);
        this.saveFile(user + " * " + formattedTime + " * " + message + "\n");
      
    }

    public void saveFile(String content) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(this.filename, true))) {
            writer.write(content);
           
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    
    public ArrayList<String> readLogs(String filename) {

        ArrayList<String> lines = new ArrayList<>();

        try (BufferedReader reader = new BufferedReader(new FileReader(filename))) {
            String line;
            while ((line = reader.readLine()) != null) {
                lines.add(line);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

       return lines;

    }

}
