/**
 * Assignment 4: Vowel or Consonant Checker
 * 
 * COP2250 Java Programming
 * Kevin Pyatt, Ph.D. | Pyatt Labs
 * 
 * Write a program that prompts the user to enter a letter
 * and checks whether it is a vowel or consonant.
 * For non-letter input, display "invalid input".
 */

import java.util.Scanner;

public class Assignment_4 {
    public static void main(String[] args) {
        
        // ============================================
        // ACT 1: SET THE STAGE
        // ============================================
        
        // TODO 1: Create a Scanner object called "input"
        Scanner input = new Scanner(System.in);
        
        // ============================================
        // ACT 2: GET USER INPUT
        // ============================================
        
        // TODO 2: Print the prompt: "Enter a letter: "
        //         (no newline - use print, not println)
        System.out.print("Enter a letter: ");
        
        // TODO 3: Read the input as a String using nextLine()
        String s = input.nextLine();
        
        // TODO 4: Extract the first character using charAt(0)
        //         Store in a variable called 'ch'
        char ch = s.charAt(0);
        
        // ============================================
        // ACT 3: VALIDATE INPUT
        // ============================================
        
        // TODO 5: Check if ch is a letter using Character.isLetter()
        //         If NOT a letter, print: "X is invalid input"
        //         (where X is the character they entered)
        //         Use an if statement here
        if (!Character.isLetter(ch)) {
           System.out.println(ch + " is invalid input");
        } else {
        
        // ============================================
        // ACT 4: CHECK VOWEL OR CONSONANT
        // ============================================
        
        // TODO 6: If it IS a letter, convert to lowercase
        //         Store in a variable called 'lower'
        char lower = Character.toLowerCase(ch);
        
        // TODO 7: Check if lower is a vowel (a, e, i, o, u)
        //         If vowel, print: "X is a vowel"
        //         If consonant, print: "X is a consonant"
        //         (where X is the ORIGINAL character they entered)
        if (lower == 'a'|| lower == 'e' || lower == 'i' || lower == 'o' || lower == 'u') {
            System.out.println(ch + " is a vowel");
        } else {
            System.out.println(ch + " is a consonant");       
        }

        }
    }
}
