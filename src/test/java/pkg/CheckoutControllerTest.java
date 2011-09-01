package pkg;

import org.junit.Before;
import org.junit.Test;
import org.springframework.ui.ModelMap;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.IsEqual.equalTo;

public class CheckoutControllerTest {

    private CheckoutController bfc;
    private Cart cart = new Cart(); // could as easily be a mock
    private Order order = new Order(); // could as easily be a mock
    private ModelMap model = new ModelMap();

    @Before
    public void setup() {
        bfc =new CheckoutController(cart, order);
    }

    @Test
    public void checkout_should_add_an_upsell() {
        String result = bfc.goCheckout(model);
        assertThat(result, equalTo("checkout"));
        assertThat(model.toString(), equalTo("{cart=Cart{contents=[[iPad]]}}"));
    }

    @Test
    public void place_order_in_checkout_should_make_an_order() {
        cart.addTo("dummy");
        String result = bfc.placeOrder(model);
        assertThat(result, equalTo("orderPlaced"));
        assertThat(model.toString(), equalTo("{order=Order{cart=Cart{contents=[[dummy]]}}}"));
    }

    @Test
    public void show_suggested_products_should_add_two_upsells() {
        String result = bfc.seeSuggestedProducts(model);
        assertThat(result, equalTo("suggestedProducts"));
        assertThat(model.toString(), equalTo("{cart=Cart{contents=[[iPad, iPod Nano]]}}"));
    }

}
