package receipt.Read;

import receipt.Models.ProductCountPromotional;
import receipt.Pair;

import java.util.List;

public interface IRead {
    Pair<List<ProductCountPromotional>, Integer> getProducts(String[] parts) throws Exception;
}
