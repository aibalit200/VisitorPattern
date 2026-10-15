// I keep the client free of type-checking logic (Chapter 17: Smells and Heuristics) by delegating entirely to the visitors.
public class ShoppingCartClient{
    private static final int BACKGROUND_CHECKOUTS = 1000;

    public static void main(String[] args){
        CartFactory factory = new CartFactory();
        ShoppingCart cart = factory.createEmptyCart();

        Thread itemAdder = new Thread(() -> {
            try{
                cart.addItem(factory.createBook("Clean Code", 45.0, 1.2));
                cart.addItem(factory.createClothing("Winter Jacket", 120.0, 6.5));
                cart.addItem(factory.createFood("Organic Apples", 8.0, 2.0));
                cart.addItem(factory.createFood("Free Sample Candy", 0.0, 0.1));
            }
            catch(CartException error){
                System.out.println("Failed to add item: " + error.getMessage());
            }
        });

        Thread concurrentChecker = new Thread(() -> {
            PricingVisitor backgroundVisitor = factory.createPricingVisitor();
            for(int i=0; i<BACKGROUND_CHECKOUTS; i++){
                cart.checkout(backgroundVisitor);
            }
        });

        itemAdder.start();
        concurrentChecker.start();

        try{
            itemAdder.join();
            concurrentChecker.join();
        }
        catch(InterruptedException error){
            System.out.println("Thread interrupted: " + error.getMessage());
        }

        System.out.println("Cart populated. Running final visitors...");

        PricingVisitor pricingVisitor = factory.createPricingVisitor();
        cart.checkout(pricingVisitor);
        System.out.println(String.format("Total Price: $%.2f", pricingVisitor.getTotal()));

        ShippingVisitor shippingVisitor = factory.createShippingVisitor();
        cart.checkout(shippingVisitor);
        System.out.println(String.format("Total Weight: %.2fkg", shippingVisitor.getTotalWeight()));
        System.out.println(String.format("Shipping Cost: $%.2f", shippingVisitor.getShippingCost()));

        ReceiptPrinterVisitor printerVisitor = factory.createReceiptVisitor();
        cart.checkout(printerVisitor);
        System.out.println(printerVisitor.getReceipt());
    }
}
