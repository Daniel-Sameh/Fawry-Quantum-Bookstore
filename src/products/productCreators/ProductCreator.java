package products.productCreators;

import products.Product;

import java.util.Map;

public interface ProductCreator {
    Product create(String id, Map<String, Object> properties);
}
