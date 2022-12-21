package receipt.Models;

import receipt.Bussiness.Receipt;
import receipt.Utils;

import java.io.FileWriter;
import java.io.IOException;
import java.util.List;

public class Draw {
    public static void drawToConsole(List<ProductCountPromotional> products, int cardDiscount) {
        String receipt = new Receipt.Builder()
                .addHead()
                .addBodyHead()
                .addLine(Utils.SINGLE_LINE)
                .addBody(products)
                .addLine(Utils.DOUBLE_LINE)
                .addFooter(products, cardDiscount)
                .build();
        System.out.println(receipt);
    }

    public static void drawToFile(List<ProductCountPromotional> products, int cardDiscount) {
        try (FileWriter fw = new FileWriter("./receipt.txt")) {
            String receipt = new Receipt.Builder()
                    .addHead()
                    .addBodyHead()
                    .addLine(Utils.SINGLE_LINE)
                    .addBody(products)
                    .addLine(Utils.DOUBLE_LINE)
                    .addFooter(products, cardDiscount)
                    .build();
            fw.write(receipt);
        } catch (IOException e) {
            System.out.println("File error");
        }
    }
}
