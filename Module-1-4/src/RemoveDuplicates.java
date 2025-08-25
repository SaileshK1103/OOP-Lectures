import java.util.Scanner;

public class RemoveDuplicates {
    public static void main(String[] args){
        Scanner input = new Scanner(System.in);
        // Input array size
        System.out.print("Enter the size of the array: ");
        int size = input.nextInt();

        int [] arr = new int[size];

        // Input array elements
        System.out.println("Enter the integers into the array: ");
        for (int i = 0; i < size; i++){
            System.out.print("Enter integer " + (i+1) + ": ");
            arr[i] = input.nextInt();
        }
        // Remove duplicates
        //New array for unique numbers
        int[] uniqueArr = new int[size];
        // how many unique numbers we have
        int uniqueCount = 0;

        for (int i= 0; i < size; i++){
            boolean alreadyExists = false;
            // Check if arr[i] already exists in uniqueArr
            for (int j = 0; j < uniqueCount; j++){
                if (arr[i] == uniqueArr[j]){
                    alreadyExists = true;
                    break;
                }
            }
            // if not found, add it to uniqueArr
            if(!alreadyExists){
                uniqueArr[uniqueCount] = arr[i];
                uniqueCount++;
            }
        }
        // Print result
        System.out.print("\nThe array without duplicates:");
        for(int i=0; i<uniqueCount; i++){
            System.out.print(uniqueArr[i] + " ");
        }
        input.close();

    }
}
