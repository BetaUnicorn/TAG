package tag;

import java.util.ArrayList;
import tag.items.Item;

public class Bag {
    ArrayList<Item> items = new ArrayList<>();
    
    
    public void addBagItem(Item item) {
        items.add(item);
    }
    
    @Override
    public String toString() {
        return items.toString();
    }
}
