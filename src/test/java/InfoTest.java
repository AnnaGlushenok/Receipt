import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import receipt.Utils;

import static receipt.Info.*;

public class InfoTest {
   @Test
    public void productsTest() {
        Assertions.assertEquals(products[0].getName(), "Terminator");
        Assertions.assertEquals(products[0].getPrice(), 61754);

        Assertions.assertEquals(products[21].getName(), "Cocoa");
        Assertions.assertEquals(products[21].getPrice(), 834);

        Assertions.assertEquals(products[10].getName(), "Cranberry");
        Assertions.assertEquals(products[10].getPrice(), 8790);
    }

    @Test
    public void promotionalGoodsTest() {
        Assertions.assertTrue(promotionalGoods.contains("Terminator"));
        Assertions.assertTrue(promotionalGoods.contains("Grape"));
        Assertions.assertTrue(promotionalGoods.contains("Orange"));

        Assertions.assertFalse(promotionalGoods.contains("Lemon"));
    }

    @Test
    public void cardsTest() {
        Assertions.assertEquals(cards.get("6272"), 5);
        Assertions.assertEquals(cards.get("3618"), 7);
        Assertions.assertEquals(cards.get("1945"), 3);
        Assertions.assertNull(cards.get("10945"));
    }

    @Test
    public void convertExpensesTest() {
        Assertions.assertEquals(Utils.convertExpenses(10427), "104.27");
        Assertions.assertEquals(Utils.convertExpenses(104), "1.04");
        Assertions.assertEquals(Utils.convertExpenses(10), "0.10");
        Assertions.assertEquals(Utils.convertExpenses(1), "0.01");
    }
}
