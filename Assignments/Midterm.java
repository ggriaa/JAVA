// ============================================
// COP2250 Week 7 Picker
// Methods — Two-Step Reveal (Question → Answer)
// Kevin Pyatt, Ph.D. | Pyatt Labs
// ============================================

import java.util.Scanner;
import java.util.Random;
import java.util.ArrayList;
import java.util.Collections;

public class Midterm {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Random random = new Random();

        // ---- ROSTER ----
        // UPDATE with your actual student names
        String[] students = {
            "Student 1", "Student 2", "Student 3", "Student 4",
            "Student 5", "Student 6", "Student 7", "Student 8",
            "Student 9", "Student 10", "Student 11", "Student 12",
            "Student 13", "Student 14", "Student 15"
        };

        // ---- QUESTIONS: { question, answer, topic, week } ----
        String[][] questions = {
            // Week 7: Methods (8 questions)
            {
                "What is the difference between a parameter and an argument?",
                "A parameter is the variable in the method definition (formal). An argument is the value passed when calling the method (actual).",
                "Methods", "W7"
            },
            {
                "Why is displaySortedNumbers a void method?",
                "Because it prints the sorted numbers directly — it doesn't need to return a value to the caller.",
                "Methods", "W7"
            },
            {
                "What does the return keyword do?",
                "It sends a value back to the caller and immediately exits the method.",
                "Methods", "W7"
            },
            {
                "What happens if you define a method inside main?",
                "Compile error. Java doesn't allow nested methods. Methods go inside the class but outside main.",
                "Methods", "W7"
            },
            {
                "Explain pass-by-value in one sentence.",
                "Java copies the value of a primitive argument into the parameter — changing the copy doesn't affect the original.",
                "Methods", "W7"
            },
            {
                "Walk through Math.min(Math.min(a,b), c) step by step.",
                "First Math.min(a,b) finds the smaller of a and b. Then Math.min(result, c) compares that with c to find the smallest of all three.",
                "Methods", "W7"
            },
            {
                "What is method overloading?",
                "Having multiple methods with the same name but different parameter types or counts. Java picks the right one based on the arguments.",
                "Methods", "W7"
            },
            {
                "Can you assign the result of a void method to a variable? Why not?",
                "No. Void means nothing is returned — there's no value to assign. int x = voidMethod() is a compile error.",
                "Methods", "W7"
            },

            // Week 6 Review: Loops (4 questions)
            {
                "What is a sentinel value?",
                "A special value that signals the end of input. It is not processed as data. Example: 0 in our Number Analyzer.",
                "Loops", "W6"
            },
            {
                "Explain the priming read pattern.",
                "Read input once BEFORE the loop to initialize the loop variable, then read again at the BOTTOM of the loop body.",
                "Loops", "W6"
            },
            {
                "What is the difference between a counter and an accumulator?",
                "A counter tracks how many times something happens (count++). An accumulator tracks a running total (total += value).",
                "Loops", "W6"
            },
            {
                "When would you use do-while instead of while?",
                "When the body must execute at least once — like input validation. do-while checks the condition AFTER the first run.",
                "Loops", "W6"
            },

            // Week 5 Review (2 questions)
            {
                "What is the difference between single quotes and double quotes in Java?",
                "Single quotes are for char literals ('A'). Double quotes are for String literals (\"hello\").",
                "Characters", "W5"
            },
            {
                "How do you read a single character from Scanner?",
                "input.nextLine().charAt(0) — there is no nextChar() method in Scanner.",
                "Characters", "W5"
            },

            // General (1 question)
            {
                "What does n % 10 give you? What about n / 10?",
                "n % 10 gives the last digit (remainder). n / 10 removes the last digit (integer division).",
                "Math Operations", "General"
            },
        };

        // ---- SHUFFLE MODE ----
        ArrayList<Integer> studentOrder = new ArrayList<>();
        for (int i = 0; i < students.length; i++) {
            studentOrder.add(i);
        }
        Collections.shuffle(studentOrder);
        int studentIndex = 0;

        // ---- MAIN LOOP ----
        System.out.println("==========================================");
        System.out.println("  COP2250 Week 7 Picker — Methods");
        System.out.println("  Students: " + students.length);
        System.out.println("  Questions: " + questions.length);
        System.out.println("==========================================");
        System.out.println("  ENTER = next pick / reveal answer");
        System.out.println("  s     = reshuffle students");
        System.out.println("  q     = quit");
        System.out.println("==========================================\n");

        boolean waitingForAnswer = false;
        String currentAnswer = "";

        while (true) {
            String line = scanner.nextLine().trim().toLowerCase();

            if (line.equals("q")) {
                System.out.println("Done.");
                break;
            }

            if (line.equals("s")) {
                Collections.shuffle(studentOrder);
                studentIndex = 0;
                waitingForAnswer = false;
                System.out.println(">> Reshuffled. No repeats until everyone's been picked.\n");
                continue;
            }

            // Second Enter — reveal answer
            if (waitingForAnswer) {
                System.out.println("  ANSWER:   " + currentAnswer);
                System.out.println("------------------------------------------\n");
                waitingForAnswer = false;
                continue;
            }

            // First Enter — pick student + question
            if (studentIndex >= studentOrder.size()) {
                Collections.shuffle(studentOrder);
                studentIndex = 0;
                System.out.println(">> All students picked. Reshuffled.\n");
            }

            String student = students[studentOrder.get(studentIndex)];
            studentIndex++;

            int qIdx = random.nextInt(questions.length);
            String question = questions[qIdx][0];
            currentAnswer = questions[qIdx][1];
            String topic = questions[qIdx][2];
            String week = questions[qIdx][3];

            System.out.println("------------------------------------------");
            System.out.printf("  STUDENT:  %s%n", student);
            System.out.printf("  TOPIC:    %s [%s]%n", topic, week);
            System.out.printf("  QUESTION: %s%n", question);
            System.out.println("");
            System.out.println("  >> Press ENTER to reveal answer...");

            waitingForAnswer = true;
        }

        scanner.close();
    }
}
