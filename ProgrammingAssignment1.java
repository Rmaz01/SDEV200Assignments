import java.util.Scanner;

public class ProgrammingAssignment1 {
  
  public static void main(String[] args) {
    double feetCount;
    double meterCount = 15;
    System.out.printf("%-10s%-10s%-10s%-10s\n%-10s", "Feet", "Meters", "Meters", "Feet", "----------------------------------------");
    for (feetCount = 1; feetCount <= 10; feetCount++) {
      System.out.printf("\n%-10.1f%-10.3f%-10.1f%-10.3f", feetCount, footToMeter(feetCount), meterCount += 5, meterToFoot(meterCount));   
    }
  }

  public static double footToMeter(double foot) {
    double meter;
    meter = 0.305 * foot;
    return meter;
  }

  public static double meterToFoot(double meter) {
    double foot;
    foot = 3.279 * meter;
    return foot;
  }
}