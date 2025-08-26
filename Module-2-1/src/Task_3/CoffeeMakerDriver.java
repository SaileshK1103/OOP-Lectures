package Task_3;

public class CoffeeMakerDriver {
    public static void main(String[] args) {
        CoffeeMaker myCoffee = new CoffeeMaker();

        myCoffee.pressOnOff();
        if (myCoffee.isOn())
            System.out.println("Coffee maker is on");

        myCoffee.setCoffeeType("espresso");
        myCoffee.setCoffeeAmount(50);

        System.out.println("Coffee type is " + myCoffee.getCoffeeType());
        System.out.println("Coffee amount is " + myCoffee.getCoffeeAmount() + " ml");

        myCoffee.pressOnOff();
        if (!myCoffee.isOn())
            System.out.println("Coffee maker is off");
    }
}
