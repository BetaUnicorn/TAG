package tag;

import tag.items.Weapon;
import textio.SysTextIO;
import textio.TextIO;

public class Human implements Players{

    private String name;
    private int health = 150;
    private int bank = 0;
    private Weapon equippedWeapon;
    private final Bag bag = new Bag();
    private final Action action = new Action();
    private final TextIO io = new TextIO(new SysTextIO());

    public Human(String name) {
        this.name = name;
    }

    public Bag getBag() {
        return bag;
    }

    @Override
    public String getName() {
        return name;
    }

    public int getHealth() {
        return health;
    }

    @Override
    public void changeHP(int hp) {
        health += hp;
        if (health > 150) {
            health = 150;
        }
    }

    public int getBank() {
        return bank;
    }

    public void addCoins(int amount) {
        bank += amount;

    }

    //Allows player to Pick up an item from a room
    public void loot(Room currRoom, Human p) {
        action.itemPickup(currRoom, p);
    }

    public void useItem(Human p, Room currRoom) {
        action.useItem(p, currRoom);
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

 
    @Override
    public boolean takeCombatTurn(Players monster) {
        boolean validInput = true;
        
        do {
            if(this.health <= 0){
                return true;
            }
            
            io.put("(a)ttack or (inv)entory\n");
            switch (io.get().toLowerCase()) {
                case "attack":
                case "a":
                    io.put("You attacked " + monster.getName() + " with your " + equippedWeapon.getName() + " for " + equippedWeapon.getDamage() + " damage!\n");
                    monster.changeHP(-equippedWeapon.getDamage());
                    io.put(monster.getName() + " now has " + monster.getHP() + " HP left.\n");
                    io.put("----------------------------------------------------------------------------------------\n");
                    validInput = false;
                    break;
                case "inv":
                case "inventory":
                    action.useItemCombat(this);
                    validInput = false;
                    break;
                default:
                    io.put("Please input valid command.\n");
            }
        } while (validInput);
        
        return false;
    }

    @Override
    public int getHP() {
        return health;
    }


}
