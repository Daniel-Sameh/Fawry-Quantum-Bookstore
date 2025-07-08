package products.books;

import products.BuyableProduct;
import products.Product;
import services.EmailingService;

import java.time.Year;

public class EBook extends Book implements BuyableProduct {
    private String fileType;
    private final EmailingService emailingService = new EmailingService();
    public EBook(String ISBN, String title, double price, Year year, String fileType) {
        super(ISBN, title, price, year);
        this.fileType=fileType;
    }

    @Override
    public void deliver(int quantity, String email, String address) {
        emailingService.email(email, null, "find in the email attached the ebook you bought from our Quantum Bookstore!");
    }


}
