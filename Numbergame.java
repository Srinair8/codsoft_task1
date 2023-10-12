package Numbergame;

import java.util.Random;
import java.util.Scanner;

public class Numbergame {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Random random = new Random();
        int lowerBound = 1;
        int upperBound = 100;
        int numberOfAttempts = 7;
        int roundsWon = 0;

        System.out.println("Welcome to the Number Guessing Game!");
        System.out.println("The computer has choosen a number ranging between 1 and 100. Can you guess that number?");
        System.out.println("You have " + numberOfAttempts + " attempts to guess the number between " + lowerBound + " and " + upperBound + ".");

        boolean playAgain = true;

        while (playAgain) {
            int secretNumber = random.nextInt(upperBound - lowerBound + 1) + lowerBound;
            int attempts = 0;
            boolean hasGuessedCorrectly = false;

            while (attempts < numberOfAttempts) {
                System.out.print("Enter your guess: ");
                int userGuess = scanner.nextInt();
                scanner.nextLine();

                if (userGuess < lowerBound || userGuess > upperBound) {
                    System.out.println("Please guess within the valid range.");
                } else if (userGuess < secretNumber) {
                    System.out.println("Too low. Try again.");
                } else if (userGuess > secretNumber) {
                    System.out.println("Too high. Try again.");
                } else {
                    System.out.println("Congratulations! You've guessed the correct number: " + secretNumber);
                    hasGuessedCorrectly = true;
                    break;
                }

                attempts++;
            }

            if (hasGuessedCorrectly) {
                roundsWon++;
            } else {
                System.out.println("Out of attempts. The correct number was: " + secretNumber);
            }

            System.out.print("Play again? (yes/no): ");
            String playAgainInput = scanner.nextLine().toLowerCase();
            if (!playAgainInput.equals("yes")) {
                playAgain = false;
            }
        }

        System.out.println("Thanks for playing the game! Rounds won: " + roundsWon);
    }
}
