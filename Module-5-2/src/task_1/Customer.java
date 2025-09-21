package task_1;

public class Customer implements Runnable {
    private Theater theater;
    private String name;
    private int tickets;

    public Customer(Theater theater, String name, int tickets) {
        this.theater = theater;
        this.name = name;
        this.tickets = tickets;
    }

    @Override
    public void run(){
        theater.reserve(name, tickets);
    }
}
