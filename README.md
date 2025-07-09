# Quantum Bookstore

In this challenge I chose to implement the abstract factory design pattern to decouple creating different kinds of products and their types, and all client codes are coded to abstractions not implementations, this makes the code extensible with different kind of products in the future without modifications to existing working code.

## Class Diagram

![Quantum Bookstore Class Diagram](docs/QuantumBookstore.drawio%20(2).svg)

## Testing the code

### Main function testing adding, buying, removing and returning outdated books

```java
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
inventory.addProduct(paperBookCreator, "ISBN2", 20, book3Properties);
inventory.removeProduct("ISBN2", 5);
inventory.displayProducts();
System.out.println("=====================================");
inventory.removeProduct("ISBN2", 15);
inventory.displayProducts();
```

### Console Output without errors:

```
Current Inventory Products:
Book: Designing Data Intensive Applications, Quantity: 12
Book: Head First Design Patterns, Quantity: 1
Book: Demo Book, Quantity: 6
=====================================
Sending email to daniel@gmail.com...
find in the email attached the ebook you bought from our Quantum Bookstore!
Sent the email successfully...
=====================================
Shipping 2x products of: Book: Designing Data Intensive Applications to Alex, Egypt
PaperBook cost=30.0
==================================
Current Inventory Products:
Book: Designing Data Intensive Applications, Quantity: 10
Book: Head First Design Patterns, Quantity: 1
Book: Demo Book, Quantity: 6
=====================================
Current Inventory Products:
Book: Designing Data Intensive Applications, Quantity: 10
Book: Demo Book, Quantity: 6
=====================================
Current Inventory Products:
Book: Designing Data Intensive Applications, Quantity: 10
Book: Demo Book, Quantity: 6
Book: A Great Book, Quantity: 15
=====================================
Current Inventory Products:
Book: Designing Data Intensive Applications, Quantity: 10
Book: Demo Book, Quantity: 6
```