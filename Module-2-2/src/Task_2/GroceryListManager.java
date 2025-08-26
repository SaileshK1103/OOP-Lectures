package Task_2;

import java.util.HashMap;

public class GroceryListManager {
    // HashMap to store item names and costs.
    private HashMap<String, Double> groceryList = new HashMap<>();

    // Add grocery items name and cost
    public void addItem(String item, double cost) {
        groceryList.put(item, cost);
        System.out.println("Added/Updated: " + item + " with cost $" + String.format("%.2f", cost));
    }
    // Calculate the total cost of all items in the groccery list
    public double calculateTotalCost() {
        double totalCost = 0.0;
        // Iterate through the values (costs) of the HashMap
        for (double cost : groceryList.values()) {
            totalCost += cost;
        }
        return totalCost;
    }
    // Remove item from grocery list
    public void removeItem(String item) {
        if (groceryList.remove(item) != null) {
            System.out.println("Removed: " + item);
        } else {
            System.out.println(item + " was not found in the list.");
        }
    }
    // Display all items
    public void displayList() {
        if (groceryList.isEmpty()) {
            System.out.println("The grocery list is empty.");
        } else {
            System.out.println("\nGrocery List:");
            // Iterate through the keys (item names) of the HashMap
            for (String item : groceryList.keySet()) {
                System.out.println("- " + item + ": $" + String.format("%.2f", groceryList.get(item)));
            }
        }
    }
    // Check if specific item is present in the grocery list
    public boolean checkItem(String item) {
        return groceryList.containsKey(item);
    }

    public static void main(String[] args) {
        GroceryListManager manager = new GroceryListManager();

        // Add items with costs
        manager.addItem("Apples", 2.50);
        manager.addItem("Milk", 3.00);
        manager.addItem("Bread", 1.75);

        // Display the list
        manager.displayList();

        // Calculate and display the total cost
        System.out.println("\nTotal cost of the grocery list: $" + String.format("%.2f", manager.calculateTotalCost()));

        // Remove an item and display the updated list and cost
        manager.removeItem("Milk");
        manager.displayList();
        System.out.println("Updated total cost: $" + String.format("%.2f", manager.calculateTotalCost()));
    }
}
