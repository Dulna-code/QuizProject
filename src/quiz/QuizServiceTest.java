package quiz;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.io.TempDir;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class QuizServiceTest {
    @TempDir
    Path tempDir;

    @Test
    void testLoadQuestions_withValidCsvFile() throws IOException {
        QuizService quizService = new QuizService();

        Path tempCsvFile = tempDir.resolve("test_questions.csv");
        String csvContent = "Was ist Java?;Eine Insel;Eine Programmiersprache;Ein Auto;Ein Planet;2\n" +
                "Was ist 2+2?;3;4;5;6;2";
        Files.writeString(tempCsvFile, csvContent);

        List<QuestionModel> questions = quizService.loadQuestions(tempCsvFile.toString());
        assertEquals(2, questions.size(), "The list should have only two questions.");

        QuestionModel firstQuestion = questions.get(0);
        assertEquals("Was ist Java?", firstQuestion.getQuestionText());
        assertEquals("Eine Insel", firstQuestion.getAnswerOptions()[0]);
        assertEquals("Eine Programmiersprache", firstQuestion.getAnswerOptions()[1]);
        assertEquals(2, firstQuestion.getCorrectAnswerIndex());
    }
    @Test
    void testLoadQuestions_withNonExistentFile(){
        QuizService quizService = new QuizService();

        List<QuestionModel> questions = quizService.loadQuestions("does_not_exist.csv");

        assertNotNull(questions, "The list should not be null.");
        assertTrue(questions.isEmpty(), "The list should be empty");
    }

}
