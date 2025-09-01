package task_2;

public class VehicleDemo {
    public static void main(String[] args){
        AbstractVehicle car = new Car("Petrol", "Red");
        AbstractVehicle motorcycle = new Motorcycle("Gasoline", "Yellow");
        AbstractVehicle bus = new Bus("Disel","Green", 50);

        System.out.println("\nVehicle Demonstration\n");

        car.start();
        car.stop();
        System.out.println(car.getInfo() + "\n");

        motorcycle.start();
        motorcycle.stop();
        System.out.println(motorcycle.getInfo() + "\n");

        bus.start();
        bus.stop();
        System.out.println(bus.getInfo() + "\n");

    }
}
