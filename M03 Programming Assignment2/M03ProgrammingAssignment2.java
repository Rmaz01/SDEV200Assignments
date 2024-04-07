import java.math.BigInteger;
import java.util.Scanner;

public class M03ProgrammingAssignment2 {
    
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        
        System.out.print("Enter the first rational number: ");
        int num1 = input.nextInt();
        int denom1 = input.nextInt();
        Rational r1 = new Rational(new BigInteger(String.valueOf(num1)), new BigInteger(String.valueOf(denom1)));

        
        System.out.print("Enter the second rational number: ");
        int num2 = input.nextInt();
        int denom2 = input.nextInt();
        Rational r2 = new Rational(new BigInteger(String.valueOf(num2)), new BigInteger(String.valueOf(denom2)));

        
        System.out.println(r1 + " + " + r2 + " = " + r1.add(r2));
        System.out.println(r1 + " - " + r2 + " = " + r1.subtract(r2));
        System.out.println(r1 + " * " + r2 + " = " + r1.multiply(r2));
        System.out.println(r1 + " / " + r2 + " = " + r1.divide(r2));
        System.out.println(r2 + " is " + r2.doubleValue());
 
    }
}
