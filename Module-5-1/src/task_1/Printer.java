package task_1;

public class Printer {
    private boolean isOddTurn = true;

    // Method to print odd numbers
    public synchronized void printOdd(int num){
        while(!isOddTurn){
            try {
                wait();
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }
        }
        System.out.println("Odd Thread: " + num);
        isOddTurn = false;
        // Notify the odd thread
        notify();
    }
    // Method to print even numbers
    public synchronized void printEven(int num) {
        while (isOddTurn) {
            try {
                wait();
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }
        }
        System.out.println("Even Thread: " + num);
        isOddTurn = true;
        // Notify the even thread
        notify();
    }
}


