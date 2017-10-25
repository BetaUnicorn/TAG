package tag.items;

import tag.Player;
import textio.SysTextIO;
import textio.TextIO;

public class Potion implements Item {
    private final TextIO io = new TextIO(new SysTextIO());
    private int healAmount;
    private String name = "Health Potion (" + healAmount + " HP)";
    
    
    public Potion(int healAmount) {
        this.healAmount = healAmount;
    }

    @Override
    public void effect(Player p) {
        p.changeHP(healAmount);
        io.put("____________________________________________________________\n");
        io.put("You healed yourself " + healAmount + " you now have " + p.getHealth() + " HP.\n");
        io.put("____________________________________________________________\n");
        
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
