package tag.items;

import tag.Player;

public class Potion implements Item {
    private String name = "Health potion";
    private int healAmount = 10;
    
    
    public Potion() {}

    @Override
    public void effect(Player p) {
        p.changeHP(p, healAmount);
        
    }

    @Override
    public String toString() {
        return this.name;
    }

    @Override
    public String getName() {
        return name;
    }
    
}
