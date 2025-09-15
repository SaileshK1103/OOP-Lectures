package task_1;

public class OddThread  extends Thread {
    private int max;
    private Printer printer;

    public OddThread(int max, Printer printer) {
        this.max = max;
        this.printer = printer;
    }
    @Override
    public void run() {
        for (int i = 1; i <= max; i += 2) {
            printer.printOdd(i);
        }
    }
}
