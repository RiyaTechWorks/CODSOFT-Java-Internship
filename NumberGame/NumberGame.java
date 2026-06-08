import java.util.Random;
import java.util.Scanner;

public class NumberGame {

    public static void main(String[] args) {

        try (Scanner sc = new Scanner(System.in)) {
            Random random = new Random();
            
            int score = 0;
            int roundsWon = 0;
            String playAgain;
            
            do {
                int randomNumber = random.nextInt(100) + 1;
                int maxAttempts = 5;
                boolean guessedCorrectly = false;
                
                System.out.println("\n===== NUMBER GAME =====");
                System.out.println("Guess a number between 1 and 100");
                System.out.println("You have " + maxAttempts + " attempts.");
                
                for (int attempt = 1; attempt <= maxAttempts; attempt++) {
                    
                    System.out.print("Attempt " + attempt + ": Enter your guess: ");
                    int guess = sc.nextInt();
                    
                    if (guess == randomNumber) {
                        System.out.println("Congratulations! You guessed the number correctly.");
                        
                        guessedCorrectly = true;
                        roundsWon++;
                        
                        score += (maxAttempts - attempt + 1) * 10;
                        break;
                    }
                    else if (guess < randomNumber) {
                        System.out.println("Too low! Try again.");
                    }
                    else {
                        System.out.println("Too high! Try again.");
                    }
                }
                
                if (!guessedCorrectly) {
                    System.out.println("You have used all attempts.");
                    System.out.println("The correct number was: " + randomNumber);
                }
                
                System.out.println("\nCurrent Score: " + score);
                System.out.println("Rounds Won: " + roundsWon);
                
                System.out.print("\nDo you want to play another round? (yes/no): ");
                playAgain = sc.next();
                
            } while (playAgain.equalsIgnoreCase("yes"));
            
            System.out.println("\n===== GAME OVER =====");
            System.out.println("Final Score: " + score);
            System.out.println("Rounds Won: " + roundsWon);
            System.out.println("Thank you for playing!");
        }
    }
}