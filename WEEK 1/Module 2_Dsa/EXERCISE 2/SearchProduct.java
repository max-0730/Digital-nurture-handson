class ProductSearch {

    int productId;
    String productName;
    String category;

    ProductSearch(int productId, String productName, String category) {
        this.productId = productId;
        this.productName = productName;
        this.category = category;
    }
}

public class SearchProduct {

    public static int linearSearch(ProductSearch[] products, String target) {

        for (int i = 0; i < products.length; i++) {

            if (products[i].productName.equalsIgnoreCase(target)) {
                return i;
            }
        }

        return -1;
    }

    public static int binarySearch(ProductSearch[] products, String target) {

        int low = 0;
        int high = products.length - 1;

        while (low <= high) {

            int mid = (low + high) / 2;

            int result = products[mid].productName.compareToIgnoreCase(target);

            if (result == 0) {
                return mid;
            }

            if (result < 0) {
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }

        return -1;
    }

    public static void main(String[] args) {

        ProductSearch[] products = {

                new ProductSearch(101, "Keyboard", "Electronics"),
                new ProductSearch(102, "Laptop", "Electronics"),
                new ProductSearch(103, "Mobile", "Electronics"),
                new ProductSearch(104, "Mouse", "Electronics"),
                new ProductSearch(105, "Speaker", "Electronics")
        };

        String searchItem = "Mobile";

        int linearResult = linearSearch(products, searchItem);

        if (linearResult != -1) {
            System.out.println("Linear Search: Product Found at Index " + linearResult);
        } else {
            System.out.println("Linear Search: Product Not Found");
        }

        int binaryResult = binarySearch(products, searchItem);

        if (binaryResult != -1) {
            System.out.println("Binary Search: Product Found at Index " + binaryResult);
        } else {
            System.out.println("Binary Search: Product Not Found");
        }
    }
}