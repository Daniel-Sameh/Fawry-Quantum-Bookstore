package products.books;

import products.BuyableProduct;
import products.Product;
import services.ShippingService;

import java.time.Year;

public class PaperBook extends Book implements BuyableProduct {
    private final ShippingService shippingService = new ShippingService();

    public PaperBook(String ISBN, String title, double price, Year year) {
        super(ISBN, title, price, year);
    }

    @Override
    public void deliver(int quantity, String email, String address) {
        shippingService.ship(this, address, quantity);
    }

}
