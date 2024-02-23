package Core;

public class Quiz {
    public int time;
    public String question;
    public String answer;
    public String type;
    public Object choices[];

    public Quiz(int time, String question, String answer, String type) {
        this.time = time;
        this.question = question;
        this.answer = answer;
        this.type = type;
    }

    // Constructor for multiple-choice quiz
    public Quiz(int time, String question, String answer, String type, Object[] choices) {
        this(time, question, answer, type);
        this.choices = choices;
    }
}
