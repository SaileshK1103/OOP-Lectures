package task_1;

public class Bus implements Vehicle{
    private String fuel;
    private String color;
    private int capacity;

    public Bus(String fuel, String color,  int capacity) {
        this.fuel = fuel;
        this.color = color;
        this.capacity = capacity;
    }

    @Override
    public void start(){
        System.out.println("Bus is starting");
    }

    @Override
    public void stop(){
        System.out.println("Bus is stopping");
    }

    @Override
    public String getInfo(){
        return "Type : Bus\nFuel: "+fuel+ "\nCapacity:" +capacity+ " passengers" +"\nColor"+color;
    }
}
