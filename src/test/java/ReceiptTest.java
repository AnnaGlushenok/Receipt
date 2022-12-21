import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import receipt.Bussiness.Receipt;
import receipt.Models.Product;
import receipt.Models.ProductCountPromotional;
import receipt.Utils;

import java.util.ArrayList;

public class ReceiptTest {
    @Test
    public void builderTest() {
        ArrayList<ProductCountPromotional> prods = new ArrayList<>() {{
            add(new ProductCountPromotional(new Product("Soap", 1050), 1, false));
            add(new ProductCountPromotional(new Product("Telephone", 987087), 8, false));
            add(new ProductCountPromotional(new Product("Carrot", 4894), 3, false));
        }};
        String str1111 =
                "QTY DESCRIPTION           PRICE    TOTAL\n" +
                "----------------------------------------\n" +
                " 1  Soap                $10.50    $10.50\n" +
                " 8  Telephone         $9870.87 $78966.96\n" +
                " 3  Carrot              $48.94   $146.82\n" +
                "========================================\n" +
                "TAXABLE TOT.                   $79124.28\n" +
                "DISCOUNT   5%                   $3956.21\n" +
                "TOTAL                          $75168.07";

        String builder = new Receipt.Builder()
                .addBodyHead()
                .addLine(Utils.SINGLE_LINE)
                .addBody(prods)
                .addLine(Utils.DOUBLE_LINE)
                .addFooter(prods, 5)
                .build();

        Assertions.assertEquals(builder, str1111);
    }
}
