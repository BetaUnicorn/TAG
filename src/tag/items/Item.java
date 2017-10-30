package tag.items;

import tag.Human;

public interface Item {
    
    public void effect(Human p);
    
    public String getName();
    
    @Override
    public String toString();
}
