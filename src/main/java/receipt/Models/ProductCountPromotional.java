package receipt.Models;

import receipt.Utils;

public class ProductCountPromotional extends ProductDecorator {
    int count;
    boolean isPromotional;

    public int getCount() {
        return count;
    }

    public int getTotalCost() {
        int cost = count * this.getPrice();
        if (isPromotional && count >= Utils.COUNT_PRODUCTS_FOR_DISCOUNT)
            cost -= cost * Utils.DISCOUNT / 100;
        return cost;
    }

    public ProductCountPromotional(IProduct product, int count, boolean isPromotional) {
        super(product);
        this.count = count;
        this.isPromotional = isPromotional;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ProductCountPromotional builder = (ProductCountPromotional) o;
        return this.getName().equals(builder.getName()) &&
                this.getPrice() == builder.getPrice() &&
                this.getCount() == builder.getCount();
    }
}
