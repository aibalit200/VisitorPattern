// I restrict this class to a single responsibility (Chapter 10: Classes) so it only calculates totals.
public class PricingVisitor implements Visitor{
    private double total;

    public PricingVisitor(){
        this.total = 0.0;
    }

    public void visitBook(Book book){
        double tax = book.getBasePrice() * CartConstants.BOOK_TAX_RATE;
        total = total + book.getBasePrice() + tax;
    }

    public void visitClothing(Clothing clothing){
        double tax = clothing.getBasePrice() * CartConstants.CLOTHING_TAX_RATE;
        total = total + clothing.getBasePrice() + tax;
    }

    public void visitFood(Food food){
        double tax = food.getBasePrice() * CartConstants.FOOD_TAX_RATE;
        total = total + food.getBasePrice() + tax;
    }

    public double getTotal(){
        return total;
    }
}
