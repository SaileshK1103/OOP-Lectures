import java.util.Scanner;

public class TriangleSidesCalculation {
    public static void main(String[] args)
    {
        Scanner input = new Scanner(System.in);

        // Input
        System.out.print("Enter the length of first side of triangle ");
        double a = input.nextDouble();

        System.out.print("Enter the length of second side of triangle ");
        double b = input.nextDouble();

        // Calculate the other side of triangle
        double hypotenuse = Math.sqrt(a*a + b*b);

        // Output
        System.out.printf("The hypotenuse is %.2f\n", hypotenuse);

        input.close();
    }
}
