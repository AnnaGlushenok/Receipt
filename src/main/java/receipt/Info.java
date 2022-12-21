package receipt;

import receipt.Models.Product;

import java.util.HashMap;
import java.util.Set;
import java.util.TreeSet;

public class Info {
    public static Product[] products = {
            new Product("Terminator", 61754),
            new Product("Milk", 7892),
            new Product("Onion", 7101),
            new Product("Soap", 1050),
            new Product("Lemon", 3204),
            new Product("Carrot", 4894),
            new Product("Computer", 799009),
            new Product("Telephone", 987087),
            new Product("Laptop", 797817),
            new Product("Grape", 3500),
            new Product("Cranberry", 8790),
            new Product("Peach", 89087),
            new Product("Orange", 4984),
            new Product("Pear", 21046),
            new Product("Blueberry", 25924),
            new Product("Rice", 66770),
            new Product("Eggs", 9849),
            new Product("Tea", 77871),
            new Product("Coffee", 87787),
            new Product("Pasta", 3540),
            new Product("Dumplings", 8487),
            new Product("Cocoa", 834)
    };

    public static Set<String> promotionalGoods = new TreeSet<>() {{
        add("Terminator");
        add("Rice");
        add("Orange");
        add("Tea");
        add("Grape");
    }};

    public static HashMap<String, Integer> cards = new HashMap<>() {{
        put("6272", 5);
        put("7632", 2);
        put("7783", 15);
        put("1235", 3);
        put("0987", 7);
        put("2432", 0);
        put("1945", 3);
        put("1893", 10);
        put("9806", 12);
        put("9145", 5);
        put("9031", 12);
        put("0323", 0);
        put("3618", 7);
    }};
}
