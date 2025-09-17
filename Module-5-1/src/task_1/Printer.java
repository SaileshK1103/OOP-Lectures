package task_1;

import static java.lang.Thread.sleep;

public class Printer {
    private boolean isOddTurn = true;

    // Method to print odd numbers
    public void printOdd(int num){
        while(!isOddTurn){
            try {
                sleep(10);
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }
        }
        System.out.println("Odd Thread: " + num);
        isOddTurn = false;

    }
    // Method to print even numbers
    public void printEven(int num) {
        while (isOddTurn) {
            try {
                sleep(10);
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }
        }
        System.out.println("Even Thread: " + num);
        isOddTurn = true;
    }
}


