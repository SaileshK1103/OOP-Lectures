package task_1;

public class NumberPrinterMain {
    public static void main(String[] args) {
        int max = 20;
        Printer printer = new Printer();

        Thread oddThread = new OddThread(max, printer);
        Thread evenThread = new EvenThread(max, printer);

        oddThread.start();
        evenThread.start();

        try {
            oddThread.join();
            evenThread.join();
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
        System.out.println("Printing completed.");
    }
}
