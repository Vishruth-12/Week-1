import java.util.Random;
import java.util.Scanner;

public class RockPaperScissors {
    static String playRound(String playerMove, String computerMove) {
        if (playerMove.equals(computerMove)) return "Draw";
        if ((playerMove.equals("Rock") && computerMove.equals("Scissors")) ||
            (playerMove.equals("Paper") && computerMove.equals("Rock")) ||
            (playerMove.equals("Scissors") && computerMove.equals("Paper"))) return "Player Wins";
        return "Computer Wins";
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Random random = new Random();
        String[] moves = {"Rock", "Paper", "Scissors"};
        String[] players = new String[5], computers = new String[5], results = new String[5];
        int wins = 0, losses = 0, draws = 0;

        for (int i = 0; i < 5; i++) {
            System.out.print("Round " + (i + 1) + " - Enter Rock, Paper, or Scissors: ");
            String input = sc.nextLine().trim();
            while (!input.equalsIgnoreCase("rock") && !input.equalsIgnoreCase("paper") && !input.equalsIgnoreCase("scissors")) {
                System.out.print("Invalid move. Enter Rock, Paper, or Scissors: ");
                input = sc.nextLine().trim();
            }
            players[i] = input.substring(0, 1).toUpperCase() + input.substring(1).toLowerCase();
            computers[i] = moves[random.nextInt(3)];
            results[i] = playRound(players[i], computers[i]);
            if (results[i].equals("Player Wins")) wins++;
            else if (results[i].equals("Computer Wins")) losses++;
            else draws++;
        }

        System.out.println("\nRound | Player Move | Computer Move | Result");
        for (int i = 0; i < 5; i++)
            System.out.println((i + 1) + " | " + players[i] + " | " + computers[i] + " | " + results[i]);
        System.out.printf("Wins: %d | Losses: %d | Draws: %d | Win %% = %.1f%%%n", wins, losses, draws, wins * 100.0 / 5);
        sc.close();
    }
}