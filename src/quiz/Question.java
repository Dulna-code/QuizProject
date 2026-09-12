package quiz;

import java.util.Arrays;

public class Question {
    private String questionText;
    private String[] answerOptions;
    private int correctAnswerIndex;

    public Question(String questionText, String[] answerOptions, int correctAnswerIndex) {
        this.questionText = questionText;
        this.answerOptions = answerOptions;
        this.correctAnswerIndex = correctAnswerIndex;
    }

    @Override
    public String toString() {
        return "Question{" +
                "questionText='" + questionText + '\'' +
                ", answerOptions=" + Arrays.toString(answerOptions) +
                ", correctAnswerIndex=" + correctAnswerIndex +
                '}';
    }
}
