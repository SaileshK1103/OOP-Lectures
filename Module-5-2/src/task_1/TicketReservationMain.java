package task_1;

import java.util.Scanner;

public class TicketReservationMain {
    public static void main(String[] args) {
        Theater theater = new Theater(10); // total seats

        // Create customer threads using Runnable
        Thread t1 = new Thread(new Customer(theater, "Customer 1", 2));
        Thread t2 = new Thread(new Customer(theater, "Customer 2", 3));
        Thread t3 = new Thread(new Customer(theater, "Customer 3", 4));
        Thread t4 = new Thread(new Customer(theater, "Customer 4", 2));
        Thread t5 = new Thread(new Customer(theater, "Customer 5", 1));

        // Start all threads
        t1.start();
        t2.start();
        t3.start();
        t4.start();
        t5.start();
    }
}
