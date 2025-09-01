package task_1;

public class Motorcycle implements Vehicle{
    private String fuel;
    private String color;

    public Motorcycle(String fuel, String color){
        this.fuel = fuel;
        this.color = color;
    }

    @Override
    public void start(){
        System.out.println("Motorcycle started");
    }

    @Override
    public void stop(){
        System.out.println("Motorcycle stopped");
    }

    @Override
    public String getInfo(){
        return "Type: Motorcycle\nFuel: "+fuel+ "\nColor: "+color;
    }
}
