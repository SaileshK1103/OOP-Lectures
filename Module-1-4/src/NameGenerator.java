import java.util.Scanner;

public class NameGenerator {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        // Arrays of names
        String[] firstNames = {"Ram", "Sailesh", "Niki", "Swostika", "Sandip", "Pradip", "Laxman"};
        String[] lastNames = {"Chettri", "Karki", "Lama", "Ranjit", "Sharma", "Gautam", "Bade"} ;

        // Ask user how many names to generate
        System.out.print("How many random names do you want to generate? ");
        int count = input.nextInt();

        // Generate names
        System.out.print("Generated Names:\n");
        for (int i = 0; i < count; i++) {
            int firstIndex = (int) (Math.random() * firstNames.length);
            int lastIndex = (int) (Math.random() * lastNames.length);

            String fullName = firstNames[firstIndex] + " " + lastNames[lastIndex];
            System.out.println((i + 1) +"." +fullName);
        }
        input.close();
    }
}
