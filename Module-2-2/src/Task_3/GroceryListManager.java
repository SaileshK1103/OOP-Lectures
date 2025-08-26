package Task_3;

import java.util.HashMap;

public class GroceryListManager {
    // Change data structure to store GroceryItem objects
    private HashMap<String, GroceryItem> groceryList = new HashMap<>();

    // New addItem method with a category parameter
    public void addItem(String item, double cost, String category) {
        GroceryItem newItem = new GroceryItem(item, cost, category);
        groceryList.put(item, newItem);
        System.out.println("Added: " + item + " to " + category + " category.");
    }

    // New displayByCategory method
    public void displayByCategory(String category) {
        System.out.println("\n--- " + category + " ---");
        boolean foundItems = false;
        for (GroceryItem item : groceryList.values()) {
            if (item.getCategory().equalsIgnoreCase(category)) {
                System.out.println(item);
                foundItems = true;
            }
        }
        if (!foundItems) {
            System.out.println("No items found in this category.");
        }
    }
    // CalculateTotalCost method
    public double calculateTotalCost() {
        double totalCost = 0.0;
        for (GroceryItem item : groceryList.values()) {
            totalCost += item.getCost();
        }
        return totalCost;
    }

    // RemoveItem method
    public void removeItem(String item) {
        if (groceryList.remove(item) != null) {
            System.out.println("Removed: " + item);
        } else {
            System.out.println(item + " was not found in the list.");
        }
    }

    // DisplayList method
    public void displayList() {
        if (groceryList.isEmpty()) {
            System.out.println("The grocery list is empty.");
        } else {
            System.out.println("\n--- Full Grocery List ---");
            for (GroceryItem item : groceryList.values()) {
                System.out.println(item);
            }
        }
    }

    public static void main(String[] args) {
        GroceryListManager manager = new GroceryListManager();

        // Add items with category
        manager.addItem("Apples", 2.50, "Fruits");
        manager.addItem("Milk", 3.00, "Dairy");
        manager.addItem("Bread", 1.75, "Bakery");
        manager.addItem("Yogurt", 4.25, "Dairy");
        manager.addItem("Bananas", 1.50, "Fruits");

        // Display items by category
        manager.displayByCategory("Fruits");
        manager.displayByCategory("Dairy");
        manager.displayByCategory("Bakery");
        manager.displayByCategory("Snacks"); // Example of a category with no items

        // Display full list and total cost
        manager.displayList();
        System.out.println("\nTotal cost: $" + String.format("%.2f", manager.calculateTotalCost()));
    }
}
