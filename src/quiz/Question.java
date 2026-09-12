package quiz;

public class Question {
    private String questionText;
    private String[] answerOptions;
    private int correctAnswerIndex;

    public Question(String questionText, String[] answerOptions, int correctAnswerIndex) {
        this.questionText = questionText;
        this.answerOptions = answerOptions;
        this.correctAnswerIndex = correctAnswerIndex;
    }

}
