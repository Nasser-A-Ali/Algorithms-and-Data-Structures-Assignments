import java.util.InputMismatchException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        int numOfTemperaturesToInput = 0;

        // Gather inputs
        Scanner scanner = new Scanner(System.in);
        while (numOfTemperaturesToInput <= 0) {
            System.out.print("How many temperatures would you like to input? ");
            try {
                numOfTemperaturesToInput = scanner.nextInt();
                if (numOfTemperaturesToInput <= 0) {
                    System.out.println("Number of temperatures to input must be an integer higher than 0.");
                }
            } catch (InputMismatchException e) {
                System.out.println("Number of temperatures to input must be an integer.");
                scanner.next(); // clear invalid input
            }
        }
        CreateArray TemperaturesArray = new CreateArray(numOfTemperaturesToInput);
        TemperaturesArray.assignValuesToArray(numOfTemperaturesToInput);

        // Final outputs (temperature average and number of temperatures above average)
        System.out.println("Average Temperature: " + TemperaturesArray.calculateAverage());
        System.out.println(TemperaturesArray.howManyAboveAverage());

        // Close scanner
        scanner.close();
    }
}