// I eliminate duplication (Chapter 12: Emergence) by extracting shared state and validation into an abstract base class.
public abstract class AbstractItem implements Item{
    private String name;
    private double basePrice;
    private double weight;

    protected AbstractItem(String name, double basePrice, double weight) throws CartException{
        if(basePrice < 0 || weight < 0){
            throw new CartException("price and weight must not be negative");
        }
        this.name = name;
        this.basePrice = basePrice;
        this.weight = weight;
    }

    public String getName(){
        return name;
    }

    public double getBasePrice(){
        return basePrice;
    }

    public double getWeight(){
        return weight;
    }
}
