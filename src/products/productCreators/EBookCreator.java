package products.productCreators;

import products.Product;
import products.books.EBook;

import java.time.Year;
import java.util.Map;

public class EBookCreator implements ProductCreator{
    public EBookCreator(){}
    @Override
    public Product create(String id, Map<String, Object> properties){
        String title = (String) properties.get("title");
        double price = ((Number) properties.get("price")).doubleValue();
        Year year = (Year) properties.get("year");
        String fileType= (String) properties.get("fileType");
        Product ebook = new EBook(id, title, price, year, fileType);
        return ebook;
    }
}
