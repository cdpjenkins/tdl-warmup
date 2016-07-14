package supermarket;

import java.util.HashMap;
import java.util.Map;

public class SupermarketApp {

    private static Map<Character, SKU> skus = new HashMap<Character, SKU>() {{
        put('A', new SKU('A', 50, 3, 130));
        put('B', new SKU('B', 30, 2, 45));
        put('C', new SKU('C', 20, -1, -1));
        put('D', new SKU('D', 15, -1, -1));
    }};

//        | A    | 50    | 3A for 130     |
//        | B    | 30    | 2B for 45      |
//        | C    | 20    |                |
//        | D    | 15    |                |


    public static int checkout(String s) {

        int total = 0;

        Map<Character, Integer> quantities = new HashMap<>();

        for (int i = 0; i < s.length(); i++) {

            char c = s.charAt(i);

            if (! skus.containsKey(c) ) {
                return -1;
            } else {

                if (quantities.containsKey(c)) {
                    quantities.put(c, quantities.get(c) + 1);
                } else {
                    quantities.put(c, 1);
                }
            }
        }

        for (char c : quantities.keySet()) {
            total += skus.get(c).calculatePriceOfBasket(quantities.get(c));
        }

        return total;
    }
}


