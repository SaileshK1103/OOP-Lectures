package Task_4;

public class Car {
    private double speed;
    private double gasolineLevel;
    private String typeName;
    // New cruise control variables
    private boolean cruiseOn;
    private double cruiseTargetSpeed;
    private final double MIN_CRUISE_SPEED = 30;
    private final double MAX_CRUISE_SPEED = 120;

    public Car(String typeName) {
        this(typeName, 100, 0);
    }

    public Car(String typeName, double gasolineLevel, double speed) {
        this.typeName = typeName;
        this.gasolineLevel = gasolineLevel;
        this.speed = speed;
        this.cruiseOn = false;
        this.cruiseTargetSpeed = 0;
    }

    // Existing methods
    public void accelerate() {
        if (gasolineLevel > 0)
            speed += 10;
        else
            speed = 0;
    }

    public void decelerate(int amount) {
        if (gasolineLevel > 0 && amount > 0)
            speed = Math.max(0, speed - amount);
        else
            speed = 0;
    }

    public double getSpeed() {
        return speed;
    }

    public String getTypeName() {
        return typeName;
    }

    public void fillTank() {
        gasolineLevel = 100;
    }

    public double getGasolineLevel() {
        return gasolineLevel;
    }
    // Cruise Control
    public void setCruiseTargetSpeed(double target) {
        cruiseTargetSpeed = target;
    }

    public double getCruiseTargetSpeed() {
        return cruiseTargetSpeed;
    }

    public boolean turnOnCruiseControl() {
        if (cruiseTargetSpeed >= MIN_CRUISE_SPEED &&
                cruiseTargetSpeed <= MAX_CRUISE_SPEED &&
                gasolineLevel > 0) {
            cruiseOn = true;
            return true;
        } else {
            cruiseOn = false;
            return false; // Could not enable cruise control
        }
    }

    public void turnOffCruiseControl() {
        cruiseOn = false;
    }

    public void updateSpeed() {
        if (cruiseOn) {
            if (gasolineLevel <= 0) {
                cruiseOn = false;
                System.out.println("Cruise control turned off due to empty tank!");
                return;
            }
            if (speed < cruiseTargetSpeed) {
                speed += 5; // accelerate gradually
            } else if (speed > cruiseTargetSpeed) {
                speed -= 5; // decelerate gradually
            }
        }
    }
}
