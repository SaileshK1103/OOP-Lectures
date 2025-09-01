package task_3;

public class VehicleDemo {
    public static void main(String[] args) {
        AbstractVehicle car = new Car("Petrol", "Red");
        AbstractVehicle motorcycle = new Motorcycle("Gasoline", "Yellow");
        AbstractVehicle bus = new Bus("Diesel", "Black", 40);
        AbstractVehicle eCar = new ElectricCar("Blue");
        AbstractVehicle eMoto = new ElectricMotorcycle("White");

        System.out.println("\nVehicle Demonstration - Task 3\n");

        car.start();
        car.charge(); // Not possible
        System.out.println(car.getInfo() + "\n");

        motorcycle.start();
        motorcycle.charge(); // Not possible
        System.out.println(motorcycle.getInfo() + "\n");

        bus.start();
        bus.charge(); // Not possible
        System.out.println(bus.getInfo() + "\n");

        eCar.start();
        eCar.charge(); // Charging
        System.out.println(eCar.getInfo() + "\n");

        eMoto.start();
        eMoto.charge(); // Charging
        System.out.println(eMoto.getInfo() + "\n");
    }
}
