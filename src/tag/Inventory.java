package tag;

import java.util.ArrayList;
import tag.items.Item;

public interface Inventory {
    
    public void addBagItem(Item item);
    
    public void removeItem(Item item);
    
    public void useItem(Player p);
    
    public  ArrayList<Item> getInventory();
}
