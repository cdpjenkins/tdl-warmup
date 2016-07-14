package supermarket;

import com.google.common.collect.HashMultiset;
import com.google.common.collect.Multiset;
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

//            +------+-------+------------------------+
//            | Item | Price | Special offers         |
//            +------+-------+------------------------+
//            | A    | 50    | 3A for 130, 5A for 200 |
//            | B    | 30    | 2B for 45              |
//            | C    | 20    |                        |
//            | D    | 15    |                        |
//            | E    | 40    | 2E get one B free      |
//            +------+-------+------------------------+

    @Test
    public void given5As_shouldGetDiscountFor5As() {
        assertThat(SupermarketApp.checkout("AAAAA"), is(200));
    }

    // Freebies
    @Test
    public void givenTwoEs_shouldGetAFreeB() {
        assertThat(SupermarketApp.checkout("EEB"), is(80));
    }

    @Test
    public void givenTwoEsAndTwoBs_shouldGetOneBFreeAndPayForTheOther() {
        assertThat(SupermarketApp.checkout("EEBB"), is(110));
    }



    @Test
    public void givenInvalidInput_shouldReturnMinus1() {
        assertThat(SupermarketApp.checkout("AAAABCD-"), is (-1));
    }

    @Test
    public void givenOneMultipleOfDiscountAmount_shouldReturnDiscountAmount() {
        assertThat(SupermarketApp.checkout("AAA"), is(130));
    }

    @Test
    public void givenComplexBasketWithDiscounts_shouldReturnRightAmount() {
        //
        assertThat(SupermarketApp.checkout("AAABBBBCCCDD"), is(310));
    }

    @Test
    public void givenEEEEBB_shouldReturnCorrectTotalApplyingTwoFreebies() {
        assertThat(SupermarketApp.checkout("EEEEBB"), is(160));
    }

    public void givenBEBEEE_shouldReturnCorrectTotalApplyingTwoFreebies() {
        assertThat(SupermarketApp.checkout("BEBEEE"), is(160));
    }

    // Fs
    @Test
    public void given3Fs_shouldChargePriceOf2s() {
        assertThat(SupermarketApp.checkout("FFF"), is(20));
    }

    // 3 out of 5
    @Test
    public void given3Of_STXYZ_shouldCharge45() {
        assertThat(SupermarketApp.checkout("XYZ"), is(45));
    }

    @Test
    public void given6Of_STXYZ_shouldCharge90() {
        assertThat(SupermarketApp.checkout("XYZSTZ"), is(90));
    }

    @Test
    public void SSSZ() {
        assertThat(SupermarketApp.checkout("SSSZ"), is(65));
    }
}

//| A    | 50    | 3A for 130, 5A for 200 |
//| B    | 30    | 2B for 45              |
//| C    | 20    |                        |
//| D    | 15    |                        |
//| E    | 40    | 2E get one B free      |
//| F    | 10    | 2F get one F free      |
