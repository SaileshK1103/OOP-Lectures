package Task_3;

public class GroceryItem {
    private String name;
    private double cost;
    private String category;

    public GroceryItem(String name, double cost, String category) {
        this.name = name;
        this.cost = cost;
        this.category = category;
    }

    // Getters for name, cost, and category
    public String getName() {
        return name;
    }

    public double getCost() {
        return cost;
    }

    public String getCategory() {
        return category;
    }

    @Override
    public String toString() {
        return name + ": $" + String.format("%.2f", cost) + " (Category: " + category + ")";
    }
}
