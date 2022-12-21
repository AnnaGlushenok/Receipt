import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import receipt.Models.Product;

public class ProductTest {
    @Test
    public void productPositiveTest() {
        Product prod1 = new Product("name", 1000);
        Product prod2 = new Product(null, 0);
        Assertions.assertEquals(prod1.getName(), "name");
        Assertions.assertEquals(prod1.getPrice(), 1000);

        Assertions.assertNull(prod2.getName());
        Assertions.assertEquals(prod2.getPrice(), 0);
    }

    @Test
    public void productNegativeTest() {
        Product prod = null;
        NullPointerException ex = Assertions.assertThrows(NullPointerException.class, () -> {
            prod.getPrice();
        });
    }

    @Test
    public void isPromotionalTest() {
        Product prod1 = new Product("Terminator", 0);
        Product prod2 = new Product("Grape", 0);
        Product prod3 = new Product("Tea", 0);

        Product prod4 = new Product("Pasta", 0);
        Product prod5 = new Product("Cocoa", 0);
        Product prod6 = new Product("Milk", 0);

        Assertions.assertTrue(prod1.isPromotional());
        Assertions.assertTrue(prod2.isPromotional());
        Assertions.assertTrue(prod3.isPromotional());

        Assertions.assertFalse(prod4.isPromotional());
        Assertions.assertFalse(prod5.isPromotional());
        Assertions.assertFalse(prod6.isPromotional());
    }
}
