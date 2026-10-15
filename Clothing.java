public class Clothing extends AbstractItem{
    public Clothing(String name, double basePrice, double weight) throws CartException{
        super(name, basePrice, weight);
    }

    public void accept(Visitor visitor){
        visitor.visitClothing(this);
    }
}
