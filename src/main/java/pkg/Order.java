package pkg;

public class Order {
    Cart cart;
    public void place(Cart cart) {
        this.cart = cart;
    }

    @Override
    public String toString() {
        return "Order{" +
                "cart=" + cart +
                '}';
    }
}
