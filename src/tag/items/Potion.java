package tag.items;

import tag.Human;
import textio.SysTextIO;
import textio.TextIO;

public class Potion implements Item {
    private final TextIO io = new TextIO(new SysTextIO());
    private int healAmount;
    private String name;
    
    
    public Potion(int healAmount, String name) {
        this.healAmount = healAmount;
        this.name = (name + "(" + healAmount + "HP)");
    }

    @Override
    public void effect(Human p) {
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
    
    public int getHealAmount() {
        return healAmount;
    }
    
}
