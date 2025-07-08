import inventory.Inventory;
import products.books.Book;
import products.books.DemoBook;
import products.productCreators.EBookCreator;
import products.productCreators.PaperBookCreator;
import products.productCreators.ProductCreator;
import services.BuyingService;

import java.time.Year;
import java.util.Map;

public class Main {
    public static void main(String[] args) {
        Inventory inventory = new Inventory();
        BuyingService buyingService = new BuyingService(inventory);
        ProductCreator ebookCreator= new EBookCreator();
        ProductCreator paperBookCreator= new PaperBookCreator();

        //Adding and displaying a demo book
        Book demoBook = new DemoBook("ISBN01", "Demo Book", 10, Year.of(2023));
//        demoBook.displayBook();
        inventory.addProduct("ISBN01", demoBook, 6);

        //Adding Ebook
        Map<String, Object> book1Properties = Map.of("title", "Head First Design Patterns",
                "price", 21,"year", Year.of(2015), "filetype", "pdf");
        inventory.addProduct(ebookCreator, "ISBN0", 1, book1Properties);

        //Adding Paper Book
        Map<String, Object> book2Properties = Map.of("title", "Designing Data Intensive Applications",
                "price", 15, "year", Year.of(2020));
        inventory.addProduct(paperBookCreator, "ISBN1", 12, book2Properties);


        inventory.displayProducts();

        //Buying Ebook
        double b1Cost = buyingService.buy("ISBN0", 1, "daniel@gmail.com", "Cairo, Egypt");


        //Buying Paper Book
        double b2Cost = buyingService.buy("ISBN1", 2, "test@gmail.com", "Alex, Egypt");
        System.out.println("PaperBook cost="+b2Cost);
        System.out.println("==================================");

        inventory.displayProducts();
        System.out.println("=====================================");
        inventory.returnOutdatedProducts(7);
        inventory.displayProducts();

        //will throw error due to insufficient quantity in inventory
//        double b2Cost = buyingService.buy("ISBN1", 15, "daniel@gmal.com", "Alex, Egypt");

        //Will throw error because it is a demo book
//        double demoCost= buyingService.buy("ISBN01", 1, "","");

        System.out.println("=====================================");

        //Adding and Removing a book
        Map<String, Object> book3Properties = Map.of("title", "A Great Book",
                "price", 120,"year", Year.of(2021));
        inventory.addProduct(paperBookCreator, "ISBN2", 20, book1Properties);
        inventory.removeProduct("ISBN2", 5);
        inventory.displayProducts();
        System.out.println("=====================================");
        inventory.removeProduct("ISBN2", 15);
        inventory.displayProducts();


    }
}