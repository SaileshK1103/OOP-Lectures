package task_3;

public class ElectricCar extends AbstractVehicle {
    public ElectricCar(String color){
        super("ElectricCar", "Electricity", color);
    }

    @Override
    public void charge() {
        System.out.println("Charging the electric car....");
    }
}
