package Task_5;

import Task_4.GroceryItem;

import java.util.HashMap;

public class GroceryListManager {
    private HashMap<String, GroceryItem> groceryList = new HashMap<>();

    public void addItem(String item, double cost, String category, int quantity) {
        if (groceryList.containsKey(item)) {
            System.out.println("Item already exists: " + item);
            return;
        }
        GroceryItem newItem = new GroceryItem(item, cost, category, quantity);
        groceryList.put(item, newItem);
        System.out.println("Added: " + item + " (Quantity: " + quantity + ")");
    }

    public void updateQuantity(String item, int newQuantity) {
        GroceryItem existingItem = groceryList.get(item);
        if (existingItem != null) {
            existingItem.setQuantity(newQuantity);
            System.out.println("Updated quantity for " + item + " to " + newQuantity + ".");
        } else {
            System.out.println(item + " was not found in the list.");
        }
    }

    public double calculateTotalCost() {
        double totalCost = 0.0;
        for (GroceryItem item : groceryList.values()) {
            totalCost += item.getCost() * item.getQuantity();
        }
        return totalCost;
    }

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

    public void displayAvailableItems() {
        System.out.println("\n--- Available Items (Quantity > 0) ---");
        boolean foundAvailable = false;
        for (GroceryItem item : groceryList.values()) {
            if (item.getQuantity() > 0) {
                System.out.println(item);
                foundAvailable = true;
            }
        }
        if (!foundAvailable) {
            System.out.println("No items are currently available.");
        }
    }

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

        // Testing Total Cost Calculation
        System.out.println("--- Testing Total Cost Calculation ---");
        manager.addItem("Apples", 2.50, "Fruits", 10);
        manager.addItem("Milk", 3.00, "Dairy", 2);
        manager.addItem("Bread", 1.75, "Bakery", 1);
        System.out.println("Current total cost: $" + String.format("%.2f", manager.calculateTotalCost()));
        System.out.println("-------------------------------------\n");

        // Testing Item Categories
        System.out.println("--- Testing Item Categories ---");
        manager.addItem("Yogurt", 4.25, "Dairy", 3);
        manager.addItem("Bananas", 1.50, "Fruits", 5);
        manager.addItem("Donuts", 5.00, "Bakery", 6);
        manager.displayByCategory("Fruits");
        manager.displayByCategory("Dairy");
        manager.displayByCategory("Bakery");
        manager.displayByCategory("Snacks");
        System.out.println("------------------------------\n");

        // Testing Quantity Tracking
        System.out.println("--- Testing Quantity Tracking ---");
        manager.addItem("Coffee", 8.99, "Beverages", 0);
        manager.addItem("Tea", 6.50, "Beverages", 4);

        manager.displayAvailableItems();

        manager.updateQuantity("Coffee", 2);
        manager.updateQuantity("Tea", 0);

        System.out.println("\nAfter updating quantities:");
        manager.displayAvailableItems();
        System.out.println("----------------------------------\n");
    }
}
