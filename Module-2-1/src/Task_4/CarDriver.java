package Task_4;

public class CarDriver {
    public static void main(String[] args) {
        Car myCar = new Car("Tesla", 50, 0);

        // Fill the tank
        myCar.fillTank();

        // Try setting cruise control
        myCar.setCruiseTargetSpeed(80);
        if (myCar.turnOnCruiseControl()) {
            System.out.println("Cruise control is ON. Target speed: " + myCar.getCruiseTargetSpeed());
        } else {
            System.out.println("Cruise control could not be turned on!");
        }

        // Simulate driving
        for (int i = 0; i < 10; i++) {
            myCar.updateSpeed();
            System.out.println("Current speed: " + myCar.getSpeed());
        }

        // Turn cruise control off
        myCar.turnOffCruiseControl();
        System.out.println("Cruise control is OFF.");
    }
}
