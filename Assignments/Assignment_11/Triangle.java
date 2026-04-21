/**
 * Triangle.java
 * COP 2250 - Assignment 11
 * Inheritance - Extending GeometricObject (Liang 11.1)
 *
 * Name: Maria Galante
 * Date: 04/21/2026
 */
public class Triangle extends GeometricObject {

    // -------------------------------------------------------
    // STEP 1 - Declare three private double fields:
    //          side1, side2, side3
    // -------------------------------------------------------
    private double side1;
    private double side2;
    private double side3;

    // -------------------------------------------------------
    // STEP 2 - Default constructor
    // All three sides default to 1.0
    // Must call super()
    // -------------------------------------------------------
    public Triangle() {
        super();
        side1 = 1.0;
        side2 = 1.0;
        side3 = 1.0;
    }

    // -------------------------------------------------------
    // STEP 3 - Parameterized constructor
    // Accepts side1, side2, side3
    // Must call super() — no color/filled required
    // -------------------------------------------------------
    public Triangle(double side1, double side2, double side3) {
        super();
        this.side1 = side1;
        this.side2 = side2;
        this.side3 = side3;
    }

    // -------------------------------------------------------
    // STEP 4 - Getters for side1, side2, side3
    // No setters required
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
    // STEP 5 - getArea()
    // Use Heron's formula:
    //   s = (side1 + side2 + side3) / 2
    //   area = Math.sqrt(s * (s-side1) * (s-side2) * (s-side3))
    // -------------------------------------------------------
    public double getArea() {
        double s = (side1 + side2 + side3) / 2.0;
        return Math.sqrt(s * (s - side1) * (s - side2) * (s - side3));
    }

    // -------------------------------------------------------
    // STEP 6 - getPerimeter()
    // Sum of all three sides
    // -------------------------------------------------------
    public double getPerimeter() {
        return side1 + side2 + side3;
    }

    // -------------------------------------------------------
    // STEP 7 - toString()
    // Must call super.toString() and append side info
    // -------------------------------------------------------
    @Override
    public String toString() {
        return super.toString() +
               "\nTriangle: side1 = " + side1 +
               " side2 = " + side2 +
               " side3 = " + side3;
    }

    // -------------------------------------------------------
    // MAIN - Test your Triangle class
    // Create two Triangle objects, print area, perimeter, toString
    // -------------------------------------------------------
    public static void main(String[] args) {
        Triangle t1 = new Triangle();
        Triangle t2 = new Triangle(3.0, 4.0, 5.0);

        System.out.println("Triangle 1:");
        System.out.printf("  Area: %.2f%n", t1.getArea());
        System.out.printf("  Perimeter: %.2f%n", t1.getPerimeter());
        System.out.println(t1.toString());

        System.out.println("\nTriangle 2:");
        System.out.printf("  Area: %.2f%n", t2.getArea());
        System.out.printf("  Perimeter: %.2f%n", t2.getPerimeter());
        System.out.println(t2.toString());
    }
}
