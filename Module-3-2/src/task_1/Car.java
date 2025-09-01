package task_1;

public class Car implements Vehicle{
    private String fuel;
    private String color;

    public Car(String fuel, String color) {
        this.fuel = fuel;
        this.color = color;
    }
    @Override
    public void start(){
        System.out.println("Car is starting");
    }

    @Override
    public void stop(){
        System.out.println("Car is stopping");
    }
    @Override
    public String getInfo(){
        return "Type: Car\nFuel: "+fuel+ "\nColor: "+color;
    }
}
