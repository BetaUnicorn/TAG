package tag.items;

import tag.Player;

public interface Item {
    
    public void effect(Player p);
    
    public Item getItem();
    
    @Override
    public String toString();
}
