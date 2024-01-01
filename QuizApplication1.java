import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.Timer;
import java.util.TimerTask;

public class QuizApplication1 {
    private static List<Question> questions;
    private static int currentQuestionIndex;
    private static int score;

    public static void main(String[] args) {
        initializeQuestions();
        startQuiz();
    }

    private static void initializeQuestions() {
        questions = new ArrayList<>();

        // Add your quiz questions along with multiple-choice options and correct answers
        Question question1 = new Question("What is the capital of India?",
            new String[]{"A. Mumbai", "B. Delhi", "C. Kolkata", "D. Chennai"}, "B");
        Question question2 = new Question("Who is the current Prime Minister of India?",
            new String[]{"A. Narendra Modi", "B. Rahul Gandhi", "C. Sharad Pawar", "D. Arvind Kejriwal"}, "A");
        // Add more questions here

        questions.add(question1);
        questions.add(question2);
        // Add more questions here
    }

    private static void startQuiz() {
        currentQuestionIndex = 0;
        score = 0;

        Timer timer = new Timer();
        timer.schedule(new TimerTask() {
            @Override
            public void run() {
                System.out.println("Time's up!");
                displayNextQuestion();
            }
        }, 15000); // Set the time limit for each question in milliseconds (e.g., 15000 = 15 seconds)

        displayNextQuestion();
    }

    private static void displayNextQuestion() {
        if (currentQuestionIndex < questions.size()) {
            Question question = questions.get(currentQuestionIndex);
            System.out.println(question.getQuestion());
            for (String option : question.getOptions()) {
                System.out.println(option);
            }

            Scanner scanner = new Scanner(System.in);
            String userAnswer = scanner.nextLine();

            if (userAnswer.equalsIgnoreCase(question.getCorrectAnswer())) {
                score++;
            }

            currentQuestionIndex++;
            displayNextQuestion();
        } else {
            displayResult();
        }
    }

    private static void displayResult() {
        System.out.println("Quiz completed!");
        System.out.println("Your score: " + score + "/" + questions.size());
        // Display a summary of correct/incorrect answers if needed
    }
}

class Question {
    private String question;
    private String[] options;
    private String correctAnswer;

    public Question(String question, String[] options, String correctAnswer) {
        this.question = question;
        this.options = options;
        this.correctAnswer = correctAnswer;
    }

    public String getQuestion() {
        return question;
    }

    public String[] getOptions() {
        return options;
    }

    public String getCorrectAnswer() {
        return correctAnswer;
    }
}
