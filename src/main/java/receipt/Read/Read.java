package receipt.Read;

import receipt.Exceptions.NoSuchProductIdException;
import receipt.Info;
import receipt.Models.Product;
import receipt.Models.ProductCountPromotional;
import receipt.Pair;
import receipt.Utils;

import java.util.ArrayList;
import java.util.List;

public abstract class Read implements IRead {
    public Pair<List<ProductCountPromotional>, Integer> getProducts(String[] parts) throws Exception {
        int discount = 0;
        List<ProductCountPromotional> products = new ArrayList<>();
        try {
            for (int i = 0; i < parts.length - 1; i++)
                products.add(findProduct(parts[i]));

            String[] possibleCard = parts[parts.length - 1].split(Utils.DASH_SPLITERATOR);

            if (possibleCard[0].equals("card"))
                discount = Info.cards.get(possibleCard[1]);
            else
                products.add(findProduct(parts[parts.length - 1]));
        } catch (IndexOutOfBoundsException e) {
            throw new NoSuchProductIdException(e.getMessage());
        }
        return new Pair<>(products, discount);
    }

    private static ProductCountPromotional findProduct(String part) throws NoSuchProductIdException {
        String[] params = part.split(Utils.DASH_SPLITERATOR);
        int id = Integer.parseInt(params[0]);
        int count = Integer.parseInt(params[1]);
        try {
            Product prod = Info.products[id];
            return new ProductCountPromotional(new Product(prod.getName(), prod.getPrice()), count, prod.isPromotional());
        } catch (IndexOutOfBoundsException e) {
            throw new NoSuchProductIdException(id);
        }
    }
}
