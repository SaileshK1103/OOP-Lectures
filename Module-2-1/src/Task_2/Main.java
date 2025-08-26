package Task_2;

public class Main {
    public static void main(String[] args) {
        Car toyota = new Car("Toyota");
        toyota.fillTank();  // Fill tank
        System.out.println(toyota.getTypeName() + " tank: " + toyota.getGasolineLevel());

        // Accelerate 3 times
        toyota.accelerate();
        toyota.accelerate();
        toyota.accelerate();
        System.out.println("Speed after accelerating: " + toyota.getSpeed());
        System.out.println("Tank after accelerating: " + toyota.getGasolineLevel());

        // Decelerate
        toyota.decelerate(15);
        System.out.println("Speed after decelerating: " + toyota.getSpeed());

        // Another car with custom values
        Car tesla = new Car("Tesla", 80, 50);
        System.out.println(tesla.getTypeName() + " speed: " + tesla.getSpeed()
                + ", tank: " + tesla.getGasolineLevel() + "/" + tesla.getMaxTankCapacity());
    }
}
