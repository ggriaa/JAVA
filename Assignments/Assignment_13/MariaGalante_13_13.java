/**
 * MariaGalante_13_13.java
 * COP 2250 - Assignment 13
 * Abstract Classes and Interfaces (Liang Ch. 13)
 *
 * Name: Maria Galante
 * Date: 4-26-2026
 *
 * This program demonstrates abstract classes, interfaces,
 * inheritance, and polymorphism using geometric objects.
 * It creates Circle, Rectangle, and Triangle objects,
 * displays area, perimeter, color, and how to color them.
 */

// -------------------------------------------------------
// Public class with main method.
// -------------------------------------------------------
public class MariaGalante_13_13 {

    public static void main(String[] args) {

        // Use try/catch to prevent program crash.
        try {

            // Create objects using GeometricObject references.
            GeometricObject r = new Rectangle_MG(4.0, 6.0, "blue");
            GeometricObject c = new Circle_MG(5.0, "red");
            GeometricObject t = new Triangle_MG(3.0, 4.0, 5.0, "green");

            // Display rectangle information.
            System.out.println("--- Rectangle ---");
            System.out.println(r);
            ((Colorable) r).howToColor();

            System.out.println();

            // Display circle information.
            System.out.println("--- Circle ---");
            System.out.println(c);
            ((Colorable) c).howToColor();

            System.out.println();

            // Display triangle information.
            System.out.println("--- Triangle ---");
            System.out.println(t);
            ((Colorable) t).howToColor();
        }

        // Catch unexpected errors.
        catch (Exception e) {
            System.out.println("An error occurred.");
        }
    }
}

// -------------------------------------------------------
// Rectangle class.
// -------------------------------------------------------
class Rectangle_MG extends GeometricObject implements Colorable {

    private double width;
    private double height;

    public Rectangle_MG(double width, double height, String color) {
        super(color);
        this.width = width;
        this.height = height;
    }

    public double getArea() {
        return width * height;
    }

    public double getPerimeter() {
        return 2 * (width + height);
    }

    public void howToColor() {
        System.out.println("Color all four sides.");
    }
}

// -------------------------------------------------------
// Circle class.
// -------------------------------------------------------
class Circle_MG extends GeometricObject implements Colorable {

    private double radius;

    public Circle_MG(double radius, String color) {
        super(color);
        this.radius = radius;
    }

    public double getArea() {
        return Math.PI * radius * radius;
    }

    public double getPerimeter() {
        return 2 * Math.PI * radius;
    }

    public void howToColor() {
        System.out.println("Color the entire circle.");
    }
}

// -------------------------------------------------------
// Triangle class.
// -------------------------------------------------------
class Triangle_MG extends GeometricObject implements Colorable {

    private double side1;
    private double side2;
    private double side3;

    public Triangle_MG(double side1, double side2, double side3, String color) {
        super(color);
        this.side1 = side1;
        this.side2 = side2;
        this.side3 = side3;
    }

    public double getArea() {

        // Use Heron's formula.
        double s = getPerimeter() / 2;
        return Math.sqrt(s * (s - side1) * (s - side2) * (s - side3));
    }

    public double getPerimeter() {
        return side1 + side2 + side3;
    }

    public void howToColor() {
        System.out.println("Color all three sides.");
    }
}

// -------------------------------------------------------
// Abstract GeometricObject class.
// -------------------------------------------------------
abstract class GeometricObject {

    private String color;

    public GeometricObject(String color) {
        this.color = color;
    }

    public String getColor() {
        return color;
    }

    public abstract double getArea();

    public abstract double getPerimeter();

    public String toString() {
        return "Color: " + color +
               "\nArea: " + getArea() +
               "\nPerimeter: " + getPerimeter();
    }
}

// -------------------------------------------------------
// Colorable interface.
// -------------------------------------------------------
interface Colorable {

    void howToColor();
}
