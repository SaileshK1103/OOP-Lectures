package task_2;

import task_1.Car;

public class Bus  extends Car {
    private int passengerCount;

    // Constructor 1
    public Bus(String typeName) {
        super(typeName);   // calls Car(String typeName)
        this.passengerCount = 0;
    }

    // Constructor 2 (matching Car’s second constructor)
    public Bus(String typeName, double speed, double maxTankCapacity) {
        super(typeName, speed, maxTankCapacity);   // calls Car(String, double, double)
        this.passengerCount = 0;
    }

    // Passenger enter
    public void passengerEnter(int count) {
        if (count > 0) {
            passengerCount += count;
            System.out.println(count + " passengers entered the bus. Total: " + passengerCount);
        }
    }

    // Passenger exit
    public void passengerExit(int count) {
        if (count > 0 && count <= passengerCount) {
            passengerCount -= count;
            System.out.println(count + " passengers exited the bus. Total: " + passengerCount);
        }
    }

    public int getPassengerCount() {
        return passengerCount;
    }

    @Override
    public void accelerate() {
        if (getGasolineLevel() > 0) {
            // slower acceleration
            double newSpeed = getSpeed() + 5;
            double newFuel = getGasolineLevel() - 1;
            // update inherited fields via methods
            super.decelerate(0); // just to keep design consistent
            try {
                java.lang.reflect.Field speedField = Car.class.getDeclaredField("speed");
                speedField.setAccessible(true);
                speedField.set(this, newSpeed);

                java.lang.reflect.Field fuelField = Car.class.getDeclaredField("gasolineLevel");
                fuelField.setAccessible(true);
                fuelField.set(this, newFuel);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }
}
