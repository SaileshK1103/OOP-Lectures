package task_3;

public class Triangle extends Shape{
    private double base;
    private double height;

    public Triangle(double base, double height, String color) {
        super(color);
        this.base = base;
        this.height = height;
    }

    @Override
    public double calculateArea() {
        return 0.5 * base * height;
    }

    @Override
    public String toString() {
        return "Triangle[base=" + base + ", height=" + height + ", color=" + color + "]";
    }
}
