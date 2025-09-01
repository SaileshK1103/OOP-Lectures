package task_4;

public class Bus extends AbstractVehicle{
    private int capacity;

    public Bus(String fuel, String color, int capacity, double fuelEfficiency) {
        super("Bus", fuel, color, fuelEfficiency);
        this.capacity = capacity;
    }

    @Override
    public String getInfo() {
        return super.getInfo() + "\nCapacity: " + capacity + " passengers";
    }
}
