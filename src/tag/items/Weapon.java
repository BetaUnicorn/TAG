package tag.items;

import tag.Human;
import textio.SysTextIO;
import textio.TextIO;

public class Weapon implements Item {

    private final TextIO io = new TextIO(new SysTextIO());
    private String name;
    private int damage;

    public Weapon(String name, int damage) {
        this.damage = damage;
        this.name = name + "(" + damage + "DMG)";

    }

    @Override
    public void effect(Human p) {
        if (p.getEquippedWeapon() != null) {
            p.getBag().addBagItem(p.getEquippedWeapon());
        }

        p.setEquippedWeapon(this);
        io.put("____________________________________________________________\n");
        io.put("You equipped " + getName() + "\n");
        io.put("____________________________________________________________\n");

    }

    @Override
    public String getName() {
        return this.name;
    }

    public int getDamage() {
        return this.damage;
    }

    @Override
    public String toString() {

        return damage + " dmg " + name + "\n";

    }

}
