import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        CartService cartService = new CartServiceImpl();

        System.out.println("Welcome to the Online Store!");

        boolean running = true;
        while (running) {
            System.out.println("\nSelect an action:");
            System.out.println("1. Add item to cart");
            System.out.println("2. Remove item from cart");
            System.out.println("3. Clear cart");
            System.out.println("4. Display cart");
            System.out.println("5. Exit");

            int choice = scanner.nextInt();
            scanner.nextLine(); // Consume newline

            switch (choice) {
                case 1:
                    System.out.println("Enter product details:");
                    System.out.print("Product ID: ");
                    int productId = scanner.nextInt();
                    scanner.nextLine(); // Consume newline
                    System.out.print("Product Name: ");
                    String productName = scanner.nextLine();
                    System.out.print("Price: ");
                    double price = scanner.nextDouble();
                    System.out.print("Quantity: ");
                    int quantity = scanner.nextInt();
                    cartService.addToCart(productId, productName, price, quantity);
                    System.out.println("Item added to cart.");
                    break;
                case 2:
                    if (cartService.getCartItems().isEmpty()) {
                        System.out.println("Cart is empty.");
                    } else {
                        System.out.print("Enter product ID to remove: ");
                        int removeId = scanner.nextInt();
                        cartService.removeFromCart(removeId);
                        System.out.println("Item removed from cart.");
                    }
                    break;
                case 3:
                    if (cartService.getCartItems().isEmpty()) {
                        System.out.println("Cart is already empty.");
                    } else {
                        cartService.clearCart();
                        System.out.println("Cart cleared.");
                    }
                    break;
                case 4:
                    if (cartService.getCartItems().isEmpty()) {
                        System.out.println("Cart is empty.");
                    } else {
                        displayCart(cartService);
                    }
                    break;
                case 5:
                    running = false;
                    break;
                default:
                    System.out.println("Invalid choice. Please enter a valid option.");
            }
        }

        scanner.close();
    }

    private static void displayCart(CartService cartService) {
        System.out.println("\nItems in the cart:");
        for (CartItem item : cartService.getCartItems()) {
            System.out.println("Product: " + item.getProductName() +
                    ", Price: $" + item.getPrice() +
                    ", Quantity: " + item.getQuantity());
        }
    }
}
