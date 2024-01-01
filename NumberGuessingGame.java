import java.util.Scanner;
import java.util.Random;

public class NumberGuessingGame {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Random random = new Random();

        int maxNumber = 100;
        int maxAttempts = 10;
        int score = 0;

        boolean playAgain = true;
        while (playAgain) {
            int secretNumber = random.nextInt(maxNumber) + 1;
            int attempts = 0;

            System.out.println("I'm thinking of a number between 1 and " + maxNumber + ". Can you guess it?");

            while (attempts < maxAttempts) {
                System.out.print("Enter your guess: ");
                int guess = scanner.nextInt();
                attempts++;

                if (guess == secretNumber) {
                    System.out.println("Congratulations! You guessed the number in " + attempts + " attempts!");
                    score++;
                    break;
                } else if (guess < secretNumber) {
                    System.out.println("Too low! Try again.");
                } else {
                    System.out.println("Too high! Try again.");
                }
            }

            if (attempts == maxAttempts) {
                System.out.println("Sorry, you ran out of attempts. The number was " + secretNumber + ".");
            }

            System.out.print("Do you want to play again? (y/n): ");
            char choice = scanner.next().charAt(0);
            playAgain = choice == 'y' || choice == 'Y';

            System.out.println("Your current score is: " + score);
        }

        System.out.println("Thanks for playing! Your final score is: " + score);
    }
}
