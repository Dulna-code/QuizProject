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
        int yourAnswer = 0;
        while (yourAnswer>4 || yourAnswer<1){
            System.out.println(" Please enter your answer: ");
            Scanner input = new Scanner(System.in);
            yourAnswer = input.nextInt();

            if (yourAnswer > 4 || yourAnswer<1){
                System.out.println("Please enter a number between 1 and 4.");
            }
        }
        int correctAnswer = questionModel.getCorrectAnswerIndex();
        if (correctAnswer != yourAnswer){
            System.out.println("Your answer is incorrect.");
            System.out.println("Correct answer is : " + correctAnswer + " " + answerOptions[correctAnswer-1]);
        }else {
            System.out.println("Your answer is correct.");
        }




    }
}