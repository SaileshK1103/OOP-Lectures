package task_3;

public class Shape {
    protected String color;

    public Shape(String color) {
        this.color = color;
    }

    public double calculateArea() {
        return 0.0;
    }

    @Override
    public String toString() {
        return "Shape[color=" + color + "]";
    }
}
