/**
 * MariaGalante_10_03.java
 * Chapter 10 Assignment 10.3
 *
 * Name: Maria Galante
 * Description:
 * This program defines a class named MyInteger_MG that stores an integer value.
 * The class includes instance methods and static methods to determine whether
 * the value is even or odd. The class also includes equals methods for comparing
 * integer values and MyInteger_MG objects. A separate test class demonstrates
 * all required functionality.
 */


class MyInteger_MG
{

    // Data field that stores the integer value
    private int value;



    // Constructor that initializes the integer value
    public MyInteger_MG(int value)
    {
        this.value = value;
    }



    // Getter method that returns the stored integer value
    public int getValue()
    {
        return value;
    }



    // Returns true if the stored value is even
    public boolean isEven()
    {
        return value % 2 == 0;
    }



    // Returns true if the stored value is odd
    public boolean isOdd()
    {
        return value % 2 != 0;
    }



    // Static method that returns true if an integer parameter is even
    public static boolean isEven(int n)
    {
        return n % 2 == 0;
    }



    // Static method that returns true if an integer parameter is odd
    public static boolean isOdd(int n)
    {
        return n % 2 != 0;
    }



    // Static method that returns true if a MyInteger_MG object value is even
    public static boolean isEven(MyInteger_MG m)
    {
        return m.getValue() % 2 == 0;
    }



    // Static method that returns true if a MyInteger_MG object value is odd
    public static boolean isOdd(MyInteger_MG m)
    {
        return m.getValue() % 2 != 0;
    }



    // Returns true if the stored value equals the integer parameter
    public boolean equals(int n)
    {
        return value == n;
    }



    // Returns true if the stored value equals another object's value
    public boolean equals(MyInteger_MG m)
    {
        return value == m.getValue();
    }

}



public class MariaGalante_10_03
{

    public static void main(String[] args)
    {

        // Create MyInteger_MG objects for testing
        MyInteger_MG number1 = new MyInteger_MG(8);
        MyInteger_MG number2 = new MyInteger_MG(7);



        // Display stored values using getter method
        System.out.println("Value stored in number1: " + number1.getValue());
        System.out.println("Value stored in number2: " + number2.getValue());



        // Test instance methods
        System.out.println("number1 is even: " + number1.isEven());
        System.out.println("number1 is odd: " + number1.isOdd());

        System.out.println("number2 is even: " + number2.isEven());
        System.out.println("number2 is odd: " + number2.isOdd());



        // Test static methods with integer parameters
        System.out.println("10 is even: " + MyInteger_MG.isEven(10));
        System.out.println("11 is odd: " + MyInteger_MG.isOdd(11));



        // Test static methods with object parameters
        System.out.println("number1 is even (static method): "
                + MyInteger_MG.isEven(number1));

        System.out.println("number2 is odd (static method): "
                + MyInteger_MG.isOdd(number2));



        // Test equals methods
        System.out.println("number1 equals 8: " + number1.equals(8));

        System.out.println("number1 equals number2: "
                + number1.equals(number2));

    }

}
