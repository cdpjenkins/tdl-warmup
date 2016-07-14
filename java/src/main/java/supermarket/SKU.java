package supermarket;

/**
 * Created by Chris on 14/07/2016.
 */
class SKU {

    public char key;
    public int singlePrice;
    public int discountQuantity;
    public int discountPrice;

    public SKU(char key, int singlePrice, int discountQuantity, int discountPrice) {
        this.key = key;
        this.singlePrice = singlePrice;
        this.discountQuantity = discountQuantity;
        this.discountPrice = discountPrice;
    }

    public int calculatePriceOfBasket(int quantity) {

        if (quantity < discountQuantity || discountQuantity == -1) {
            return quantity * singlePrice;
        } else {
            return discountPrice + calculatePriceOfBasket(quantity - discountQuantity);
        }

    }
}
