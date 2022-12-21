import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import receipt.Exceptions.NoSuchDiscountCardException;
import receipt.Exceptions.NoSuchProductIdException;
import receipt.Models.Product;
import receipt.Models.ProductCountPromotional;
import receipt.Read.ReadConsole;

import java.util.ArrayList;

public class ReadConsoleTest {
    @Test
    public void getProductsPositiveTest() throws Exception {
        String[] args1 = {"3-1", "7-8", "5-3", "card-1235"};
        String[] args2 = {"0-1", "card-6272"};
        String[] args3 = {"21-1", "0-5", "10-3"};
        String[] args4 = {"21-5", "card-3618"};

        ArrayList<ProductCountPromotional> prods1 = new ArrayList<>() {{
            add(new ProductCountPromotional(new Product("Soap", 1050), 1, false));
            add(new ProductCountPromotional(new Product("Telephone", 987087), 8, false));
            add(new ProductCountPromotional(new Product("Carrot", 4894), 3, false));
        }};
        ArrayList<ProductCountPromotional> prods2 = new ArrayList<>() {{
            add(new ProductCountPromotional(new Product("Terminator", 61754), 1, true));
        }};
        ArrayList<ProductCountPromotional> prods3 = new ArrayList<>() {{
            add(new ProductCountPromotional(new Product("Cocoa",834),1,false));
            add(new ProductCountPromotional(new Product("Terminator",61754),5,true));
            add(new ProductCountPromotional(new Product("Cranberry",8790),3,false));
        }};
        ArrayList<ProductCountPromotional> prods4 = new ArrayList<>() {{
            add(new ProductCountPromotional(new Product("Cocoa",834),5,false));
        }};

        ReadConsole read = new ReadConsole();
        Assertions.assertArrayEquals(read.getProducts(args1).getFirst().toArray(), prods1.toArray());
        Assertions.assertArrayEquals(read.getProducts(args2).getFirst().toArray(), prods2.toArray());
        Assertions.assertArrayEquals(read.getProducts(args3).getFirst().toArray(), prods3.toArray());
        Assertions.assertArrayEquals(read.getProducts(args4).getFirst().toArray(), prods4.toArray());

        Assertions.assertEquals(read.getProducts(args1).getSecond(), 3);
        Assertions.assertEquals(read.getProducts(args2).getSecond(), 5);
        Assertions.assertEquals(read.getProducts(args3).getSecond(), 0);
        Assertions.assertEquals(read.getProducts(args4).getSecond(), 7);
    }

    @Test
    public void getProductsNegativeTest() throws Exception {
        String[] args1 = {"3-1", "7-8", "5-3", "card-123"};
        String[] args2 = {"50-1", "card-6272"};

        ReadConsole read = new ReadConsole();
        var noSuchDiscountCardException = Assertions.assertThrows(NoSuchDiscountCardException.class, () -> {
            read.getProducts(args1);
        });
        var noSuchProductIdException = Assertions.assertThrows(NoSuchProductIdException.class, () -> {
            read.getProducts(args2);
        });

        Assertions.assertEquals("No such discount card", noSuchDiscountCardException.getMessage());
        Assertions.assertEquals("No such product id = 50", noSuchProductIdException.getMessage());
    }
}
