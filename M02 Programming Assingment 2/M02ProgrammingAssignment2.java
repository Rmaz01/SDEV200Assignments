import java.util.Scanner;

public class M02ProgrammingAssignment2 {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        // Prompt user for input
        System.out.print("Enter three sides of the triangle: ");
        double side1 = input.nextDouble();
        double side2 = input.nextDouble();
        double side3 = input.nextDouble();

        System.out.print("Enter the color of the triangle: ");
        String color = input.next();

        System.out.print("Is the triangle filled? (true/false): ");
        boolean filled = input.nextBoolean();

        // Create Triangle object
        Triangle triangle = new Triangle(side1, side2, side3);
        triangle.setColor(color);
        triangle.setFilled(filled);

        // Output
        System.out.println("Area: " + triangle.getArea());
        System.out.println("Perimeter: " + triangle.getPerimeter());
        System.out.println("Color: " + triangle.getColor());
        System.out.println("Filled: " + triangle.isFilled());

        input.close();
    }
}