# Quantum Bookstore

In this challenge I chose to implement the abstract factory design pattern to decouple creating different kinds of products and their types, and all client codes are coded to abstractions not implementations, this makes the code extensible with different kind of products in the future without modifications to existing working code.

## Class Diagram

![Quantum Bookstore Class Diagram](docs/QuantumBookstore.drawio%20(2).svg)

## Main function testing adding, buying, removing books

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
Book: Head First Design Patterns, Quantity: 15
=====================================
Current Inventory Products:
Book: Designing Data Intensive Applications, Quantity: 10
Book: Demo Book, Quantity: 6
```