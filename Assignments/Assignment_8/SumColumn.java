/**
 * Name: Maria Galante
 * Date: 03/17/2026
 * Description: This program reads a 3x4 matrix and calculates
 * the sum of each column using a separate method.
 */

import java.util.Scanner;

public class SumColumn {

    // ========================================
    // STEP 1: Write the sumColumn method
    // ========================================
    public static double sumColumn(double[][] m, int columnIndex) {
        double sum = 0;
        for (int i = 0; i < m.length; i++) {
            sum += m[i][columnIndex];
        }
        return sum;
    }

    public static void main(String[] args) {

        // STEP 2: Create a Scanner
        Scanner input = new Scanner(System.in);

        // STEP 3: Declare a 3-by-4 matrix
        double[][] m = new double[3][4];

        // STEP 4: Prompt and read the matrix row by row
        System.out.println("Enter a 3-by-4 matrix row by row:");
        for (int i = 0; i < m.length; i++) {
            for (int j = 0; j < m[0].length; j++) {
                m[i][j] = input.nextDouble();
            }
        }

        // STEP 5: Display the sum of each column
        for (int col = 0; col < m[0].length; col++) {
            System.out.println("Sum of column " + col + " is " + sumColumn(m, col));
        }

        // STEP 6: Close the Scanner
        input.close();
    }

    // ========================================
    // STEP 7: Compile and test
    // ========================================
    // javac SumColumn.java
    // java SumColumn

    // ========================================
    // STEP 9: Push to your repo
    // ========================================
    // git add SumColumn.java
    // git commit -m "Assignment 8 - Sum Column"
    // git push
}
