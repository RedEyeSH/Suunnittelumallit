package template_method;

import java.util.Random;
import java.util.Scanner;

public class DiceGame extends Game {
    private int numberOfPlayers;
    private int[] scores;
    private int winningScore = 20;
    private int winner = -1;
    private Random random = new Random();

    @Override
    public void initializeGame(int numberOfPlayers) {
        this.numberOfPlayers = numberOfPlayers;
        scores = new int[numberOfPlayers];
        System.out.println("===Dice Game===");
        System.out.println("First to get " + winningScore + " points wins!");
    }

    @Override
    public boolean endOfGame() {
        return winner != -1;
    }

    @Override
    public void playSingleTurn(int player) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Player " + (player + 1) + ", press Enter to roll...");
        scanner.nextLine();

        int roll = random.nextInt(6) + 1;
        scores[player] += roll;
        System.out.println("Player " + (player + 1) + " rolled a " + roll + ". Total score: " + scores[player] + "\n");

        if (scores[player] >= winningScore) {
            winner = player;
        }
    }

    @Override
    public void displayWinner() {
        System.out.println("===Winner===");
        System.out.println("Player " + (winner + 1) + " wins with " + scores[winner] + " points!");

        System.out.println("===Result===");
        for (int i = 0; i < numberOfPlayers; i++) {
            System.out.println("Player " + (i + 1) + ": " + scores[i] + " points");
        }
    }
}
