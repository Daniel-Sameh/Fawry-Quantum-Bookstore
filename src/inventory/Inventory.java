package inventory;

import products.BuyableProduct;
import products.Product;
import products.books.EBook;
import products.productCreators.ProductCreator;

import java.util.HashMap;
import java.util.Map;
import java.time.Year;

public class Inventory {
    Map<String, Product> products;
    Map<String, Integer> productQuantities;
    public Inventory(){
        products = new HashMap<>();
        productQuantities = new HashMap<>();
    }
    public Inventory(Map<String, Product> products, Map<String, Integer> productQuantities){
        this.products=products;
        this.productQuantities=productQuantities;
    }

    public void addProduct(ProductCreator creator, String id, int quantity, Map<String, Object> properties){
        if (quantity<=0){
            throw new IllegalArgumentException("Quantity must be greater than zero.");
        }

        if (products.containsKey(id)) {
            productQuantities.put(id, productQuantities.get(id) + quantity);
            return;
        }

        Product product = creator.create(id, properties);
        products.put(id, product);
        productQuantities.put(id, quantity);
    }

    public void addProduct(String id, Product product, int quantity){
        if (products.containsKey(id)){
            productQuantities.put(id, productQuantities.get(id) + quantity);
            return;
        }

        products.put(id, product);
        productQuantities.put(id, quantity);
    }

    public void removeProduct(String id, int quantity){
        if (quantity <= 0){
            throw new IllegalArgumentException("Quantity must be greater than zero.");
        }else if (!productQuantities.containsKey(id)){
            throw new IllegalArgumentException("Product not found in inventory.");
        }

        if (quantity>= productQuantities.getOrDefault(id, 0)) {
            products.remove(id);
            productQuantities.remove(id);
            return;
        }

        int currentQuantity = productQuantities.get(id);
        productQuantities.put(id, currentQuantity - quantity);
    }

    public Product getProduct(String id) {
        return products.getOrDefault(id, null);
    }

    public int getProductQuantity(String id){
        return productQuantities.getOrDefault(id, 0);
    }

    public void returnOutdatedProducts(int years){
        if (years <= 0) {
            throw new IllegalArgumentException("Years must be greater than zero.");
        }

        int beginYear = Year.now().getValue() - years;

        //This if we want to return it back to the admin not just delete it
//        var iterator= products.entrySet().iterator();
//        while (iterator.hasNext()){
//            Map.Entry<String, Product> entry = iterator.next();
//            Product product = entry.getValue();
//            if (product.getYear().getValue() <= beginYear) {
//
//                if (product instanceof BuyableProduct){
//                    BuyableProduct buyableProduct = (BuyableProduct) product;
//                    buyableProduct.deliver(productQuantities.get(entry.getKey()), "admin@gmail.com", "the admin address");
//                }
//
//                iterator.remove();
//            }
//        }

        products.entrySet().removeIf(entry -> entry.getValue().getYear().getValue()<= beginYear);
        productQuantities.keySet().removeIf(id -> !products.containsKey(id));

    }

    public void displayProducts(){
        System.out.println("Current Inventory Products:");
        for (var entry: products.entrySet()){
            String id = entry.getKey();
            String name = entry.getValue().getName();
            System.out.println(name+", Quantity: "+ productQuantities.get(id));
        }
//        System.out.println("======================");
    }

}
