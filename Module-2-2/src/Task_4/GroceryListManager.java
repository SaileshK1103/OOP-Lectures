package Task_4;

import java.util.HashMap;

public class GroceryListManager {
    private HashMap<String, GroceryItem> groceryList = new HashMap<>();

    // AddItem
    public void addItem(String item, double cost, String category, int quantity) {
        if (groceryList.containsKey(item)) {
            System.out.println(item + " already exists. Use updateQuantity to change the quantity.");
            return;
        }
        GroceryItem newItem = new GroceryItem(item, cost, category, quantity);
        groceryList.put(item, newItem);
        System.out.println("Added: " + item + " (Quantity: " + quantity + ")");
    }

    // Updates the quantity of a specified item.
    public void updateQuantity(String item, int newQuantity) {
        GroceryItem existingItem = groceryList.get(item);
        if (existingItem != null) {
            existingItem.setQuantity(newQuantity);
            System.out.println("Updated quantity for " + item + " to " + newQuantity + ".");
        } else {
            System.out.println(item + " was not found in the list.");
        }
    }

    // Displays items with a positive quantity.
    public void displayAvailableItems() {
        System.out.println("\nAvailable items quantity greater than zero");
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

    // Updated calculateTotalCost to consider quantity
    public double calculateTotalCost() {
        double totalCost = 0.0;
        for (GroceryItem item : groceryList.values()) {
            totalCost += item.getCost() * item.getQuantity();
        }
        return totalCost;
    }

    // Other methods from previous tasks
    public void removeItem(String item) {
        if (groceryList.remove(item) != null) {
            System.out.println("Removed: " + item);
        } else {
            System.out.println(item + " was not found in the list.");
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

        // Add items with quantity
        manager.addItem("Apples", 2.50, "Fruits", 10);
        manager.addItem("Milk", 3.00, "Dairy", 2);
        manager.addItem("Bread", 1.75, "Bakery", 1);
        manager.addItem("Yogurt", 4.25, "Dairy", 0); // Out of stock item

        // Display full list and total cost
        manager.displayList();
        System.out.println("\nTotal cost: $" + String.format("%.2f", manager.calculateTotalCost()));

        // Display only available items
        manager.displayAvailableItems();

        // Update the quantity of an item
        manager.updateQuantity("Apples", 5);

        // Display updated list and cost
        manager.displayList();
        System.out.println("\nUpdated total cost: $" + String.format("%.2f", manager.calculateTotalCost()));
    }
}
