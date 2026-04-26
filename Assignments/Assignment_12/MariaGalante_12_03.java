/**
 * MariaGalante_12_03.java
 * Maria Galante
 * Chapter 12 Assignment 12.3
 *
 * This program stores integer values in an array, asks the user
 * to enter an index number, displays the value at that index,
 * handles invalid input, and handles out of bounds errors using
 * exception handling.
 */

import java.util.Scanner;

public class MariaGalante_12_03 {

    // -------------------------------------------------------
    // Declare and initialize the array with preset values.
    // -------------------------------------------------------
    static int[] data = {1, 2, 3, 4, 5};

    // -------------------------------------------------------
    // Return the element at the requested index.
    // Exception will propagate to main if invalid.
    // -------------------------------------------------------
    public static int getElement(int index) {
        return data[index];
    }

    // -------------------------------------------------------
    // Main method begins program execution.
    // -------------------------------------------------------
    public static void main(String[] args) {

        // Create Scanner object for user input.
        Scanner scanner = new Scanner(System.in);

        // ---------------------------------------------------
        // Continue asking for input until user enters -1.
        // ---------------------------------------------------
        while (true) {

            // Prompt user for an index.
            System.out.print("Enter an index (or -1 to quit): ");

            // Read user input as a string.
            String input = scanner.nextLine();

            // Check if user wants to quit.
            if (input.equals("-1")) {
                break;
            }

            // ------------------------------------------------
            // Attempt to process the input.
            // ------------------------------------------------
            try {

                // Convert string input to integer.
                int index = Integer.parseInt(input);

                // Retrieve value from array.
                int value = getElement(index);

                // Display result.
                System.out.println("Element: " + value);
            }

            // Handle non-numeric input.
            catch (NumberFormatException e) {
                System.out.println("Invalid input.");
            }

            // Handle invalid array index.
            catch (ArrayIndexOutOfBoundsException e) {
                System.out.println("Out of Bounds.");
            }

            // Always display completion message.
            finally {
                System.out.println("Attempt complete.");
            }

            // Blank line for spacing.
            System.out.println();
        }

        // Display closing message.
        System.out.println("Goodbye.");

        // Close scanner.
        scanner.close();
    }
}
