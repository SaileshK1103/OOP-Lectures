package task_2;

public class Main {
    public static void main(String[] args) {
        ThreadSafeList<String> tsList = new ThreadSafeList<>();

        Runnable task = () -> {
            for (int i = 0; i < 5; i++) {
                tsList.add(Thread.currentThread().getName() + "-Item" + i);
            }
        };

        Thread t1 = new Thread(task, "T1");
        Thread t2 = new Thread(task, "T2");
        Thread t3 = new Thread(task, "T3");

        t1.start();
        t2.start();
        t3.start();

        try {
            t1.join();
            t2.join();
            t3.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        tsList.print();
        System.out.println("Final size: " + tsList.size());
    }
}
