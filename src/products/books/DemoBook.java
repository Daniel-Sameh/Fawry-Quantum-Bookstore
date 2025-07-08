package products.books;

import java.time.Year;

public class DemoBook extends Book{
    public DemoBook(String ISBN, String title, double price, Year year){
        super(ISBN, title, price, year);
    }
}
