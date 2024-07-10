import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

class GroceryItem {
    private int id;
    private String name;
    private int quantity;
    private double price;

    public GroceryItem(int id, String name, int quantity, double price) {
        this.id = id;
        this.name = name;
        this.quantity = quantity;
        this.price = price;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public int getQuantity() {
        return quantity;
    }

    public double getPrice() {
        return price;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    @Override
    public String toString() {
        return id + ". " + name + " (Quantity: " + quantity + ", Price: " + price + ")";
    }
}

class GroceryManager {
    private List<GroceryItem> items;
    private int nextId;

    public GroceryManager() {
        items = new ArrayList<>();
        nextId = 1;
    }

    public void addItem(String name, int quantity, double price) {
        GroceryItem item = new GroceryItem(nextId++, name, quantity, price);
        items.add(item);
        System.out.println("Item added: " + item);
    }

    public void viewItems() {
        if (items.isEmpty()) {
            System.out.println("No items available.");
        } else {
            for (GroceryItem item : items) {
                System.out.println(item);
            }
        }
    }

    public void removeItem(int id) {
        for (GroceryItem item : items) {
            if (item.getId() == id) {
                items.remove(item);
                System.out.println("Item removed: " + item);
                return;
            }
        }
        System.out.println("Item not found with id: " + id);
    }
}

public class GroceryManagerApp {
    public static void main(String[] args) {
        GroceryManager groceryManager = new GroceryManager();
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("\nGrocery Manager:");
            System.out.println("1. Add Item");
            System.out.println("2. View Items");
            System.out.println("3. Remove Item");
            System.out.println("4. Exit");
            System.out.print("Choose an option: ");
            int choice = scanner.nextInt();
            scanner.nextLine();  // Consume newline

            switch (choice) {
                case 1:
                    System.out.print("Enter item name: ");
                    String name = scanner.nextLine();
                    System.out.print("Enter quantity: ");
                    int quantity = scanner.nextInt();
                    System.out.print("Enter price: ");
                    double price = scanner.nextDouble();
                    groceryManager.addItem(name, quantity, price);
                    break;
                case 2:
                    groceryManager.viewItems();
                    break;
                case 3:
                    System.out.print("Enter item ID to remove: ");
                    int id = scanner.nextInt();
                    groceryManager.removeItem(id);
                    break;
                case 4:
                    System.out.println("Exiting...");
                    scanner.close();
                    return;
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        }
    }
}
