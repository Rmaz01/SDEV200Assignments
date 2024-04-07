public class M03ProgrammingAssignment1 {
  /** Main method */
  public static void main(String[] args) {
    // Create three Circle objects
    Circle circle1 = new Circle(5, "red", true);
    Circle circle2 = new Circle(5, "green", false);
    Circle circle3 = new Circle(4, "green", false);

    // Display results
    System.out.println("Circle 1 radius: " + circle1.getRadius());
    System.out.println("Circle 2 radius: " + circle2.getRadius());
    System.out.println("Circle 3 radius: " + circle3.getRadius());

    System.out.println("\nCircle 1 is " + (circle1.equals(circle2) ? "" : "not ") +
      "equal to Circle 2");

    System.out.println("Circle 1 is " + (circle1.equals(circle3) ? "" : "not ") +
      "equal to Circle 3");
  }
}