import java.util.Scanner;

public class M01ProgrammingAssignment2 {

  public static void main(String[] args) {
    Scanner input = new Scanner(System.in);
    System.out.print("Enter a credit card number as a long integer: ");
    long creditCardNumber = input.nextLong();

    if (isValid(creditCardNumber)) {
      System.out.println("The card number is valid.");
    } else {
      System.out.println("The card number is invalid.");
    }
  }

  /** Return true if the card number is valid */
  public static boolean isValid(long number) {
    int sum = sumOfDoubleEvenPlace(number) + sumOfOddPlace(number);
    return sum % 10 == 0;
  }

  /** Get the result from Step 2 */
  public static int sumOfDoubleEvenPlace(long number) {
    int sum = 0;
    boolean isSecondDigit = false;
    while (number > 0) {
      int digit = (int) (number % 10);
      if (isSecondDigit) {
        sum += getDigit(digit * 2);
      }
      isSecondDigit = !isSecondDigit;
      number /= 10;
    }
    return sum;
  }

  /**
   * Return this number if it is a single digit, otherwise,
   * return the sum of the two digits
   */
  public static int getDigit(int number) {
    if (number < 10) {
      return number;
    } else {
      return number / 10 + number % 10;
    }
  }

  /** Return sum of odd-place digits in number */
  public static int sumOfOddPlace(long number) {
    int sum = 0;
    while (number > 0) {
      sum += (int) (number % 10);
      number /= 100;
    }
    return sum;
  }
}