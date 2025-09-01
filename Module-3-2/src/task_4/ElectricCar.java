package task_4;

public class ElectricCar extends AbstractVehicle{
    public ElectricCar(String color, double fuelEfficiency) {
        super("Electric Car", "Electricity", color, fuelEfficiency);
    }

    @Override
    public void charge() {
        System.out.println("Charging the electric car...");
    }
}
