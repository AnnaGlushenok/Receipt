import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import receipt.Exceptions.NoSuchDiscountCardException;
import receipt.Exceptions.NoSuchProductIdException;
import receipt.Models.Product;
import receipt.Models.ProductCountPromotional;
import receipt.Read.ReadFile;

import java.io.FileNotFoundException;
import java.nio.file.Paths;
import java.util.ArrayList;

public class ReadFileTest {
    @Test
    public void getProductsPositiveTest() throws Exception {
        String absolutePath = Paths.get("src", "test", "resources").toFile().getAbsolutePath();

        String[] path1 = {absolutePath + "\\prod1.txt"};
        String[] path2 = {absolutePath + "\\prod2.txt"};
        String[] path3 = {absolutePath + "\\prod3.txt"};
        String[] path4 = {absolutePath + "\\prod4.txt"};

        ArrayList<ProductCountPromotional> prods1 = new ArrayList<>() {{
            add(new ProductCountPromotional(new Product("Onion",7101),5,false));
            add(new ProductCountPromotional(new Product("Milk",7892),3,false));
            add(new ProductCountPromotional(new Product("Lemon",3204),7,false));
            add(new ProductCountPromotional(new Product("Soap",1050),9,false));
            add(new ProductCountPromotional(new Product("Terminator",61754),1,true));
        }};
        ArrayList<ProductCountPromotional> prods2 = new ArrayList<>() {{
            add(new ProductCountPromotional(new Product("Terminator",61754),1,true));
        }};
        ArrayList<ProductCountPromotional> prods3 = new ArrayList<>() {{
            add(new ProductCountPromotional(new Product("Cocoa",834),1,false));
            add(new ProductCountPromotional(new Product("Terminator",61754),5,true));
            add(new ProductCountPromotional(new Product("Cranberry",8790),3,false));
        }};
        ArrayList<ProductCountPromotional> prods4 = new ArrayList<>() {{
            add(new ProductCountPromotional(new Product("Cocoa",834),5,false));
        }};

        ReadFile read = new ReadFile();
        Assertions.assertArrayEquals(read.getProducts(path1).getFirst().toArray(), prods1.toArray());
        Assertions.assertArrayEquals(read.getProducts(path2).getFirst().toArray(), prods2.toArray());
        Assertions.assertArrayEquals(read.getProducts(path3).getFirst().toArray(), prods3.toArray());
        Assertions.assertArrayEquals(read.getProducts(path4).getFirst().toArray(), prods4.toArray());

        Assertions.assertEquals(read.getProducts(path1).getSecond(), 2);
        Assertions.assertEquals(read.getProducts(path2).getSecond(), 5);
        Assertions.assertEquals(read.getProducts(path3).getSecond(), 0);
        Assertions.assertEquals(read.getProducts(path4).getSecond(), 7);
    }

    @Test
    public void getProductsNegativeTest() {
        String absolutePath = Paths.get("src", "test", "resources").toFile().getAbsolutePath();
        String[] path1 = {"./file.txt"};
        String[] path2 = {absolutePath + "\\prod5.txt"};
        String[] path3 = {absolutePath + "\\prod6.txt"};
        ReadFile read = new ReadFile();
        FileNotFoundException ex1 = Assertions.assertThrows(FileNotFoundException.class, () -> {
            read.getProducts(path1);
        });
        NoSuchProductIdException ex2 = Assertions.assertThrows(NoSuchProductIdException.class, () -> {
            read.getProducts(path2);
        });
        NoSuchDiscountCardException ex3 = Assertions.assertThrows(NoSuchDiscountCardException.class, () -> {
            read.getProducts(path3);
        });
        Assertions.assertEquals(ex1.getMessage(), "File not found");
        Assertions.assertEquals(ex2.getMessage(), "No such product id = 210");
        Assertions.assertEquals(ex3.getMessage(), "No such discount card");
    }
}
