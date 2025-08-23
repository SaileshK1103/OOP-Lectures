import java.util.Scanner;

public class TemperatueConverter {
    public static void main(String[] args){
        Scanner input = new Scanner(System.in);
        // User input
        System.out.print("Enter the temperature in Fahrenheit: ");
        float fahrenheit = input.nextFloat();
        // Conversion
        float celsius = (fahrenheit - 32) * 5 / 9;
        // Result
        System.out.printf("The temperature in Celsius: %.1f\n", celsius);

        input.close();
    }
}
