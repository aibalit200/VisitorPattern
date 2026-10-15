// I encapsulate the shipping boundary (Chapter 8: Boundaries) to protect the client from transport calculations.
public class ShippingVisitor implements Visitor{
    private double totalWeight;
    private double shippingCost;

    public ShippingVisitor(){
        this.totalWeight = 0.0;
        this.shippingCost = 0.0;
    }

    public void visitBook(Book book){
        processStandardWeight(book.getWeight());
    }

    public void visitClothing(Clothing clothing){
        processStandardWeight(clothing.getWeight());
    }

    public void visitFood(Food food){
        processStandardWeight(food.getWeight());
        shippingCost = shippingCost + CartConstants.PERISHABLE_SURCHARGE;
    }

    private void processStandardWeight(double itemWeight){
        totalWeight = totalWeight + itemWeight;
        if(itemWeight > CartConstants.HEAVY_ITEM_THRESHOLD){
            shippingCost = shippingCost + CartConstants.HEAVY_ITEM_SURCHARGE;
        }
    }

    public double getTotalWeight(){
        return totalWeight;
    }

    public double getShippingCost(){
        return shippingCost;
    }
}
