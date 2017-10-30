package tag;

import jdk.nashorn.tools.Shell;
import tag.items.Weapon;
import textio.SysTextIO;
import textio.TextIO;

public class Player {

    private String name;
    private int health = 10;
    private int bank = 0;
    private Weapon equippedWeapon;
    private final Bag bag = new Bag();
    private final Action pickUp = new Action();
    private final TextIO io = new TextIO(new SysTextIO());

    public Player(String name) {
        this.name = name;
    }

    public Bag getBag() {
        return bag;
    }

    public String getName() {
        return name;
    }

    public int getHealth() {
        return health;
    }

    public void changeHP(int hp) {
        health += hp;
        if (health > 100) {
            health = 100;
        }
    }

    public int getBank() {
        return bank;
    }

    public void addCoins(int amount) {
        bank += amount;

    }

    //Allows player to Pick up an item from a room
    public void loot(Room currRoom, Player p) {
        pickUp.itemPickup(currRoom, p);
    }

    public void useItem(Player p, Room currRoom) {
        pickUp.useItem(p, currRoom);
    }

    public void setEquippedWeapon(Weapon equippedWeapon) {
        this.equippedWeapon = equippedWeapon;
    }

    public Weapon getEquippedWeapon() {
        return equippedWeapon;
    }

    public String getWeaponEquipped() {
        if (equippedWeapon == null)  {
            return "Weapon: none\n";
        }
        else {
            return ("Weapon: " + equippedWeapon.toString() + "\n");
        }

    }

}
