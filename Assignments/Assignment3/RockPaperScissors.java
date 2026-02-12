/**
 * Assignment: Rock Paper Scissors Game
 * 
 * COP2250 Java Programming
 * Kevin Pyatt, Ph.D. | Pyatt Labs
 * 
 * Write a program that plays rock-paper-scissors.
 * 0 = scissor, 1 = rock, 2 = paper
 * Computer randomly generates a number.
 * User enters a number.
 * Display win, lose, or draw.
 */

import java.util.Scanner;
import java.util.Random;

public class RockPaperScissors {
    public static void main(String[] args) {

        // ============================================
        // ACT 1: SET THE STAGE
        // ============================================

        // Create Scanner
        Scanner input = new Scanner(System.in);

        // Create Random object
        Random rand = new Random();

        // Array for word display
        String[] choices = {"Scissor", "Rock", "Paper"};


        // ============================================
        // ACT 2: COMPUTER CHOICE
        // ============================================

        // Generate random number 0–2
        int computer = rand.nextInt(3);


        // ============================================
        // ACT 3: USER INPUT
        // ============================================

        System.out.print("Enter 0 for scissor, 1 for rock, 2 for paper: ");
        int user = input.nextInt();


        // ============================================
        // ACT 4: DISPLAY CHOICES
        // ============================================

        if (user < 0 || user > 2) {
            System.out.println("Invalid input.");
            input.close();
            return;
        }

        System.out.println("The computer is " + choices[computer] + ".");
        System.out.println("You are " + choices[user] + ".");


        // ============================================
        // ACT 5: DETERMINE WINNER
        // ============================================

        if (user == computer) {
            System.out.println("It is a draw.");
        }
        else if (
            (user == 0 && computer == 2) ||   // scissor beats paper
            (user == 1 && computer == 0) ||   // rock beats scissor
            (user == 2 && computer == 1)      // paper beats rock
        ) {
            System.out.println("You win.");
        }
        else {
            System.out.println("You lose.");
        }

        input.close();
    }
}
