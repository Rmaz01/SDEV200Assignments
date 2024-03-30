import java.util.Scanner;

class BinaryFormatException extends Exception {
    public BinaryFormatException(String message) {
        super(message);
    }
}

public class M02ProgrammingAssignment3 {
    public static void main(String[] args) {
      Scanner input = new Scanner(System.in);
      
        String binaryString = input.nextLine(); //User inputs binary string
        try {
            int decimalValue = bin2Dec(binaryString);
            System.out.println("Decimal value of " + binaryString + " is " + decimalValue);
        } catch (BinaryFormatException e) {
            System.out.println(e.getMessage());
        }
    }

    public static int bin2Dec(String binaryString) throws BinaryFormatException {
        if (!binaryString.matches("[01]+")) {
            throw new BinaryFormatException("Invalid binary string: " + binaryString);
        }
        return Integer.parseInt(binaryString, 2);
    }
}