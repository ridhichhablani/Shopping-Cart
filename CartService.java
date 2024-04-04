import java.util.List;

public interface CartService {
    void addToCart(int productId, String productName, double price, int quantity);
    void removeFromCart(int productId);
    void clearCart();
    List<CartItem> getCartItems();
}
