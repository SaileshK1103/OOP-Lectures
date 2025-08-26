package Task_3;

public class CoffeeMaker {
    private boolean on;
    private String coffeeType;
    private int coffeeAmount;

    // Constructor
    public CoffeeMaker() {
        on = false;
        coffeeType = "normal";
        coffeeAmount = 10;
    }

    // coffee power switch
    public void pressOnOff() {
        on = !on;
    }

    // Getter for on/off state
    public boolean isOn() {
        return on;
    }

    // Set coffee type only if ON
    public void setCoffeeType(String type) {
        if (on) {
            if (type.equalsIgnoreCase("normal") || type.equalsIgnoreCase("espresso")) {
                coffeeType = type.toLowerCase();
            }
        }
    }

    // Get coffee type
    public String getCoffeeType() {
        return coffeeType;
    }

    // Set coffee amount only if ON, and within limits
    public void setCoffeeAmount(int amount) {
        if (on && amount >= 10 && amount <= 80) {
            coffeeAmount = amount;
        }
    }

    // Get coffee amount
    public int getCoffeeAmount() {
        return coffeeAmount;
    }
}
