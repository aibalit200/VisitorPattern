public class Food extends AbstractItem{
    public Food(String name, double basePrice, double weight) throws CartException{
        super(name, basePrice, weight);
    }

    public void accept(Visitor visitor){
        visitor.visitFood(this);
    }
}
