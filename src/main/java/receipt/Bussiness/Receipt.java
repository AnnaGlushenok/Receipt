package receipt.Bussiness;

import receipt.Models.ProductCountPromotional;
import receipt.Pair;
import receipt.Read.Read;
import receipt.Read.ReadFactory;
import receipt.Utils;

import java.util.List;
import java.util.function.BiConsumer;

public class Receipt extends AbstractReceipt {
    public static void drawReceipt(String[] args, BiConsumer<List<ProductCountPromotional>, Integer> drawer) {
        Read read;

        if (args.length == 1 && args[0].matches(Utils.FILENAME_REGEX)) {
            args[0] = "./" + args[0];
            read = ReadFactory.getFromFactory("FILE");
        } else
            read = ReadFactory.getFromFactory("CONSOLE");

        try {
            Pair<List<ProductCountPromotional>, Integer> data = read.getProducts(args);
            drawer.accept(data.getFirst(), data.getSecond());
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    public static class Builder {
        private StringBuilder result = new StringBuilder();

        public Builder addHead() {
            result.append(getHead());
            return this;
        }

        public Builder addBodyHead() {
            result.append(String.format(Utils.BODY_HAT,
                            "QTY",
                            "DESCRIPTION",
                            "PRICE",
                            "TOTAL"))
                    .append("\n");
            return this;
        }

        public Builder addBody(List<ProductCountPromotional> products) {
            for (ProductCountPromotional product : products)
                result.append(getBody(product)).append("\n");
            return this;
        }

        public Builder addLine(String symbol) {
            result.append(drawLine(symbol)).append("\n");
            return this;
        }

        public Builder addFooter(List<ProductCountPromotional> products, int cardDiscount) {
            result.append(getFooter(products, cardDiscount));
            return this;
        }

        public String build() {
            return result.toString();
        }
    }
}
