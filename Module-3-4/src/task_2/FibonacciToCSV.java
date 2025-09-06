package task_2;

import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class FibonacciToCSV {
    public static void main(String args[]){
        String fileName = "fibonacci.csv";
        int n = 60;
        long[] fib = new long[n];

        fib[0] = 0;
        fib[1] = 1;

        for(int i=2; i<n; i++){
            fib[i] = fib[i-1] + fib[i-2];
        }

        try(FileWriter writer = new FileWriter(fileName)){
            for (long num : fib){
                writer.write(num + "\n");
            }
            System.out.println("Fibonacci sequence saved to " + fileName);
        }
        catch (IOException e){
            System.err.println(e);
        }
    }
}
