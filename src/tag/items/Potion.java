package tag.items;

import tag.Player;

public class Potion implements Item {
    private String name = "Health potion";
    private int healAmount = 10;
    
    
    public Potion() {}

    @Override
    public void effect(Player p) {
        p.changeHP(healAmount);
        
    }

    @Override
    public Item getItem() {
        return this;
    }

    @Override
    public String toString() {
        return this.name;
    }
    
}
