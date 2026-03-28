import java.util.Scanner;

public class AdventureGame {

    static Scanner input = new Scanner(System.in);

    public static void main(String[] args) {
        startGame();
    }

    public static void startGame() {
        System.out.println("Welcome to the Adventure Game!");
        System.out.println("You wake up in a dark forest.");
        System.out.println("Two paths are in front of you.");
        System.out.println("Do you go LEFT or RIGHT?");

        String choice = input.nextLine().toLowerCase();

        if (choice.equals("left")) {
            leftPath();
        } else if (choice.equals("right")) {
            rightPath();
        } else {
            System.out.println("That is not a valid choice.");
            startGame();
        }
    }

    public static void leftPath() {
        System.out.println("\nYou walk down the left path.");
        System.out.println("You find a river.");
        System.out.println("Do you SWIM across or BUILD a raft?");

        String choice = input.nextLine().toLowerCase();

        if (choice.equals("swim")) {
            System.out.println("\nThe current is too strong.");
            System.out.println("You lose.");
        } else if (choice.equals("build")) {
            System.out.println("\nYou build a raft and cross safely.");
            System.out.println("You find a treasure chest.");
            System.out.println("You win!");
        } else {
            System.out.println("That is not a valid choice.");
            leftPath();
        }
    }

    public static void rightPath() {
        System.out.println("\nYou walk down the right path.");
        System.out.println("A wolf appears.");
        System.out.println("Do you RUN or STAY still?");

        String choice = input.nextLine().toLowerCase();

        if (choice.equals("run")) {
            System.out.println("\nThe wolf chases you down.");
            System.out.println("You lose.");
        } else if (choice.equals("stay")) {
            System.out.println("\nThe wolf loses interest and walks away.");
            System.out.println("You find a cabin and are safe.");
            System.out.println("You win!");
        } else {
            System.out.println("That is not a valid choice.");
            rightPath();
        }
    }
}
