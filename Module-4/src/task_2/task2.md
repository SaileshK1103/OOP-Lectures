# Calculator with Github Copilot

    This project demnostrates how to build a simple calculator using Java and how GitHub Copilot can assist in writing both code and documentation.
    The calculator supports:
    - Resetting the value to zero
    - Adding positive integers (negative intergers are not allowed) and will throw an exception if attempted
    - Retrieving the current value

```java
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
```
## Explain how this calculator class works?
The Calculator class is a simple implementation of a calculator that can perform basic operations such as addition and resetting the value. Here's a breakdown of how it works:
1. **Instance Variable**: The class has a private instance variable `value` that holds the current value of the calculator.
2. **Constructor**: The constructor `Calculator()` initializes the `value` to 0 when a new instance of the class is created.
3. **Reset Method**: The `reset()` method sets the `value` back to 0, effectively resetting the calculator.
4. **Add Method**: The `add(int number)` method takes a positive integer as an argument and adds it to the current `value`. If a negative integer is passed, it throws an `IllegalArgumentException` to ensure only positive integers are allowed.
5. **Get Value Method**: The `getValue()` method returns the current value of the calculator.
6. **Main Method**: The `main` method demonstrates how to use the Calculator class. It creates an instance of the Calculator, adds some values, prints the current value, resets the calculator, and prints the value again after the reset.
7. **Error Handling**: The class includes basic error handling to prevent the addition of negative integers, ensuring that the calculator only works with positive values.
8. Overall, this class provides a simple and effective way to perform basic arithmetic operations while maintaining the integrity of the data by enforcing positive integer inputs.

## Refine the explanation in your own words to make it clear and human-readable?

    The calculator class is a small program that keeps track of a running total and allows very simple operations. 
    It is designed to demonstrate how GitHub Copilot can help generate methods and explanations.
    Here's how it works:
    1. Stored Value: The calculator has aprivate value that keeps track of the current total.
    2. Constructor: When a new calculator is created, the constructor sets the value to 0.
    3. Reset Method: The reset() method simply clears the current value and sets its back to 0.
    4. Add Method: The add(int number) method adds a positive number to the total. If a negative number is passed in, the program throws an error (IllegalArgumentException) to prevent invalid input.
    5. Get Value Method: The getValue() method returns the current total scored in the calculator.
    6. Main Method: The main method, the calculator is tested:
        - Add a couple of numbers.
        - Print the current total.
        - Reset the calculator.
        - Print the total again to show it has been cleared.
    7. Error Handling: The class includes basic error handling to ensure that only positive integers can be added, maintaining the integrity of the calculator's value.
    
    Overall, this class provides a simple way to perform basic arithmetic operations while ensuring that the input is valid and the data remains accurate.

## Evaluation of Github Copilot

    How I used Github Copilot:
    - I wrote a method signature and let copilot to generate the method body.
    - I provided comments in English and let Copilot completed it with valid suggestions.
    - I partially wrote code, and Copilot completed it with valid suggestions.
    - I asked Copilot to generate documentation for the class and methods
    - I asked Copilot to explain how the class works.

    Benefits:
    - It saved time by generating code snippets and documentation quickly.
    - It provided useful suggestions that I might not have thought of.
    - It helped me understand the code better by providing explanations.
    - It improved my productivity by reducing the amount of boilerplate code I had to write.
    - It assisted in maintaining a consistent coding style.
    Limitations:
    - Sometimes the suggestions were not accurate or relevant to the context.
    - It may not always follow best practices or coding standards.
    - It can make me rely too much on suggestions instead of thinking through the logic myself.
    - The explanations Copilot generated for documentation were too formal and repetitive, so I had to write them in my own words to make them more readable.
    - It may not understand the full context of the project, leading to less useful suggestions.
    - It may require additional review and testing to ensure the generated code is correct and secure.
    Overall, Github Copilot is a powerful tool that can enhance the coding experience, but it should be used with caution and not relied upon entirely. It is important to review and test the generated code to ensure its quality and correctness.

## Conclusion
    In conclusion, the Calculator class is a simple yet effective implementation of a basic calculator that demonstrates how GitHub Copilot can assist in code generation and documentation. The class provides essential functionalities such as resetting the value, adding positive integers, and retrieving the current value, all while ensuring input validation through error handling. GitHub Copilot proved to be a valuable tool in this project, offering time-saving suggestions and enhancing productivity. However, it is crucial to review and test the generated code to ensure its accuracy and adherence to best practices. Overall, this project highlights the potential of AI-assisted coding tools in streamlining development processes while emphasizing the importance of human oversight.
