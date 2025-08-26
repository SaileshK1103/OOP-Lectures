package Task_4;

public class GroceryItem {
    private String name;
    private double cost;
    private String category;
    private int quantity; // New field for quantity

    public GroceryItem(String name, double cost, String category, int quantity) {
        this.name = name;
        this.cost = cost;
        this.category = category;
        this.quantity = quantity;
    }

    public double getCost() {
        return cost;
    }

    public String getCategory() {
        return category;
    }

    public int getQuantity() { // Getter for quantity
        return quantity;
    }

    public void setQuantity(int quantity) {
        if (quantity >= 0) { // Ensure quantity is not negative
            this.quantity = quantity;
        }
    }

    @Override
    public String toString() {
        return name + ": $" + String.format("%.2f", cost) + " (Category: " + category + ", Quantity: " + quantity + ")";
    }
}
