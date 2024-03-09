package Core;

import java.io.Serializable;
import java.util.ArrayList;

public class Packet implements Serializable {

    public String message;
    public String from;
    public String to;
    public ArrayList<Quiz> quizes;
    public String email;
    public String password;
    public boolean auth = false;
    public Student student;
    public String instruction;

    public Packet(ArrayList<Quiz> quizes, String message, String to, String from) {
        this.quizes = quizes;
        this.message = message;
        this.from = from;
        this.to = to;
    }

}
