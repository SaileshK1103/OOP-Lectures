import java.util.Scanner;

public class PrimeNumberGenerator {
    public static void main(String[] args){
        Scanner input = new Scanner(System.in);

        // Input range
        System.out.print("Enter start number: ");
        int start = input.nextInt();

        System.out.print("Enter end number: ");
        int end = input.nextInt();

        // Generate primes
        System.out.print("Prime numbers between " + start + " and " + end + ":");

        for (int n = start; n<= end; n++){
            if (isPrime(n)){
                System.out.print(n + " ");
            }
        }
        input.close();
    }
    // Helper method to check if a number is prime
    public static boolean isPrime(int n){
        if (n <=1){
            return false;
        }
        for (int i = 2; i*i <= n; i++){
            if (n % i == 0){
                return false;
            }
        }
        return true;
    }
}
