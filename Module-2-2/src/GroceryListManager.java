import java.util.ArrayList;

public class GroceryListManager {
    private ArrayList<String> groceryList = new ArrayList<>();

    // Adds a new item to the grocery list.
    public void addItem(String item) {
        if (!groceryList.contains(item)) {
            groceryList.add(item);
            System.out.println("Added: " + item);
        } else {
            System.out.println(item + " is already in the list.");
        }
    }

    // Removes an item from the grocery list.
    public void removeItem(String item) {
        if (groceryList.remove(item)) {
            System.out.println("Removed: " + item);
        } else {
            System.out.println(item + " was not found in the list.");
        }
    }

    // Displays all items in the grocery list.
    public void displayList() {
        if (groceryList.isEmpty()) {
            System.out.println("The grocery list is empty.");
        } else {
            System.out.println("\nGrocery List:");
            for (int i = 0; i < groceryList.size(); i++) {
                System.out.println((i + 1) + ". " + groceryList.get(i));
            }
        }
    }

    // Checks if an item is present in the grocery list.
    public boolean checkItem(String item) {
        return groceryList.contains(item);
    }

    public static void main(String[] args) {
        GroceryListManager manager = new GroceryListManager();

        // Adding grocery items
        manager.addItem("Apple");
        manager.addItem("Milk");
        manager.addItem("Bread");
        manager.addItem("Apples"); // Trying to add a duplicate item

        // display grocery list
        manager.displayList();

        // check if a specific item is present
        String itemToCheck = "Milk";
        System.out.println("\nIs \"" + itemToCheck + "\" in the grocery list? " + manager.checkItem(itemToCheck));

        // item removed
        String itemToRemove = "Milk";
        System.out.println("\nRemoving \"" + itemToRemove + "\" from the list...");
        manager.removeItem(itemToRemove);

        String nonExistentItem = "Eggs";
        System.out.println("\nRemoving \"" + nonExistentItem + "\" from the list...");
        manager.removeItem(nonExistentItem);

        // updated grocery list
        manager.displayList();
    }
}
