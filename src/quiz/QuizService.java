package quiz;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class QuizService {
    public QuizService() {
    }

    public List<Question> loadQuestions(String fileName) {
        List<Question> questions = new ArrayList<>();
        try (BufferedReader br = new BufferedReader(new FileReader(fileName))) {
            String line;

            while ((line = br.readLine()) != null){
                String[] parts = line.split(";");

                if (parts.length == 6){
                    String questionText = parts[0];
                    String[] answers = { parts[1], parts[2], parts[3], parts[4]};

                    int correctAnswerIndex = Integer.parseInt(parts[5]);

                    Question question = new Question(questionText, answers, correctAnswerIndex);
                    questions.add(question);

                }else{
                    System.out.println("Please fix the Question/Answer set: " + Arrays.toString(parts));
                }
            }

        } catch (FileNotFoundException e) {
            System.out.println("File not found:" +e.getMessage());
        } catch (IOException e) {
            System.out.println(("Error in reading the File: ") + e.getMessage());
        }catch (NumberFormatException e){
            System.out.println("The index of the answer is not a valid number" + e.getMessage());
        }

        return questions;
    }
}
