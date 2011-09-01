package pkg;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class CheckoutController {

    private final Cart cart;
    private final Order order;

    @Autowired
    public CheckoutController(Cart cart, Order order) {
        this.cart = cart;
        this.order = order;
    }

    @RequestMapping("/go/to/checkout/")
    public String goCheckout(ModelMap model) {
        // other stuff
        cart.addTo(findUpsell(cart));
        model.addAttribute("cart", cart);
        return "checkout";
    }

    @RequestMapping("/place/order")
    public String placeOrder(ModelMap model) {
        order.place(cart);
        model.addAttribute("order", order);
        return "orderPlaced";
    }

    @RequestMapping("/see/suggested/products")
    public String seeSuggestedProducts(ModelMap model) {
        cart.addTo(findUpsell(cart));
        cart.addTo(findUpsell(cart));
        model.addAttribute("cart", cart);
        return "suggestedProducts";
    }

    String findUpsell(Cart cart) {
        if (cart.size() == 0) {
            return "iPad";
        } else {
            return "iPod Nano";
        }
    }


}
