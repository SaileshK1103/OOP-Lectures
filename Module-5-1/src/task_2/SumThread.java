package task_2;

public class SumThread implements Runnable{
    private int[] numbers;
    private int start;
    private int end;
    private long partialSum;

    public SumThread(int[] numbers, int start, int end) {
        this.numbers = numbers;
        this.start = start;
        this.end = end;
        this.partialSum = 0;
    }

    @Override
    public void run() {
        for (int i = start; i < end; i++) {
            partialSum += numbers[i];
        }
    }
    // Return calculated partial sum
    public long getPartialSum() {
        return partialSum;
    }

}
