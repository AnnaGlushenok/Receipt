package receipt.Read;

import receipt.Exceptions.NoSuchDiscountCardException;
import receipt.Exceptions.NoSuchProductIdException;
import receipt.Models.ProductCountPromotional;
import receipt.Pair;
import receipt.Utils;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.List;
import java.util.Scanner;

public class ReadFile extends Read {
    @Override
    public Pair<List<ProductCountPromotional>, Integer> getProducts(String[] args) throws Exception {
        try (Scanner scan = new Scanner(new FileReader(args[0]))) {
            return super.getProducts(scan.nextLine().split(Utils.SPACE_SPLITERATOR));
        } catch (FileNotFoundException e) {
            throw new FileNotFoundException("File not found");
        } catch (NoSuchProductIdException e) {
            throw new NoSuchProductIdException(e.getMessage());
        } catch (NullPointerException e) {
            throw new NoSuchDiscountCardException();
        } catch (Exception e) {
            throw new Exception("Unexpected error");
        }
    }
}
