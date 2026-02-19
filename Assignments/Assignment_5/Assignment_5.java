// ============================================
// ASSIGNMENT 5: THE SCRIPT
// Positive/Negative Analyzer
// COP2250 Java Programming
// Kevin Pyatt, Ph.D. | Pyatt Labs
// ============================================
// Write a program that reads an unspecified number
// of integers, determines how many positive and
// negative values have been read, and computes the
// total and average of the input values (not
// counting zeros). Your program ends when 0 is
// entered. Display the average as a floating-point
// number.
// ============================================

// STEP 1: Import Scanner
// TODO 1: Write the import statement
import java.util.Scanner;

public class Assignment_5 {
    public static void main(String[] args) {

        // STEP 2: Create Scanner object
        // TODO 2: Create a Scanner named input
        Scanner input = new Scanner(System.in);

        // STEP 3: Declare counters and accumulator
        // TODO 3: Declare positiveCount (int, start at 0)
        int positiveCount = 0;
        // TODO 4: Declare negativeCount (int, start at 0)
        int negativeCount = 0;
        // TODO 5: Declare total (int, start at 0)
        int total = 0;

        // STEP 4: Priming read — get first number before the loop
        // TODO 6: Prompt "Enter an integer (0 to quit): "
        System.out.print("Enter an integer (0 to quit): ");
        // TODO 7: Read the integer into a variable named num
        int num = input.nextInt();

        // STEP 5: Loop while sentinel (0) has NOT been entered
        // TODO 8: Write the while loop — while (num != 0)
        while (num != 0) {

            // STEP 6: Check if num is positive or negative
            // TODO 9: If num > 0, increment positiveCount
            if (num > 0) {
                positiveCount++;
            }
            // TODO 10: Else if num < 0, increment negativeCount
            else if (num < 0) {
                negativeCount++;
            }

            // STEP 7: Accumulate the total
            // TODO 11: Add num to total
            total += num;

            // STEP 8: Read the next number (bottom of loop)
            // TODO 12: Prompt "Enter an integer (0 to quit): "
            System.out.print("Enter an integer (0 to quit): ");
            // TODO 13: Read the next integer into num
            num = input.nextInt();
        }

        // STEP 9: Calculate total count
        // TODO 14: Declare count = positiveCount + negativeCount
        int count = positiveCount + negativeCount;

        // STEP 10: Display results with edge case handling
        // TODO 15: If count == 0, print "No numbers were entered."
        if (count == 0) {
            System.out.println("No numbers were entered.");
        }
        // TODO 16: Else, print positiveCount, negativeCount, total
        else {
            System.out.println("Positive numbers: " + positiveCount);
            System.out.println("Negative numbers: " + negativeCount);
            System.out.println("Total: " + total);
            // TODO 17: Calculate average as (double) total / count
            double average = (double) total / count;
            // TODO 18: Print the average
            System.out.println("Average: " + average);
        }

        // STEP 11: Close Scanner
        // TODO 19: Close the Scanner
        input.close();
    }
}

