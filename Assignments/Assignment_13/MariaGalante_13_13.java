/**
 * MariaGalante_13_13.java
 * COP 2250 - Assignment 13
 * Chapter 13: Abstract Classes and Interfaces
 *
 * Name: Maria Galante
 * Date: 4-26-2026
 *
 * This program creates Rectangle, Circle, and Triangle
 * objects using inheritance from an abstract class.
 * The program asks the user for dimensions, color,
 * and filled status. It displays area, perimeter,
 * color, and whether filled. It also compares areas
 * and perimeters using GeometricObject references.
 */

import java.util.Scanner;

// -------------------------------------------------------
// Public class with main method.
// -------------------------------------------------------
public class MariaGalante_13_13 {

    public static void main(String[] args) {

        // Create Scanner for user input.
        Scanner input = new Scanner(System.in);

        try {

            // ---------------------------------------------------
            // Rectangle input
            // ---------------------------------------------------
            System.out.print("Enter rectangle length: ");
            double length = input.nextDouble();

            System.out.print("Enter rectangle width: ");
            double width = input.nextDouble();

            input.nextLine();

            System.out.print("Enter rectangle color: ");
            String rectColor = input.nextLine();

            System.out.print("Is rectangle filled (true/false): ");
            boolean rectFilled = input.nextBoolean();

            // ---------------------------------------------------
            // Circle input
            // ---------------------------------------------------
            System.out.print("\nEnter circle radius: ");
            double radius = input.nextDouble();

            input.nextLine();

            System.out.print("Enter circle color: ");
            String circleColor = input.nextLine();

            System.out.print("Is circle filled (true/false): ");
            boolean circleFilled = input.nextBoolean();

            // ---------------------------------------------------
            // Triangle input
            // ---------------------------------------------------
            System.out.print("\nEnter triangle side 1: ");
            double side1 = input.nextDouble();

            System.out.print("Enter triangle side 2: ");
            double side2 = input.nextDouble();

            System.out.print("Enter triangle side 3: ");
            double side3 = input.nextDouble();

            input.nextLine();

            System.out.print("Enter triangle color: ");
            String triColor = input.nextLine();

            System.out.print("Is triangle filled (true/false): ");
            boolean triFilled = input.nextBoolean();

            // ---------------------------------------------------
            // Create objects using polymorphism
            // ---------------------------------------------------
            GeometricObject rect =
                new Rectangle_MG(length, width, rectColor, rectFilled);

            GeometricObject circle =
                new Circle_MG(radius, circleColor, circleFilled);

            GeometricObject tri =
                new Triangle_MG(side1, side2, side3, triColor, triFilled);

            // ---------------------------------------------------
            // Display Rectangle
            // ---------------------------------------------------
            System.out.println("\n--- Rectangle ---");
            System.out.println(rect);
            ((Colorable) rect).howToColor();

            // ---------------------------------------------------
            // Display Circle
            // ---------------------------------------------------
            System.out.println("\n--- Circle ---");
            System.out.println(circle);
            ((Colorable) circle).howToColor();

            // ---------------------------------------------------
            // Display Triangle
            // ---------------------------------------------------
            System.out.println("\n--- Triangle ---");
            System.out.println(tri);
            ((Colorable) tri).howToColor();

            // ---------------------------------------------------
            // Compare Areas
            // ---------------------------------------------------
            System.out.println("\nRectangle and Circle equal area: "
                    + equalArea(rect, circle));

            // ---------------------------------------------------
            // Compare Perimeters
            // ---------------------------------------------------
            System.out.println("Rectangle and Circle equal perimeter: "
                    + equalPerimeter(rect, circle));

            System.out.println("Rectangle and Triangle equal perimeter: "
                    + equalPerimeter(rect, tri));

            System.out.println("Circle and Triangle equal perimeter: "
                    + equalPerimeter(circle, tri));
        }

        // Catch invalid input errors.
        catch (Exception e) {
            System.out.println("Invalid input entered.");
        }

        input.close();
    }

    // -------------------------------------------------------
    // Compare area of two objects.
    // -------------------------------------------------------
    public static boolean equalArea(
            GeometricObject obj1,
            GeometricObject obj2) {

        return obj1.getArea() == obj2.getArea();
    }

    // -------------------------------------------------------
    // Compare perimeter of two objects.
    // -------------------------------------------------------
    public static boolean equalPerimeter(
            GeometricObject obj1,
            GeometricObject obj2) {

        return obj1.getPerimeter() == obj2.getPerimeter();
    }
}

// -------------------------------------------------------
// Rectangle class.
// -------------------------------------------------------
class Rectangle_MG extends GeometricObject
        implements Colorable {

    private double length;
    private double width;

    public Rectangle_MG(
            double length,
            double width,
            String color,
            boolean filled) {

        super(color, filled);
        this.length = length;
        this.width = width;
    }

    public double getArea() {
        return length * width;
    }

    public double getPerimeter() {
        return 2 * (length + width);
    }

    public void howToColor() {
        System.out.println("Color all four sides.");
    }
}

// -------------------------------------------------------
// Circle class.
// -------------------------------------------------------
class Circle_MG extends GeometricObject
        implements Colorable {

    private double radius;

    public Circle_MG(
            double radius,
            String color,
            boolean filled) {

        super(color, filled);
        this.radius = radius;
    }

    public double getArea() {
        return Math.PI * radius * radius;
    }

    public double getPerimeter() {
        return 2 * Math.PI * radius;
    }

    public void howToColor() {
        System.out.println("Color the circle.");
    }
}

// -------------------------------------------------------
// Triangle class.
// -------------------------------------------------------
class Triangle_MG extends GeometricObject
        implements Colorable {

    private double side1;
    private double side2;
    private double side3;

    public Triangle_MG(
            double side1,
            double side2,
            double side3,
            String color,
            boolean filled) {

        super(color, filled);
        this.side1 = side1;
        this.side2 = side2;
        this.side3 = side3;
    }

    public double getArea() {

        double s = getPerimeter() / 2;

        return Math.sqrt(
                s *
                (s - side1) *
                (s - side2) *
                (s - side3));
    }

    public double getPerimeter() {
        return side1 + side2 + side3;
    }

    public void howToColor() {
        System.out.println("Color all three sides.");
    }
}

// -------------------------------------------------------
// Abstract class GeometricObject.
// -------------------------------------------------------
abstract class GeometricObject {

    private String color;
    private boolean filled;

    public GeometricObject(
            String color,
            boolean filled) {

        this.color = color;
        this.filled = filled;
    }

    public String getColor() {
        return color;
    }

    public boolean isFilled() {
        return filled;
    }

    public abstract double getArea();

    public abstract double getPerimeter();

    public String toString() {

        return "Color: " + color +
               "\nFilled: " + filled +
               "\nArea: " + getArea() +
               "\nPerimeter: " + getPerimeter();
    }
}

// -------------------------------------------------------
// Interface Colorable.
// -------------------------------------------------------
interface Colorable {

    void howToColor();
}
