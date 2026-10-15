// I separate construction from use (Chapter 11: Systems) by using a factory to build the cart and visitors.
public class CartFactory{
    public ShoppingCart createEmptyCart(){
        return new ShoppingCart();
    }

    public Book createBook(String name, double price, double weight) throws CartException{
        return new Book(name, price, weight);
    }

    public Clothing createClothing(String name, double price, double weight) throws CartException{
        return new Clothing(name, price, weight);
    }

    public Food createFood(String name, double price, double weight) throws CartException{
        return new Food(name, price, weight);
    }

    public PricingVisitor createPricingVisitor(){
        return new PricingVisitor();
    }

    public ShippingVisitor createShippingVisitor(){
        return new ShippingVisitor();
    }

    public ReceiptPrinterVisitor createReceiptVisitor(){
        return new ReceiptPrinterVisitor();
    }
}
