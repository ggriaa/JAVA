import java.util.Scanner;

public class Assignment_5 {
    public static void main(String[] args) {

        Scanner input = new Scanner(System.in);

        int positiveCount = 0;
        int negativeCount = 0;
        int total = 0;
        int count = 0;

        System.out.println("Enter integers (0 to stop): ");

        // priming read
        int num = input.nextInt();

        while (num != 0) {

            if (num > 0) {
                positiveCount++;
            } 
            else if (num < 0) {
                negativeCount++;
            }

            total += num;
            count++;

            // read again at bottom
            num = input.nextInt();
        }

        System.out.println("Positives: " + positiveCount);
        System.out.println("Negatives: " + negativeCount);
        System.out.println("Total: " + total);

        if (count == 0) {
            System.out.println("No numbers were entered.");
        } else {
            double average = (double) total / count;
            System.out.println("Average: " + average);
        }

        input.close();
    }
}
