package supermarket;

import org.junit.Test;

import static java.util.Arrays.asList;
import static org.hamcrest.Matchers.is;
import static org.junit.Assert.*;

public class SKUTest {

    SKU A = new SKU('A', 50, null, -1, null);
    SKU B = new SKU('B', 50, asList(new Discount(2, 80)), -1, null);
    SKU C = new SKU('C', 50, asList(new Discount(5, 180), new Discount(2, 80)), -1, null);

    @Test
    public void givenOneItem_calculatePrice() {
        assertThat(A.calculatePriceOfBasket(1), is(50));
    }

    @Test
    public void givenItemWithOneDiscount_applyDiscount() {
        assertThat(B.calculatePriceOfBasket(2), is(80));
    }

    @Test
    public void givenItemWithTwoDiscounts_applyFirstDiscount() {
        assertThat(C.calculatePriceOfBasket(5), is(180));
    }

    @Test
    public void givenItemWithTwoDiscounts_applyFirstDiscountThenSecond() {
        assertThat(C.calculatePriceOfBasket(7), is(180+80));
    }
}
