package Task_2;

public class Car {
    private double speed;
    private double gasolineLevel;
    private double maxTankCapacity;
    private String typeName;

    // First Constructor
    public Car(String typeName){
        this.typeName = typeName;
        this.gasolineLevel = 0;
        this.maxTankCapacity = 100;
        this.speed = 0;
    }
    // Second constructor with tank capacity and speed
    public Car(String typeName, double speed, double maxTankCapacity ){
        this.typeName = typeName;
        this.speed = speed;
        this.maxTankCapacity = maxTankCapacity; // assuming tank is full
        this.gasolineLevel = maxTankCapacity;
    }
    // Accelerate by 10+, fuel -1
    public void accelerate(){
        if(gasolineLevel > 0){
            speed += 10;
            gasolineLevel = Math.max(0, gasolineLevel - 1);
        }
        else{
            speed = 0; // no fuel car stops
        }
    }

    public void decelerate(int amount){
        if(amount > 0) {
            speed = Math.max(0, speed - amount);
        }
    }
    // Fill the tank capacity
    public double getSpeed(){
        return speed;
    }
    public double getGasolineLevel(){
        return gasolineLevel;
    }

    public String getTypeName(){
        return typeName;
    }

    public void fillTank(){
        gasolineLevel = 100;
    }
    // Tank size getter
    public double getMaxTankCapacity() {
        return maxTankCapacity;
    }
}
