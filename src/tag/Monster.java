package tag;

import tag.items.Weapon;
import textio.SysTextIO;
import textio.TextIO;

public class Monster implements NPC {

    private String name;
    private int health;
    private int attack;
    private Weapon equippedWeapon;
    RandomMovement move = new RandomMovement();
    private final TextIO io = new TextIO(new SysTextIO());

    public Monster(String name, int health, Weapon equippedWeapon) {
        this.name = name;
        this.health = health;
        this.equippedWeapon = equippedWeapon;
    }

    @Override
    public Room takeTurn(Room currRoom) {
        return move.takeTurn(currRoom);
    }

    @Override
    public String getName() {
        return this.name;
    }

    @Override
    public void takeCombatTurn(Players p) {
        io.put(this.name + " attacked you with " + this.equippedWeapon.getName());
        p.changeHP(-equippedWeapon.getDamage());
        io.put(p.getName() + " now has " + p.getHP() + " HP left.\n");
    }

    public void changeHP(int dmg) {
        this.health += dmg;
    }

    @Override
    public int getHP() {
        return health;
    }

}
