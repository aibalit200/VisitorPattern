public interface Item{
    void accept(Visitor visitor);
    String getName();
    double getBasePrice();
    double getWeight();
}
