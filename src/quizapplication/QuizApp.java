package quizapplication;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class QuizApp {
    public static void main(String[] args) {
        // Create quiz questions
        List<QuizQuestion> questions = new ArrayList<>();
        questions.add(new QuizQuestion("What is the capital of India?", new String[]{"1. Delhi", "2. Goa", "3. Maharashtra", "4. Rajasthan"}, 1));
        questions.add(new QuizQuestion("What is 2 + 2?", new String[]{"1. 3", "2. 4", "3. 5", "4. 6"}, 2));
        questions.add(new QuizQuestion("What is the color of the sky?", new String[]{"1. Blue", "2. Green", "3. Red", "4. Yellow"}, 1));

        Scanner scanner = new Scanner(System.in);
        int score = 0;

        // Iterate through each question
        for (QuizQuestion question : questions) {
            System.out.println(question.getQuestion());
            String[] options = question.getOptions();
            for (String option : options) {
                System.out.println(option);
            }

            // Start timer
            QuizTimer quizTimer = new QuizTimer(10);
            boolean answered = false;
            int userAnswer = -1;

            // Loop to get user answer until time's up
            while (!quizTimer.isTimeUp()) {
                if (scanner.hasNextInt()) {
                    userAnswer = scanner.nextInt();
                    answered = true;
                    break;
                }
            }

            // Stop the timer
            quizTimer.stop();

            // Check if the answer is correct
            if (answered && userAnswer == question.getCorrectAnswer()) {
                score++;
            } else {
                System.out.println("Incorrect or time's up. The correct answer was " + (question.getCorrectAnswer()) + ". " + options[question.getCorrectAnswer() - 1]);
            }
            System.out.println();
        }
        // Display final score
        System.out.println("Quiz Over! Your final score is: " + score + "/" + questions.size());

        scanner.close();
    }
}
