package supermarket;

import org.junit.Test;
import org.mockito.internal.invocation.SerializableMethod;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.*;

public class SupermarketAppTest {

    @Test
    public void givenEmptyString_shouldReturnZero() {
        assertThat(SupermarketApp.checkout(""), is(0));
    }

    @Test
    public void givenSingleItem_shouldChargeSinglePrice() {
        assertThat(SupermarketApp.checkout("A"), is(50));
    }

    @Test
    public void givenMultipleLessThanDiscount_shouldMultiplySinglePrice() {
        assertThat(SupermarketApp.checkout("AA"), is(100));
    }

    @Test
    public void givenBasketWithMultiplesLessThanDiscount_shouldMultiplySinglePrice() {
        assertThat(SupermarketApp.checkout("AABCCC"), is(190));
    }

//    @Test
//    public void givenLowerCaseId_stillCalculatesValueOfItem() {
//        assertThat(SupermarketApp.checkout("aA"), is(100));
//    }

//            | A    | 50    | 3A for 130     |
//            | B    | 30    | 2B for 45      |
//            | C    | 20    |                |
//            | D    | 15    |                |

    @Test
    public void givenInvalidInput_shouldReturnMinus1() {
        assertThat(SupermarketApp.checkout("AAAABCDE"), is (-1));
    }

    @Test
    public void givenOneMultipleOfDiscountAmount_shouldReturnDiscountAmount() {
        assertThat(SupermarketApp.checkout("AAA"), is(130));
    }

    @Test
    public void givenComplexBasketWithDiscounts_shouldReturnRightAmount() {
        assertThat(SupermarketApp.checkout("AAAAABBBBCCCDD"), is(410));
    }
}
