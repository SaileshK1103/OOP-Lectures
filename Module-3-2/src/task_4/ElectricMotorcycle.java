package task_4;

public class ElectricMotorcycle extends AbstractVehicle{
    public ElectricMotorcycle(String color, double fuelEfficiency) {
        super("Electric Motorcycle", "Electricity", color, fuelEfficiency);
    }

    @Override
    public void charge() {
        System.out.println("Charging the electric motorcycle...");
    }
}
