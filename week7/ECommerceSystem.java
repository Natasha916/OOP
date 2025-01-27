package week7;
import java.util.ArrayList;
import java.util.List;

public class ECommerceSystem {
    static class Product {
        private int productId;
        private String name;
        private double price;
        private int stockQuantity;

        public Product(int productId, String name, double price, int stockQuantity) {
            this.productId = productId;
            this.name = name;
            this.price = price;
            this.stockQuantity = stockQuantity;
        }

        public String getName() {
            return name;
        }

        public double getPrice() {
            return price;
        }

        public boolean checkAvailability(int quantity) {
            return stockQuantity >= quantity;
        }

        public void reduceStock(int quantity) {
            if (checkAvailability(quantity)) {
                stockQuantity -= quantity;
            } else {
                System.out.println("Insufficient stock for " + name);
            }
        }

        public void getDetails() {
            System.out.println("Product ID: " + productId + ", Name: " + name + ", Price: $" + price +
                    ", Stock: " + stockQuantity);
        }
    }
    static class CartItem {
        private Product product;
        private int quantity;

        public CartItem(Product product, int quantity) {
            this.product = product;
            this.quantity = quantity;
        }

        public Product getProduct() {
            return product;
        }

        public int getQuantity() {
            return quantity;
        }
    }
    static class ShoppingCart {
        private List<CartItem> cartItems;

        public ShoppingCart() {
            this.cartItems = new ArrayList<>();
        }

        public void addProduct(Product product, int quantity) {
            if (product.checkAvailability(quantity)) {
                cartItems.add(new CartItem(product, quantity));
                product.reduceStock(quantity);
                System.out.println(quantity + " unit(s) of " + product.getName() + " added to the cart.");
            } else {
                System.out.println("Unable to add " + product.getName() + " to the cart due to insufficient stock.");
            }
        }

        public void viewCartItems() {
            if (cartItems.isEmpty()) {
                System.out.println("Cart is empty.");
                return;
            }

            for (CartItem item : cartItems) {
                System.out.println(item.getQuantity() + " unit(s) of " + item.getProduct().getName());
            }
        }

        public double calculateTotalPrice() {
            double totalPrice = 0.0;
            for (CartItem item : cartItems) {
                totalPrice += item.getProduct().getPrice() * item.getQuantity();
            }
            return totalPrice;
        }
    }
    static class Customer {
        private int customerId;
        private String name;

        public Customer(int customerId, String name) {
            this.customerId = customerId;
            this.name = name;
        }

        public void viewProducts(List<Product> products) {
            System.out.println("\nAvailable Products:");
            for (Product product : products) {
                product.getDetails();
            }
        }

        public void checkout(ShoppingCart cart) {
            System.out.println("\n" + name + " is checking out with the following items:");
            cart.viewCartItems();
            System.out.println("Total Price: $" + cart.calculateTotalPrice());
        }
    }
    public static void main(String[] args) {
        Product product1 = new Product(101, "Laptop", 1000.0, 5);
        Product product2 = new Product(102, "Phone", 500.0, 10);
        Product product3 = new Product(103, "Headphones", 100.0, 20);

        List<Product> products = new ArrayList<>();
        products.add(product1);
        products.add(product2);
        products.add(product3);
        Customer customer = new Customer(1, "Alice");
        customer.viewProducts(products);
        ShoppingCart cart = new ShoppingCart();
        cart.addProduct(product1, 1); // Add 1 Laptop
        cart.addProduct(product2, 2); // Add 2 Phones
        cart.addProduct(product3, 3); // Add 3 Headphones
        System.out.println("\nCart Items:");
        cart.viewCartItems();
        customer.checkout(cart);
    }
}
