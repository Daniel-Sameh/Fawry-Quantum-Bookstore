package services;

import products.Product;

public class ShippingService {
    public ShippingService(){}

    public void ship(Product product, String address, int quantity){
        System.out.println("Shipping "+ quantity+ "x products of: "+ product.getName()+" to "+address);
    }
}
