import java.util.Scanner;

/**
 * MariaGalante_11_1.java
 * COP 2250 - Assignment 11
 *
 * Name: Maria Galante
 * Date: 04/21/2026
 */
public class MariaGalante_11_1 {

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        // Prompt user for three sides
        System.out.print("Enter side1: ");
        double side1 = input.nextDouble();

        System.out.print("Enter side2: ");
        double side2 = input.nextDouble();

        System.out.print("Enter side3: ");
        double side3 = input.nextDouble();

        // Create triangle object
        Triangle_MG triangle = new Triangle_MG(side1, side2, side3);

        // Prompt for color
        System.out.print("Enter color: ");
        String color = input.next();

        // Prompt for filled
        System.out.print("Enter filled (true/false): ");
        boolean filled = input.nextBoolean();

        // Set inherited values
        triangle.setColor(color);
        triangle.setFilled(filled);

        // Display results
        System.out.println("\nPerimeter: " + triangle.getPerimeter());
        System.out.println("Color: " + triangle.getColor());
        System.out.println("Filled: " + triangle.isFilled());
        System.out.println(triangle.toString());

        input.close();
    }
}

class Triangle_MG extends GeometricObject {

    // -------------------------------------------------------
    // STEP 1 - Declare three private double fields:
    //          side1, side2, side3
    // -------------------------------------------------------
    private double side1 = 1.0;
    private double side2 = 1.0;
    private double side3 = 1.0;

    // -------------------------------------------------------
    // STEP 2 - Default constructor
    // All three sides default to 1.0
    // Must call super()
    // -------------------------------------------------------
    public Triangle_MG() {
        super();
    }

    // -------------------------------------------------------
    // STEP 3 - Parameterized constructor
    // Accepts side1, side2, side3
    // Must call super()
    // -------------------------------------------------------
    public Triangle_MG(double side1, double side2, double side3) {
        super();
        this.side1 = side1;
        this.side2 = side2;
        this.side3 = side3;
    }

    // -------------------------------------------------------
    // STEP 4 - Getters for side1, side2, side3
    // -------------------------------------------------------
    public double getSide1() {
        return side1;
    }

    public double getSide2() {
        return side2;
    }

    public double getSide3() {
        return side3;
    }

    // -------------------------------------------------------
    // STEP 5 - getPerimeter()
    // Sum of all three sides
    // -------------------------------------------------------
    public double getPerimeter() {
        return side1 + side2 + side3;
    }

    // -------------------------------------------------------
    // STEP 6 - getArea()
    // Returns 0 as required
    // -------------------------------------------------------
    public double getArea() {
        return 0;
    }

    // -------------------------------------------------------
    // STEP 7 - toString()
    // -------------------------------------------------------
    public String toString() {
        return "Triangle: side1 = " + side1 +
               " side2 = " + side2 +
               " side3 = " + side3;
    }
}
