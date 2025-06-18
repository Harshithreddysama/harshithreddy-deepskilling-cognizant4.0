import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class InventorySystem {

    // Product class with required attributes
    static class Product {
        int productId;
        String productName;
        int quantity;
        double price;

        Product(int productId, String productName, int quantity, double price) {
            this.productId = productId;
            this.productName = productName;
            this.quantity = quantity;
            this.price = price;
        }

        @Override
        public String toString() {
            return "ProductID: " + productId + ", Name: " + productName +
                    ", Quantity: " + quantity + ", Price: $" + price;
        }
    }

    // Inventory Manager using HashMap for O(1) access
    static class InventoryManager {
        private Map<Integer, Product> inventory;

        public InventoryManager() {
            inventory = new HashMap<>();
        }

        // Add product - O(1)
        public void addProduct(Product product) {
            if (inventory.containsKey(product.productId)) {
                System.out.println("Product ID already exists. Use update instead.");
            } else {
                inventory.put(product.productId, product);
                System.out.println("Product added successfully.");
            }
        }

        // Update product - O(1)
        public void updateProduct(Product product) {
            if (inventory.containsKey(product.productId)) {
                inventory.put(product.productId, product);
                System.out.println("Product updated successfully.");
            } else {
                System.out.println("Product not found. Use add to create it.");
            }
        }

        // Delete product - O(1)
        public void deleteProduct(int productId) {
            if (inventory.remove(productId) != null) {
                System.out.println("Product deleted successfully.");
            } else {
                System.out.println("Product not found.");
            }
        }

        // Display all products - O(n)
        public void displayInventory() {
            if (inventory.isEmpty()) {
                System.out.println("Inventory is empty.");
            } else {
                for (Product product : inventory.values()) {
                    System.out.println(product);
                }
            }
        }
    }

    // Main method to test the system
    public static void main(String[] args) {
        InventoryManager manager = new InventoryManager();
        Scanner scanner = new Scanner(System.in);
        int choice;

        do {
            System.out.println("\nInventory Management System");
            System.out.println("1. Add Product");
            System.out.println("2. Update Product");
            System.out.println("3. Delete Product");
            System.out.println("4. Display Inventory");
            System.out.println("5. Exit");
            System.out.print("Enter your choice: ");
            choice = scanner.nextInt();

            switch (choice) {
                case 1 -> {
                    System.out.print("Enter Product ID: ");
                    int id = scanner.nextInt();
                    scanner.nextLine(); // consume newline
                    System.out.print("Enter Product Name: ");
                    String name = scanner.nextLine();
                    System.out.print("Enter Quantity: ");
                    int qty = scanner.nextInt();
                    System.out.print("Enter Price: ");
                    double price = scanner.nextDouble();
                    manager.addProduct(new Product(id, name, qty, price));
                }
                case 2 -> {
                    System.out.print("Enter Product ID to update: ");
                    int id = scanner.nextInt();
                    scanner.nextLine(); // consume newline
                    System.out.print("Enter New Product Name: ");
                    String name = scanner.nextLine();
                    System.out.print("Enter New Quantity: ");
                    int qty = scanner.nextInt();
                    System.out.print("Enter New Price: ");
                    double price = scanner.nextDouble();
                    manager.updateProduct(new Product(id, name, qty, price));
                }
                case 3 -> {
                    System.out.print("Enter Product ID to delete: ");
                    int id = scanner.nextInt();
                    manager.deleteProduct(id);
                }
                case 4 -> manager.displayInventory();
                case 5 -> System.out.println("Exiting...");
                default -> System.out.println("Invalid choice. Try again.");
            }
        } while (choice != 5);

        scanner.close();
    }
}
