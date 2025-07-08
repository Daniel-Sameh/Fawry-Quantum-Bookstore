package services;

import inventory.Inventory;
import products.BuyableProduct;
import products.Product;
import products.books.EBook;

public class BuyingService {
    private Inventory inventory;
    public BuyingService(Inventory inventory){
        this.inventory=inventory;
    }
    public double buy(String id, int quantity, String email, String address){
        if (quantity <= 0) {
            throw new IllegalArgumentException("Quantity must be greater than zero");
        }

        int inStockQuantity = inventory.getProductQuantity(id);
        if (quantity>inStockQuantity){
            throw new IllegalArgumentException("Insufficient stock available for product: " + id);
        }

        Product product = inventory.getProduct(id);
        if (product==null){
            throw new IllegalArgumentException("Product not found!");
        }else if (!(product instanceof BuyableProduct)){
            throw new IllegalArgumentException("This product is not for sale");
        }

        double price = product.getPrice();
        BuyableProduct buyableProduct = (BuyableProduct) product;

        if (! (buyableProduct instanceof EBook)){
            inventory.removeProduct(id, quantity);
        }
        buyableProduct.deliver(quantity, email, address);

        return price * quantity;
    }
}
