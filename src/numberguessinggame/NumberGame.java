package numberguessinggame;

import java.util.Random;
import java.util.Scanner;

public class NumberGame {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Random random = new Random();
        int minRange = 1;
        int maxRange = 100;
        int maxAttempts = 10;
        int score = 0;
        boolean playAgain = true;

        while (playAgain) {
            int randomNumber = random.nextInt(maxRange - minRange + 1) + minRange;
            int attempts = 0;
            boolean guessedCorrectly = false;

            System.out.println("Guess the number between " + minRange + " and " + maxRange);

            while (attempts < maxAttempts && !guessedCorrectly) {
                System.out.print("Enter your guess: ");
                int userGuess = scanner.nextInt();
                attempts++;

                if (userGuess < randomNumber) {
                    System.out.println("Too low! Try again.");
                } else if (userGuess > randomNumber) {
                    System.out.println("Too high! Try again.");
                } else {
                    guessedCorrectly = true;
                    System.out.println("Congratulations! You guessed the correct number.");
                    score++;
                }

                if (!guessedCorrectly && attempts == maxAttempts) {
                    System.out.println("You've reached the maximum number of attempts. The correct number was " + randomNumber);
                }
            }

            System.out.print("Do you want to play again? (yes/no): ");
            scanner.nextLine(); // Consume newline left-over
            String userResponse = scanner.nextLine();
            playAgain = userResponse.equalsIgnoreCase("yes");
        }

        System.out.println("Your score: " + score);
        System.out.println("Thank you for playing!");
        scanner.close();
    }
}

