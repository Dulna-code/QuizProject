import quiz.QuestionModel;
import quiz.QuizService;

public static void main(String[] args) {

    System.out.println("Welcome to the IHK exam Quiz App. You will find multiple choice questions and only one answer is correct.");

    QuizService quiz = new QuizService();

    List<QuestionModel> questionModels = quiz.loadQuestions("questions.csv");

    int questionNumber = 1;
    for (QuestionModel questionModel : questionModels) {
        String questionText = questionModel.getQuestionText();
        System.out.println("Question number " + questionNumber + ": " + questionText);
        questionNumber++;

        int answerNumber = 1;
        String[] answerOptions = questionModel.getAnswerOptions();
        for (String answer : answerOptions) {
            System.out.println("Answer " + answerNumber +": " + answer);
        answerNumber++;
        }

    }
}