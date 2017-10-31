/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tag;

import java.util.ArrayList;
import tag.items.Item;

/**
 *
 * @author Martin
 */
public class MonsterInventory implements Inventory{
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
    public ArrayList<Item> getInventory() {
        return inventory;
    }
    
    
}
