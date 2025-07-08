package products;

public interface BuyableProduct extends Product{
    void deliver(int quantity, String email, String address);
}
