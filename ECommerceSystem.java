import java.util.*;

// Product Class
class Product {
    int id;
    String name;
    String category;
    float price;
    float rating;

    public Product(int id, String name, String category, float price, float rating) {
        this.id = id;
        this.name = name;
        this.category = category;
        this.price = price;
        this.rating = rating;
    }

    @Override
    public String toString() {
        return "ID: " + id + ", Name: " + name + ", Category: " + category + ", Price: " + price + ", Rating: " + rating;
    }
}

// E-Commerce System
public class ECommerceSystem {

    // Product List
    private List<Product> products = new ArrayList<>();

    // Add Product
    public void addProduct(Product product) {
        products.add(product);
        System.out.println("Product added successfully!");
    }

    // Update Product
    public void updateProduct(int id, String name, String category, float price, float rating) {
        for (Product product : products) {
            if (product.id == id) {
                product.name = name;
                product.category = category;
                product.price = price;
                product.rating = rating;
                System.out.println("Product updated successfully!");
                return;
            }
        }
        System.out.println("Product not found!");
    }

    // Delete Product
    public void deleteProduct(int id) {
        products.removeIf(product -> product.id == id);
        System.out.println("Product deleted successfully!");
    }

    // Sorting Algorithms
    public void insertionSort(String attribute) {
        for (int i = 1; i < products.size(); i++) {
            Product key = products.get(i);
            int j = i - 1;
            while (j >= 0 && compare(products.get(j), key, attribute) > 0) {
                products.set(j + 1, products.get(j));
                j--;
            }
            products.set(j + 1, key);
        }
    }

    public void quickSort(int low, int high, String attribute) {
        if (low < high) {
            int pi = partition(low, high, attribute);
            quickSort(low, pi - 1, attribute);
            quickSort(pi + 1, high, attribute);
        }
    }

    private int partition(int low, int high, String attribute) {
        Product pivot = products.get(high);
        int i = low - 1;
        for (int j = low; j < high; j++) {
            if (compare(products.get(j), pivot, attribute) <= 0) {
                i++;
                Collections.swap(products, i, j);
            }
        }
        Collections.swap(products, i + 1, high);
        return i + 1;
    }

    public void mergeSort(int left, int right, String attribute) {
        if (left < right) {
            int mid = (left + right) / 2;
            mergeSort(left, mid, attribute);
            mergeSort(mid + 1, right, attribute);
            merge(left, mid, right, attribute);
        }
    }

    private void merge(int left, int mid, int right, String attribute) {
        int n1 = mid - left + 1;
        int n2 = right - mid;

        List<Product> leftArr = new ArrayList<>();
        List<Product> rightArr = new ArrayList<>();

        for (int i = 0; i < n1; i++) leftArr.add(products.get(left + i));
        for (int i = 0; i < n2; i++) rightArr.add(products.get(mid + 1 + i));

        int i = 0, j = 0, k = left;
        while (i < n1 && j < n2) {
            if (compare(leftArr.get(i), rightArr.get(j), attribute) <= 0) {
                products.set(k, leftArr.get(i));
                i++;
            } else {
                products.set(k, rightArr.get(j));
                j++;
            }
            k++;
        }

        while (i < n1) products.set(k++, leftArr.get(i++));
        while (j < n2) products.set(k++, rightArr.get(j++));
    }

    private int compare(Product p1, Product p2, String attribute) {
        switch (attribute) {
            case "price":
                return Float.compare(p1.price, p2.price);
            case "rating":
                return Float.compare(p1.rating, p2.rating);
            case "name":
                return p1.name.compareTo(p2.name);
            default:
                throw new IllegalArgumentException("Invalid attribute for comparison.");
        }
    }

    // Searching Algorithms
    public Product sequentialSearch(String name) {
        for (Product product : products) {
            if (product.name.equalsIgnoreCase(name)) {
                return product;
            }
        }
        return null;
    }

    public Product binarySearch(int id) {
        insertionSort("id");
        int low = 0, high = products.size() - 1;
        while (low <= high) {
            int mid = low + (high - low) / 2;
            if (products.get(mid).id == id) {
                return products.get(mid);
            } else if (products.get(mid).id < id) {
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }
        return null;
    }

    // Display Products
    public void displayProducts() {
        for (Product product : products) {
            System.out.println(product);
        }
    }

    // Main Method
    public static void main(String[] args) {
        ECommerceSystem system = new ECommerceSystem();
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("\nE-Commerce System Menu:");
            System.out.println("1. Add Product");
            System.out.println("2. Update Product");
            System.out.println("3. Delete Product");
            System.out.println("4. Display Products");
            System.out.println("5. Sort Products");
            System.out.println("6. Search Product by Name");
            System.out.println("7. Search Product by ID");
            System.out.println("8. Exit");
            System.out.print("Choose an option: ");
            int choice = scanner.nextInt();

            switch (choice) {
                case 1 -> {
                    System.out.print("Enter ID, Name, Category, Price, Rating: ");
                    int id = scanner.nextInt();
                    String name = scanner.next();
                    String category = scanner.next();
                    float price = scanner.nextFloat();
                    float rating = scanner.nextFloat();
                    system.addProduct(new Product(id, name, category, price, rating));
                }
                case 2 -> {
                    System.out.print("Enter ID, Name, Category, Price, Rating: ");
                    int id = scanner.nextInt();
                    String name = scanner.next();
                    String category = scanner.next();
                    float price = scanner.nextFloat();
                    float rating = scanner.nextFloat();
                    system.updateProduct(id, name, category, price, rating);
                }
                case 3 -> {
                    System.out.print("Enter ID to delete: ");
                    int id = scanner.nextInt();
                    system.deleteProduct(id);
                }
                case 4 -> system.displayProducts();
                case 5 -> {
                    System.out.print("Enter attribute to sort by (price, rating, name): ");
                    String attribute = scanner.next();
                    system.mergeSort(0, system.products.size() - 1, attribute);
                    System.out.println("Products sorted successfully!");
                }
                case 6 -> {
                    System.out.print("Enter product name to search: ");
                    String name = scanner.next();
                    Product result = system.sequentialSearch(name);
                    System.out.println(result != null ? result : "Product not found!");
                }
                case 7 -> {
                    System.out.print("Enter product ID to search: ");
                    int id = scanner.nextInt();
                    Product result = system.binarySearch(id);
                    System.out.println(result != null ? result : "Product not found!");
                }
                case 8 -> {
                    System.out.println("Exiting the system...");
                    scanner.close();
                    return;
                }
                default -> System.out.println("Invalid option. Try again.");
            }
        }
    }
}
