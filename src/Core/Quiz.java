package Core;

import java.io.Serializable;

public class Quiz implements Serializable{
    public int id;
    public int time;
    public String question;
    public String answer;
    public String type;
    public Object choices[];

    public Quiz(int time, String question, String answer, String type, int id) {
        this.time = time;
        this.question = question;
        this.answer = answer;
        this.type = type;
        this.id = id;
    }

    // Constructor for multiple-choice quiz
    public Quiz(int time, String question, String answer, String type, int id, Object[] choices) {
        this(time, question, answer, type, id);
        this.choices = choices;
    }
}
