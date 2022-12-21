import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import receipt.Models.Product;
import receipt.Models.ProductCountPromotional;

public class ProductCountPromotionalTest {
    @Test
    public void productTest() {
        Product prod = new Product("name", 1452);
        ProductCountPromotional prod1 = new ProductCountPromotional(prod, 10, prod.isPromotional());
        Assertions.assertEquals(prod1.getName(), "name");
        Assertions.assertEquals(prod1.getPrice(), 1452);
        Assertions.assertEquals(prod1.getCount(), 10);
    }

    @Test
    public void productNTest() {
        Product prod = new Product("name", 1452);
        ProductCountPromotional prod1 = new ProductCountPromotional(null, 0, prod.isPromotional());

        NullPointerException ex = Assertions.assertThrows(NullPointerException.class, () -> {
            prod1.getName();
        });
        Assertions.assertEquals(prod1.getCount(), 0);
    }

    @Test
    public void getTotalCostTest() {
        Product prod1 = new Product("Terminator", 61754);
        Product prod2= new Product("Orange", 4984);

        Product prod3 = new Product("Grape", 3500);
        Product prod4 = new Product("name", 1452);

        ProductCountPromotional prod5 = new ProductCountPromotional(prod1, 5, prod1.isPromotional());
        ProductCountPromotional prod6 = new ProductCountPromotional(prod2, 10, prod2.isPromotional());

        ProductCountPromotional prod7 = new ProductCountPromotional(prod3, 2, prod3.isPromotional());
        ProductCountPromotional prod8 = new ProductCountPromotional(prod4, 6, prod4.isPromotional());

        Assertions.assertEquals(prod5.getTotalCost(),277893);
        Assertions.assertEquals(prod6.getTotalCost(),44856);
        Assertions.assertEquals(prod7.getTotalCost(),7000);
        Assertions.assertEquals(prod8.getTotalCost(),8712);
    }

    @Test
    public void equalsTest(){

    }
}
