package task_1;

public class Theater {
    private int availableSeats;

    public Theater(int seats) {
        this.availableSeats = seats;
    }
    // synchronized ensures only one thread can check and reserve at a time
    public synchronized boolean reserve(String customerName, int tickets){
        if (tickets <= availableSeats) {
            System.out.println(customerName + " reserved " + tickets + " tickets.");
            availableSeats -= tickets;
            return true;
        }
        else {
            System.out.println(customerName + "could not reserve " + tickets + " tickets.");
            return false;
        }
    }
}