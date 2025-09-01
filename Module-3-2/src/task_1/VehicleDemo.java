package task_1;

public class VehicleDemo {
    public static void main(String[] args){
        Vehicle car = new Car("Petrol", "Red");
        Vehicle bus = new Bus("Diseel", "Green",40);
        Vehicle motorcycle = new Motorcycle("Gasoline", "Yellow");

        System.out.println("Vehicle Demonstration\n");

        car.start();
        car.stop();
        System.out.println(car.getInfo() + "\n");

        bus.start();
        bus.stop();
        System.out.println(bus.getInfo() + "\n");

        motorcycle.start();
        motorcycle.stop();
        System.out.println(motorcycle.getInfo() + "\n");
    }
}
