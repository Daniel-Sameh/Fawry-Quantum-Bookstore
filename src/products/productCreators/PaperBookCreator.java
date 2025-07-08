package products.productCreators;

import products.Product;
import products.books.PaperBook;

import java.time.Year;
import java.util.Map;

public class PaperBookCreator implements ProductCreator{
    public PaperBookCreator(){}

    @Override
    public Product create(String id, Map<String, Object> properties){
        String title = (String) properties.get("title");
        double price = ((Number) properties.get("price")).doubleValue();
        Year year = (Year) properties.get("year");
        Product paperBook = new PaperBook(id, title, price, year);
        return paperBook;
    }
}
