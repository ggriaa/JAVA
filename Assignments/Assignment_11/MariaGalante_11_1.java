import java.util.Scanner;

// Test Program
public class MariaGalante_11_1 {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        // Prompt user for triangle sides
        System.out.print("Enter side1 of triangle: ");
        double side1 = input.nextDouble();

        System.out.print("Enter side2 of triangle: ");
        double side2 = input.nextDouble();

        System.out.print("Enter side3 of triangle: ");
        double side3 = input.nextDouble();

        // Create triangle object
        Triangle_MG triangle = new Triangle_MG(side1, side2, side3);

        // Prompt for color
        System.out.print("Enter color: ");
        String color = input.next();

        // Prompt for filled
        System.out.print("Is the triangle filled? (true/false): ");
        boolean filled = input.nextBoolean();

        // Set inherited properties
        triangle.setColor(color);
        triangle.setFilled(filled);

        // Display results
        System.out.println("\nTriangle Information");
        System.out.println("Perimeter: " + triangle.getPerimeter());
        System.out.println("Color: " + triangle.getColor());
        System.out.println("Filled: " + triangle.isFilled());
        System.out.println(triangle.toString());

        input.close();
    }
}

// Triangle class
class Triangle_MG extends GeometricObject {
    private double side1 = 1.0;
    private double side2 = 1.0;
    private double side3 = 1.0;

    // No-arg constructor
    public Triangle_MG() {
    }

    // Constructor with 3 sides
    public Triangle_MG(double side1, double side2, double side3) {
        this.side1 = side1;
        this.side2 = side2;
        this.side3 = side3;
    }

    // Accessor methods
    public double getSide1() {
        return side1;
    }

    public double getSide2() {
        return side2;
    }

    public double getSide3() {
        return side3;
    }

    // Perimeter
    public double getPerimeter() {
        return side1 + side2 + side3;
    }

    // Area (required by GeometricObject)
    public double getArea() {
        return 0;
    }

    // toString
    public String toString() {
        return "Triangle: side1 = " + side1 +
               " side2 = " + side2 +
               " side3 = " + side3;
    }
}
