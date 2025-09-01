package task_4;

public class VehicleDemo {
    public static void main(String[] args) {
        AbstractVehicle car = new Car("Petrol", "Red", 25.0); // mpg
        AbstractVehicle bus = new Bus("Diesel", "Black", 40, 8.0); // mpg
        AbstractVehicle moto = new Motorcycle("Gasoline", "Yellow", 45.0); // mpg
        AbstractVehicle eCar = new ElectricCar("Blue", 0.2); // kWh/km
        AbstractVehicle eMoto = new ElectricMotorcycle("White", 0.1); // kWh/km

        System.out.println("\nVehicle Demonstration - Task 4\n");

        AbstractVehicle[] vehicles = {car, bus, moto, eCar, eMoto};

        for (AbstractVehicle v : vehicles) {
            v.start();
            v.charge();
            System.out.println(v.getInfo());
            System.out.println("Fuel Efficiency: " + v.calculateFuelEfficiency() +
                    (v.fuel.equals("Electricity") ? " kWh/km" : " mpg"));
            v.stop();
            System.out.println();
        }
    }
}
