import java.util.Scanner;

public class BinaryValues {
    public static void main(String[] args){
        Scanner input = new Scanner(System.in);
        // Input binary number as string
        System.out.print("Enter a binary number (Composed of Os and 1s): ");
        String binary = input.nextLine();

        int decimal = 0;
        int power = 0;
        //Loop through characters
        for (int i= binary.length()-1; i>=0; i--){
            char bit = binary.charAt(i);
            if(bit == '1' || bit == '0'){
                decimal += (int) Math.pow(2,power);
            }

            else if (bit >'1'){
                System.out.println("This is not a valid binary number "+bit);
            }
        }
        // Output
        System.out.print("Decimal equivalent: " +decimal);

        input.close();

    }
}
