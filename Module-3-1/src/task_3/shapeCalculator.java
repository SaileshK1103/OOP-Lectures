package task_3;

public class shapeCalculator {
    public static void main(String[] args) {
        System.out.println("Shape Calculator\n");

        Shape[] shapes = {
                new Circle(5.0, "Red"),
                new Rectangle(4.0, 6.0, "Blue"),
                new Triangle(3.0, 8.0, "Green")
        };

        for (Shape shape : shapes) {
            System.out.println(shape.toString() + " → Area: " + shape.calculateArea());
        }
    }
}
