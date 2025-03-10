import java.util.Random;
import java.util.Scanner;

public class App {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Random random = new Random();

        // Get user input for total starting chips
        System.out.println("Enter total starting chips:");
        int totalChips = scanner.nextInt();
        int startTotalChips = totalChips;

        // Get user input for initial betting amount
        System.out.println("Enter betting chips amount:");
        int bettingChips = scanner.nextInt();
        scanner.nextLine(); // Consume the leftover newline

        int originalBettingChips = bettingChips; // Store the initial betting amount
        int roundsBet = 0;
        int wins = 0;
        int losses = 0;

        while (roundsBet < 100) {        
            
            while (totalChips > 0 && totalChips < 10000) {
                if (bettingChips <= 0) {
                    
                    if (totalChips >= originalBettingChips) {
                        bettingChips = originalBettingChips;
                        totalChips -= originalBettingChips;
                    } else {
                        bettingChips = totalChips;
                        totalChips = 0;
                    }
                }

                
                int betAmount = Math.max(1, random.nextInt(Math.max(1, bettingChips / 4)) + 1);
                System.out.println("Betting " + betAmount + " chips...");

                // 40% chance to win, 60% to lose
                if (random.nextInt(100) < 40) {
                    totalChips += betAmount;
                    System.out.println("You won! New total: " + totalChips);
                } else {
                    bettingChips -= betAmount;
                    System.out.println("You lost. Remaining betting chips: " + bettingChips);
                }
            }

            // Game over
            if (totalChips >= 10000) {
                wins++;
                System.out.println("Congratulations! Wins: " + wins);
            } else {
                losses++;
                System.out.println("You lost all your chips. Losses: " + losses);
            }
            
            roundsBet++;
            bettingChips = originalBettingChips;
            totalChips = startTotalChips;
            
            
        }
        System.out.println("wins -- losses " + wins + ""+ losses);
            scanner.nextLine(); // Pause before restarting
        scanner.close();
    }
}
