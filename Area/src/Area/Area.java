package Area;
import java.util.Scanner;
abstract class Shape {
    Scanner sc = new Scanner(System.in);
    double length, breadth;
    
    abstract double computeArea();
    void getDim(String dimension1, String dimension2) {
        System.out.println("Enter the " + dimension1 + ": ");
        length = sc.nextDouble();
        System.out.println("Enter the " + dimension2 + ": ");
        breadth = sc.nextDouble();
    }
}
class Rectangle extends Shape {
    double computeArea() {
        return length * breadth;
    }
}
class Triangle extends Shape {
    double computeArea() {
        return 0.5 * length * breadth;
    }
}
class Parallelogram extends Shape {
    double computeArea() {
        return length * breadth;
    }
}

class Rhombus extends Shape {
    double computeArea() {
        return 0.5 * length * breadth;
    }
}
public class Area {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n;
        Shape s;
        do {
            System.out.println("Find the area of: ");
            System.out.println("1. Rectangle");
            System.out.println("2. Triangle");
            System.out.println("3. Parallelogram");
            System.out.println("4. Rhombus");
            System.out.println("0. Exit");
            n = sc.nextInt();

            switch (n) {
                case 1:
                    s = new Rectangle();
                    s.getDim("length of the rectangle", "breadth of the rectangle");
                    System.out.println("Area of the rectangle: " + s.computeArea());
                    break;
                case 2:
                    s = new Triangle();
                    s.getDim("base of the triangle", "height of the triangle");
                    System.out.println("Area of the triangle: " + s.computeArea());
                    break;
                case 3:
                    s = new Parallelogram();
                    s.getDim("base of the parallelogram", "height of the parallelogram");
                    System.out.println("Area of the parallelogram: " + s.computeArea());
                    break;
                case 4:
                    s = new Rhombus();
                    s.getDim("diagonal1 of the rhombus", "diagonal2 of the rhombus");
                    System.out.println("Area of the rhombus: " + s.computeArea());
                    break;
                case 0:
                    System.out.println("Exiting...");
                    break;
                default:
                    System.out.println("Invalid choice! Please choose correctly.");
            }
        } while (n != 0);
        
        sc.close();
    }
}
