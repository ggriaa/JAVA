/**
 * GradeByBestScore.java
 * COP2250 - Assignment 7 (Exercise 7.1)
 * Name: Maria Galante
 * Date: March 10, 2026
 * Read student scores, find the best, assign grades on a curve.
 */

import java.util.Scanner;

public class Assignment_7 {

    public static void main(String[] args) {

        // STEP 1: Create a Scanner
        Scanner input = new Scanner(System.in);


        // STEP 2: Ask how many students
        System.out.print("Enter the number of students: ");
        int n = input.nextInt();


        // STEP 3: Create an int array of size n
        int[] scores = new int[n];


        // STEP 4: Read scores into the array
        System.out.print("Enter " + n + " scores: ");
        for (int i = 0; i < n; i++) {
            scores[i] = input.nextInt();
        }


        // STEP 5: Find the best (maximum) score
        int best = scores[0];
        for (int i = 1; i < scores.length; i++) {
            if (scores[i] > best) {
                best = scores[i];
            }
        }


        // STEP 6: Assign grades based on the curve
        // Loop through the array again.
        // For each score, determine the grade using if-else:
        //
        for (int i = 0; i < scores.length; i++) {
            char grade;
            if (scores[i] >= best - 10)
                grade = 'A';
            else if (scores[i] >= best - 20)
                grade = 'B';
            else if (scores[i] >= best - 30)
                grade = 'C';
            else if (scores[i] >= best - 40)
                grade = 'D';
            else
                grade = 'F';

            System.out.println("Student " + i + " score is " + scores[i] + " and grade is " + grade);
        }


        // STEP 7: Close the Scanner
        input.close();

    }

    // ========================================
    // STEP 8: Compile and test
    // ========================================
    // javac GradeByBestScore.java
    // java GradeByBestScore
    //
    // Test case 1:
    //   Enter the number of students: 4
    //   Enter 4 scores: 40 55 70 58
    //   Expected:
    //     Student 0 score is 40 and grade is C
    //     Student 1 score is 55 and grade is B
    //     Student 2 score is 70 and grade is A
    //     Student 3 score is 58 and grade is B
    //
    // Test case 2:
    //   Enter the number of students: 3
    //   Enter 3 scores: 100 90 80
    //   Expected:
    //     Student 0 score is 100 and grade is A
    //     Student 1 score is 90 and grade is A
    //     Student 2 score is 80 and grade is B
    //
    // Test case 3 (all same):
    //   Enter the number of students: 2
    //   Enter 2 scores: 50 50
    //   Expected:
    //     Student 0 score is 50 and grade is A
    //     Student 1 score is 50 and grade is A

    // ========================================
    // STEP 9: Add a header comment
    // ========================================
    // Your name, date, description

    // ========================================
    // STEP 10: Push to your repo
    // ========================================
    // git add GradeByBestScore.java
    // git commit -m "Assignment 7 - Grade by Best Score"
    // git push
}
