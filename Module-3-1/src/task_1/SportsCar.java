package task_1;

public class SportsCar extends Car{
    public SportsCar(String typeName) {
        super(typeName);
    }

    public SportsCar(String typeName, double speed, double maxTankCapacity) {
        super(typeName, speed, maxTankCapacity);
    }

    @Override
    public void accelerate(){
        if (getGasolineLevel() > 0) {
            // Faster acceleration, higher fuel usage
            double newSpeed = getSpeed() + 20;
            double newFuel = Math.max(0, getGasolineLevel() - 2);

            try {
                java.lang.reflect.Field speedField = Car.class.getDeclaredField("speed");
                java.lang.reflect.Field fuelField = Car.class.getDeclaredField("gasolineLevel");
                speedField.setAccessible(true);
                fuelField.setAccessible(true);

                speedField.setDouble(this, newSpeed);
                fuelField.setDouble(this, newFuel);

            } catch (Exception e) {
                e.printStackTrace();
            }

        } else {
            System.out.println(getTypeName() + " has no fuel left. It cannot accelerate.");
        }
    }
}
