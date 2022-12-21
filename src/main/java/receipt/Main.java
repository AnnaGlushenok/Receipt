package receipt;

import receipt.Bussiness.Receipt;
import receipt.Models.Draw;

public class Main {
    public static void main(String[] args) {
        Receipt.drawReceipt(args, (prods, card) -> {
            Draw.drawToConsole(prods, card);
            Draw.drawToFile(prods, card);
        });
    }
}