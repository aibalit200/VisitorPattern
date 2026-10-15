import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

// I use copies of data (Chapter 13: Concurrency) by using a thread-safe list so one thread can add items while another thread checks out without crashing.
public class ShoppingCart{
    private List<Item> items;

    public ShoppingCart(){
        this.items = new CopyOnWriteArrayList<>();
    }

    public void addItem(Item item){
        items.add(item);
    }

    public void checkout(Visitor visitor){
        for(Item item : items){
            item.accept(visitor);
        }
    }
}
