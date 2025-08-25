import java.util.Scanner;

public class MaxSubarraySum {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        // Input array size
        System.out.print("Enter the size of the array: ");
        int size = input.nextInt();

        int[] arr = new int[size];

        // Input array elements
        System.out.println("Enter the integers into the array: ");
        for (int i = 0; i < size; i++){
            System.out.print("Enter integer " + (i+1) + ": ");
            arr[i] = input.nextInt();
        }
        // find maximum sub-array sum
        int maxSum = Integer.MIN_VALUE;
        int startIndex = 0;
        int endIndex = 0;

        for (int i = 0; i < size; i++){
            int currentSum = 0;
            for (int j = i; j < size; j++){
                currentSum += arr[j];

                if (currentSum > maxSum){
                    maxSum = currentSum;
                    startIndex = i;
                    endIndex = j;
                }
            }
        }
        System.out.println("\nMax Subarray Sum: " + maxSum);
        System.out.println("Integers: " + (startIndex + 1) + "- " + (endIndex + 1));

        input.close();
    }
}
