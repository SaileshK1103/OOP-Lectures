import java.util.Scanner;

public class QuadraticEquation {
    public static void main(String[] args){
        Scanner input = new Scanner(System.in);
        // USer input
        System.out.print("Enter the value of a: ");
        double a = Double.parseDouble(input.nextLine());
        System.out.print("Enter the value of b: ");
        double b = Double.parseDouble(input.nextLine());
        System.out.println("Enter the value of c: ");
        double c = Double.parseDouble(input.nextLine());
        // Compute discriminant
        double discriminant =  b*b - 4*a*c;
        // Check cases
        if(discriminant > 0){
            double root1 = (-b + Math.sqrt(discriminant)) / (2*a);
            double root2 = (-b - Math.sqrt(discriminant)) / (2*a);
            System.out.printf("Two real roots: %.2f and %.2f%n", root1, root2);
        }
        else if (discriminant == 0) {
            double root = -b / (2 * a);
            System.out.printf("One real root: %.2f%n", root);
        }
        else {
            System.out.println("No real roots");
        }
        input.close();
    }
}
