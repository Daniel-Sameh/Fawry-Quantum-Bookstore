package products.books;

import products.Product;

import java.time.Year;

public abstract class Book implements Product{
    String ISBN;
    String title;
    double price;
    Year year;
    public Book (String ISBN, String title, double price, Year year) {
        this.ISBN = ISBN;
        this.title = title;
        this.price = price;
        this.year = year;
    }
    public String getISBN() {
        return ISBN;
    }
    public String getTitle() {
        return title;
    }
    @Override
    public String getName() {
        return "Book: " + title;
    }
    @Override
    public double getPrice() {
        return price;
    }

    @Override
    public Year getYear() {
        return year;
    }
    public void displayBook(){
        System.out.println("Displaying the demo book: "+ title);
        System.out.println("Title: "+title);
        System.out.println("..............................");
    }

}
