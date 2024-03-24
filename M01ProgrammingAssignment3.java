import java.util.Scanner;

public class M01ProgrammingAssignment3 {
  public static void main(String[] args) {
    Scanner scanner = new Scanner(System.in);

    int[][] m1 = enterArray(scanner, 3, 3);
    int[][] m2 = enterArray(scanner, 3, 3);

    if (equals(m1, m2)) {
      System.out.println("The two arrays are identical.");
    } else {
      System.out.println("The two arrays are not identical.");
    }
  }

  //If arrays don't match, returns false
  public static boolean equals(int[][] m1, int[][] m2) {
    for (int i = 0; i < m1.length; i++) {
      for (int j = 0; j < m1[i].length; j++) {
        if (m1[i][j] != m2[i][j]) {
          return false;
        }
      }
    }

    return true;
  }
  //Method for prompting the user to enter the two multi-dimensional arrays
  public static int[][] enterArray(Scanner scanner, int rows, int cols) {
    int[][] array = new int[rows][cols];
    System.out.println("Enter elements for a " + rows + "x" + cols + " array:");
    for (int i = 0; i < rows; i++) {
      for (int j = 0; j < cols; j++) {
        array[i][j] = scanner.nextInt();
      }
    }
    return array;
  }
}