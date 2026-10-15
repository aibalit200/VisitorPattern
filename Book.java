public class Book extends AbstractItem{
    public Book(String name, double basePrice, double weight) throws CartException{
        super(name, basePrice, weight);
    }

    public void accept(Visitor visitor){
        visitor.visitBook(this);
    }
}
