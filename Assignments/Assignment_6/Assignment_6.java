/**
 * SortThreeNumbers.java
 * COP2250 - Assignment 6 (Exercise 6.5)
 * 
 * Write a method that sorts three numbers and displays them
 * in increasing order.
 * 
 * DIRECTIONS: Follow each STEP below. Do them in order.
 *             Compile and test after each STEP.
 */

import java.util.Scanner;

public class Assignment_6 {

    // ========================================
    // STEP 1: Define the method signature
    // ========================================
    // Write the method header for displaySortedNumbers.
    // It takes three double parameters: num1, num2, num3
    // It returns void (it prints, not returns).
    //
    public static void displaySortedNumbers(double num1, double num2, double num3) {

        // ========================================
        // STEP 2: Sort the three numbers
        // ========================================
        double temp;

        if (num1 > num2) {
            temp = num1;
            num1 = num2;
            num2 = temp;
        }

        if (num1 > num3) {
            temp = num1;
            num1 = num3;
            num3 = temp;
        }

        if (num2 > num3) {
            temp = num2;
            num2 = num3;
            num3 = temp;
        }

        // ========================================
        // STEP 3: Display the sorted numbers
        // ========================================
        System.out.println(num1 + " " + num2 + " " + num3);

    }
    // ========================================
    // STEP 4: Close the method with }
    // ========================================


    // ========================================
    // STEP 5: Write the main method
    // ========================================

    public static void main(String[] args) {

        // STEP 6: Create a Scanner
        Scanner input = new Scanner(System.in);

        // STEP 7: Prompt the user for three numbers
        System.out.print("Enter three numbers: ");

        // STEP 8: Read the three numbers into doubles
        double num1 = input.nextDouble();
        double num2 = input.nextDouble();
        double num3 = input.nextDouble();

        // STEP 9: Call displaySortedNumbers with the three values
        displaySortedNumbers(num1, num2, num3);

        // STEP 10: Close the Scanner
        input.close();

    }

    // ========================================
    // STEP 11: Compile and test
    // ========================================
    // javac SortThreeNumbers.java
    // java SortThreeNumbers
    //
    // Test cases:
    //   Enter: 5.5 2.3 8.1  → Should print: 2.3 5.5 8.1
    //   Enter: 1 2 3        → Should print: 1.0 2.0 3.0
    //   Enter: 3 2 1        → Should print: 1.0 2.0 3.0
    //   Enter: 5 5 5        → Should print: 5.0 5.0 5.0
    //   Enter: 10 10 5      → Should print: 5.0 10.0 10.0

    // ========================================
    // STEP 12: Add a header comment
    // ========================================
    // Go back to the top and add:
    //   Your name
    //   The date
    //   A brief description

    // ========================================
    // STEP 13: Push to your repo
    // ========================================
    // git add SortThreeNumbers.java
    // git commit -m "Assignment 6 - Sort Three Numbers"
    // git push
}
