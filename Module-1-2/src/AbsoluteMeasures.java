import java.util.Scanner;

public class AbsoluteMeasures {
    public static void main(String[] args){
        Scanner input  = new Scanner(System.in);
        // Constants
        final double Luoti_Grams = 13.28;
        final double Naula_Grams = 32 * Luoti_Grams;
        final double Leiviska_Grams = 20 * Naula_Grams;

        //User input
        System.out.print("Enter the weight in grams: ");
        double grams = input.nextDouble();
        // Convert to leiviska
        int leiviska = (int) (grams / Leiviska_Grams);
        grams = grams % Leiviska_Grams;
        // Convert to naula
        int naula = (int) (grams / Naula_Grams);
        grams = grams % Naula_Grams;
        // Convert to luoti (double with 2 decimal)
        double luoti = grams / Luoti_Grams;
        // Print Result
        System.out.printf("%.0f grams is %d leiviskä, %d naula, and %.2f luoti.\n",
                (leiviska * Leiviska_Grams + naula * Naula_Grams + luoti * Luoti_Grams)
                ,leiviska, naula, luoti);

        input.close();


    }
}
