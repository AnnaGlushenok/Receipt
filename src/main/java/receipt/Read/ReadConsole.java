package receipt.Read;

import receipt.Exceptions.NoSuchDiscountCardException;
import receipt.Exceptions.NoSuchProductIdException;
import receipt.Models.ProductCountPromotional;
import receipt.Pair;

import java.util.List;

public class ReadConsole extends Read {
    @Override
    public Pair<List<ProductCountPromotional>, Integer> getProducts(String[] args) throws Exception {
        try {
            return super.getProducts(args);
        } catch (NoSuchProductIdException e) {
            throw new NoSuchProductIdException(e.getMessage());
        } catch (NullPointerException e) {
            throw new NoSuchDiscountCardException();
        } catch (Exception e) {
            throw new Exception("Unexpected error");
        }
    }
}
