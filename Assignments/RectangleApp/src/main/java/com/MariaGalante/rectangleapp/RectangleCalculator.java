package com.MariaGalante.rectangleapp;

public class RectangleCalculator {

    public static void main(String[] args) {

        double width = 4.5;
        double height = 7.9;

        double area = width * height;
        double perimeter = 2 * (width + height);

        System.out.println("Rectangle width: " + width);
        System.out.println("Rectangle height: " + height);
        System.out.println("Area: " + area);
        System.out.println("Perimeter: " + perimeter);
    }
}
