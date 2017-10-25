package tag.items;

import tag.Player;

public interface Item {
    
    public void effect(Player p);
    
    public String getName();
    
    @Override
    public String toString();
}
