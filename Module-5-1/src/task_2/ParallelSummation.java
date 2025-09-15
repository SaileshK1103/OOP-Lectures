package task_2;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class ParallelSummation {
    public static void main(String[] args) {

        // Generate large array of random integers
        int arraySize = 100000;
        int[] numbers = new int[arraySize];
        Random rand = new Random();
        for (int i = 0; i < arraySize; i++) {
            numbers[i] = rand.nextInt(100);
        }

        // Determine number of cores
        int numCores = Runtime.getRuntime().availableProcessors();
        System.out.println("Number of processors cores: " + numCores);
        // Divide the array
        int chunkSize = arraySize / numCores;
        // Store both Runnable objects and threads objects
        List<SumThread> runnables = new ArrayList<>();
        List<Thread> threads = new ArrayList<>();
        // Create and start threads
        for(int i =0; i < numCores; i++){
            int start = i * chunkSize;
            int end = (i == numCores - 1) ? arraySize : start + chunkSize;
            SumThread sumThread = new SumThread(numbers, start, end);
            runnables.add(sumThread); // Store the Runnabl
            Thread thread = new Thread(sumThread);
            threads.add(thread);
            thread.start();
        }

        // Join threads and calculate total sum
        long parallelSum = 0;
        for(int i = 0; i< numCores; i++){
            try {
                threads.get(i).join(); // Join the correct thread
                parallelSum += runnables.get(i).getPartialSum(); // Get sum from the runnable
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        System.out.println("Parallel Sum: " + parallelSum);
    }
}
