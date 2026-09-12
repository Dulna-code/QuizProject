import quiz.Question;
import quiz.QuizService;

public static void main(String[] args) {

    System.out.println("Welcome to the IHK exam Quiz App. You will find multiple choice questions and only one answer is correct.");

    QuizService quiz = new QuizService();

    List<Question> questions = quiz.loadQuestions("questions.csv");

    System.out.println(questions);

}