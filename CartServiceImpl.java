import java.util.ArrayList;
import java.util.List;

public class CartServiceImpl implements CartService {
    private Cart cart;

    public CartServiceImpl() {
        this.cart = new Cart();
    }

    @Override
    public void addToCart(int productId, String productName, double price, int quantity) {
        CartItem item = new CartItem(productId, productName, price, quantity);
        cart.addItem(item);
    }

    @Override
    public void removeFromCart(int productId) {
        cart.removeItem(productId);
    }

    @Override
    public void clearCart() {
        cart.clearCart();
    }

    @Override
    public List<CartItem> getCartItems() {
        return new ArrayList<>(cart.getItems());
    }
}
