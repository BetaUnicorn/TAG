
package tag;

import java.util.ArrayList;
import tag.items.Item;

public class RoomInventory implements Inventory {
    private ArrayList<Item> inventory = new ArrayList<>();

    @Override
    public void addBagItem(Item item) {
        inventory.add(item);
    }

    @Override
    public void removeItem(Item item) {
        inventory.remove(item);
    }

    @Override
    public void useItem(Player p) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public ArrayList<Item> getInventory() {
        return inventory;
    }
    
    public int getInventorySize() {
        return inventory.size();
    }
    
    public String getItemName(int i) {
        return inventory.get(i).getName();
    }
    
    
    
}
