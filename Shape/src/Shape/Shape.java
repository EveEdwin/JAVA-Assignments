package Shape;

import java.util.Scanner;

abstract class Shape {
    Scanner sc = new Scanner(System.in);
    double length, breadth;

    // Abstract method to compute the area
    abstract double computeArea();

    // Method to input dimensions
    void getDim() {
        System.out.println("Enter the length: ");
        length = sc.nextDouble();
        System.out.println("Enter the breadth: ");
        breadth = sc.nextDouble();
    }
}

class Rectangle extends Shape {

    @Override
    void getDim() {
        System.out.println("Enter the length of the rectangle: ");
        length = sc.nextDouble();
        System.out.println("Enter the breadth of the rectangle: ");
        breadth = sc.nextDouble();
    }

    @Override
    double computeArea() {
        return length * breadth;
    }
}

class Triangle extends Shape {

    @Override
    void getDim() {
        System.out.println("Enter the base of the triangle: ");
        length = sc.nextDouble();
        System.out.println("Enter the height of the triangle: ");
        breadth = sc.nextDouble();
    }

    @Override
    double computeArea() {
        return 0.5 * length * breadth;
    }
}

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n;
        Shape s;
        do {
            System.out.println("Which shape you want to find the area of: ");
            System.out.println("1. Rectangle");
            System.out.println("2. Triangle");
            System.out.println("0. Exit");
            n = sc.nextInt();
            switch (n) {
                case 1:
                    s = new Rectangle();
                    s.getDim();
                    System.out.println("Area of the rectangle: " + s.computeArea());
                    break;
                case 2:
                    s = new Triangle();
                    s.getDim();
                    System.out.println("Area of the triangle: " + s.computeArea());
                    break;
                case 0:
                    System.out.println("Exited Successfully!!!");
                    break;
                default:
                    System.out.println("Invalid choice! Please try again.");
            }
        } while (n != 0);
        sc.close();
    }
}
