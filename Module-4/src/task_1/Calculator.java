package task_1;

public class Calculator {
    private int value;

    // Co-pilot generated constructor
    public Calculator() {
        this.value = 0;
    }

    // Resets calculator to zero
    // Co-pilot generated method
    public void reset() {
        this.value = 0;
    }

    // Adds a positive integer, throws exception if negative
    // Co-pilot generated method
    public void add(int number) {
        if (number < 0) {
            throw new IllegalArgumentException("Only positive integers are allowed");
        }
        this.value += number;
    }

    // Returns current value
    // Co-pilot generated method
    public int getValue() {
        return this.value;
    }

    // Main method for demonstration
    public static  void main(String[] args) {
        Calculator calculator = new Calculator();
        calculator.add(5);
        calculator.add(10);
        System.out.println("Current Value: " + calculator.getValue());
        calculator.reset();
        System.out.println("Value after reset: " + calculator.getValue());

    }
}
