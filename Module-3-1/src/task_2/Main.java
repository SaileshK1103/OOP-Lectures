package task_2;

import task_1.Car;
import task_1.SportsCar;

public class Main {
    public static void main(String[] args){

        // Normal car
        Car car = new Car("Family Car", 0, 50);
        car.fillTank();
        System.out.println(car.getTypeName() +"created with fuel: "+car.getGasolineLevel());

        // Sports Car
        SportsCar sportsCar = new SportsCar("Ferrari", 0, 60);
        sportsCar.fillTank();
        System.out.println(sportsCar.getTypeName() + " created with fuel: " + sportsCar.getGasolineLevel());

        // Bus
        Bus bus = new Bus("City Bus", 0, 150);
        bus.fillTank();
        System.out.println(bus.getTypeName() + " created with fuel: " + bus.getGasolineLevel());

        System.out.println("\n=== Acceleration Test ===");
        car.accelerate();
        sportsCar.accelerate();
        bus.accelerate();

        System.out.println(car.getTypeName() + " speed: " + car.getSpeed() + " | fuel: " + car.getGasolineLevel());
        System.out.println(sportsCar.getTypeName() + " speed: " + sportsCar.getSpeed() + " | fuel: " + sportsCar.getGasolineLevel());
        System.out.println(bus.getTypeName() + " speed: " + bus.getSpeed() + " | fuel: " + bus.getGasolineLevel());

        System.out.println("\n=== Bus Passenger Test ===");
        bus.passengerEnter(5);
        bus.passengerEnter(10);
        bus.passengerExit(3);
        System.out.println("Bus passengers: " + bus.getPassengerCount());

    }
}
