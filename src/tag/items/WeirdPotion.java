package tag.items;

import tag.Human;
import textio.SysTextIO;
import textio.TextIO;

public class WeirdPotion implements Item {
    private final TextIO io = new TextIO(new SysTextIO());
    private final int dmgAmount;
    private final String name;
    
    public WeirdPotion(int dmgAmount, String name) {
        this.dmgAmount = dmgAmount;
        this.name = (name + "(Looks like a potion, you've never seen before)");
    }

    @Override
    public void effect(Human p) {
        p.changeHP(-dmgAmount);
        io.put("____________________________________________________________\n");
        io.put("You took " + dmgAmount + " From the weird looking potion. \nYou now have " + p.getHealth() + " HP.\n");
        io.put("____________________________________________________________\n");
    }

    @Override
    public String getName() {
        return this.name;
    }
    
}
