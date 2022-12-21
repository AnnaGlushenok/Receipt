package receipt.Models;

public class ProductDecorator implements IProduct {
    IProduct product;

    @Override
    public String getName() {
        return product.getName();
    }

    @Override
    public void setName(String name) {
        product.setName(name);
    }

    @Override
    public int getPrice() {
        return product.getPrice();
    }

    @Override
    public void setPrice(int price) {
        product.setPrice(price);
    }

    public ProductDecorator(IProduct product) {
        this.product = product;
    }
}
