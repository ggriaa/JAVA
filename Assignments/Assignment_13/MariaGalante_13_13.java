/**
 * MariaGalante_13_13.java
 * COP 2250 - Assignment 13
 * Abstract Classes and Interfaces (Liang Ch. 13)
 *
 * Name: Maria Galante
 * Date: 4-26-2026
 *
 * This program demonstrates the use of an abstract class,
 * inheritance, interfaces, and polymorphism by creating
 * Circle and Rectangle objects through GeometricObject
 * references. It displays area, perimeter, color, and
 * how each object should be colored.
 *
 * All classes go in this one file.
 */

// -------------------------------------------------------
// STEP 1 - Colorable interface
// One method: void howToColor()
// -------------------------------------------------------
interface Colorable {

    // Method to describe how object is colored.
    void howToColor();
}

// -------------------------------------------------------
// STEP 2 - Abstract class GeometricObject
// private String color
// Constructor: GeometricObject(String color)
// getColor(): returns color
// abstract getArea()
// abstract getPerimeter()
// toString(): returns color, area, perimeter
// -------------------------------------------------------
abstract class GeometricObject {

    // Store color of object.
    private String color;

    // Constructor to set color.
    public GeometricObject(String color) {
        this.color = color;
    }

    // Return color.
    public String getColor() {
        return color;
    }

    // Abstract methods.
    public abstract double getArea();

    public abstract double getPerimeter();

    // Return object information.
    public String toString() {
        return "Color: " + color +
               "\nArea: " + getArea() +
               "\nPerimeter: " + getPerimeter();
    }
}

// -------------------------------------------------------
// STEP 3 - Circle extends GeometricObject implements Colorable
// private double radius
// Constructor: Circle(double radius, String color)
// getArea(), getPerimeter(), howToColor()
// -------------------------------------------------------
class Circle extends GeometricObject implements Colorable {

    // Store radius.
    private double radius;

    // Constructor.
    public Circle(double radius, String color) {
        super(color);
        this.radius = radius;
    }

    // Return area.
    public double getArea() {
        return Math.PI * radius * radius;
    }

    // Return perimeter.
    public double getPerimeter() {
        return 2 * Math.PI * radius;
    }

    // Describe coloring.
    public void howToColor() {
        System.out.println("Color the entire circle.");
    }
}

// -------------------------------------------------------
// STEP 4 - Rectangle extends GeometricObject implements Colorable
// private double width, height
// Constructor: Rectangle(double width, double height, String color)
// getArea(), getPerimeter(), howToColor()
// -------------------------------------------------------
class Rectangle extends GeometricObject implements Colorable {

    // Store dimensions.
    private double width;
    private double height;

    // Constructor.
    public Rectangle(double width, double height, String color) {
        super(color);
        this.width = width;
        this.height = height;
    }

    // Return area.
    public double getArea() {
        return width * height;
    }

    // Return perimeter.
    public double getPerimeter() {
        return 2 * (width + height);
    }

    // Describe coloring.
    public void howToColor() {
        System.out.println("Color all four sides.");
    }
}

// -------------------------------------------------------
// STEP 5 - Main: test both classes
// Store in GeometricObject references
// Print toString() and call howToColor() on each
// -------------------------------------------------------
public class MariaGalante_13_13 {

    public static void main(String[] args) {

        // Use try/catch to handle unexpected program errors.
        try {

            // Create objects using GeometricObject references.
            GeometricObject c = new Circle(5.0, "red");
            GeometricObject r = new Rectangle(4.0, 6.0, "blue");

            // Display circle information.
            System.out.println("--- Circle ---");
            System.out.println(c);
            ((Colorable) c).howToColor();

            // Blank line for spacing.
            System.out.println();

            // Display rectangle information.
            System.out.println("--- Rectangle ---");
            System.out.println(r);
            ((Colorable) r).howToColor();
        }

        // Catch any unexpected exception.
        catch (Exception e) {
            System.out.println("An error occurred.");
        }
    }
}
