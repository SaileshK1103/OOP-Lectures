package task_1;

public class EvenThread extends  Thread {
    private int max;
    private Printer printer;

    public EvenThread(int max, Printer printer) {
        this.max = max;
        this.printer = printer;
    }
    @Override
    public void run() {
        for (int i = 2; i <= max; i += 2) {
            printer.printEven(i);
        }
    }
}
