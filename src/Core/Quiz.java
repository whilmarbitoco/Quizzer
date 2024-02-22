package Core;

public class Quiz {
    int time;
    String question;
    String answer;
    String type;
    Object choices[];

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
