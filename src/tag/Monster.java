package tag;

import java.util.logging.Level;
import java.util.logging.Logger;
import tag.items.Item;
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
    private boolean isDead;
    private Room monsterCurrRoom;
    private MonsterInventory inventory = new MonsterInventory();

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
    public boolean takeCombatTurn(Players p) {
        if(this.health <= 0){
            return true;
        }
        try {
            Thread.sleep(1000);
        } catch (InterruptedException ex) {
            Logger.getLogger(Monster.class.getName()).log(Level.SEVERE, null, ex);
        }
        io.put(this.name + " attacked you with " + this.equippedWeapon.getName() + "\n");
        p.changeHP(-equippedWeapon.getDamage());
        io.put(p.getName() + " now has " + p.getHP() + " HP left.\n");
        io.put("----------------------------------------------------------------------------------------\n");
        return false;
    }

    public void changeHP(int dmg) {
        this.health += dmg;
    }

    @Override
    public int getHP() {
        return health;
    }
    
    @Override
    public MonsterInventory getInventory(){
        return inventory;
    }

    @Override
    public void setRoom(Room monsterCurrRoom) {
        this.monsterCurrRoom = monsterCurrRoom;
    }
    
    public void addInventory(Item item) {
        inventory.addBagItem(item);
    }
    
    public Weapon getWeapon() {
        return this.equippedWeapon;
    }

    @Override
    public Room getCurrRoom() {
        return this.monsterCurrRoom;
    }
}
