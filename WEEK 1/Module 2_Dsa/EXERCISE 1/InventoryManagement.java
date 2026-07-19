import java.util.HashMap;

class Product {

    int productId;
    String productName;
    int quantity;
    double price;

    Product(int productId, String productName,
            int quantity, double price) {

        this.productId = productId;
        this.productName = productName;
        this.quantity = quantity;
        this.price = price;
    }

    public String toString() {
        return "ID=" + productId +
                ", Name=" + productName +
                ", Quantity=" + quantity +
                ", Price=" + price;
    }
}

public class InventoryManagement {

    static HashMap<Integer, Product> inventory =
            new HashMap<>();

    public static void addProduct(Product p) {
        inventory.put(p.productId, p);
        System.out.println("Product Added");
    }

    public static void updateProduct(int id,
                                     int quantity,
                                     double price) {

        if (inventory.containsKey(id)) {

            Product p = inventory.get(id);

            p.quantity = quantity;
            p.price = price;

            System.out.println("Product Updated");
        }
    }

    public static void deleteProduct(int id) {

        inventory.remove(id);

        System.out.println("Product Deleted");
    }

    public static void displayProducts() {

        for(Product p : inventory.values()) {
            System.out.println(p);
        }
    }

    public static void main(String[] args) {

        addProduct(
                new Product(101,
                        "Laptop",
                        20,
                        55000));

        addProduct(
                new Product(102,
                        "Mouse",
                        50,
                        500));

        System.out.println("\nInventory:");

        displayProducts();

        updateProduct(101,
                30,
                53000);

        System.out.println("\nAfter Update:");

        displayProducts();

        deleteProduct(102);

        System.out.println("\nAfter Delete:");

        displayProducts();
    }
}