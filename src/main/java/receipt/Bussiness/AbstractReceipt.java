package receipt.Bussiness;

import receipt.Models.ProductCountPromotional;
import receipt.Utils;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

public abstract class AbstractReceipt {
    protected static String getHead() {
        return String.format(Utils.HAT_RECEIPT,
                "CASH RECEIPT",
                "SUPERMARKET 123",
                "12, MILKYWAY Galaxy/ Earth",
                "Tel :123-456-7890",
                "CASHIER: No.1520",
                "DATE: ", new SimpleDateFormat("dd/MM/yyyy").format(new Date()),
                "TIME: ", new SimpleDateFormat("HH:mm:ss").format(new Date()) + "\n");
    }

    protected static String drawLine(String symbol) {
        return symbol.repeat(Utils.LINE_LENGTH);
    }

    protected static String getBody(ProductCountPromotional product) {
        int cost = product.getTotalCost();
        return String.format(Utils.BODY,
                product.getCount(),
                product.getName(),
                Utils.CURRENCY + Utils.convertExpenses(product.getPrice()),
                Utils.CURRENCY + Utils.convertExpenses(cost));
    }

    protected static String getFooter(List<ProductCountPromotional> products, int cardDiscount) {
        int totalSum = 0;
        for (ProductCountPromotional product : products)
            totalSum += product.getTotalCost();

        int discountSum = totalSum * cardDiscount / 100;
        return String.format(Utils.FOOTER_RECEIPT,
                Utils.CURRENCY + Utils.convertExpenses(totalSum),
                cardDiscount,
                Utils.CURRENCY + Utils.convertExpenses(discountSum),
                Utils.CURRENCY + Utils.convertExpenses(totalSum - discountSum));
    }

}
